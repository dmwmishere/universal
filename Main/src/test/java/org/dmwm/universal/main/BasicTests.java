package org.dmwm.universal.main;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.dmwm.universal.core.data.xsds.Response;
import org.dmwm.universal.core.stats.StatsHolderImpl;
import org.dmwm.universal.core.utils.database.QueryProcessor;
import org.dmwm.universal.core.utils.xml.JQuickDocumentParser;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ctc.wstx.util.StringUtil;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/resources/applicationContext.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BasicTests extends TestCase {

	private static final Logger log = Logger.getLogger(BasicTests.class);

	@Resource(name = "qpi1")
	QueryProcessor qp;

	@Autowired
	StatsHolderImpl sh;	
	
//	static Document doc;
	
	static Document jdoc;
	
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public BasicTests() {
	}

	/**
	 * @return the suite of tests being tested
	 */
	// public static Test suite()
	// {
	// return new TestSuite( AppTest.class );
	// }

	@Test
	public void test1_stats_InputMetric() throws Exception {
		sh.putStat("testMetric");
		assertTrue(sh.getAllStats().containsKey("testMetric"));
	}

	@Test
	public void test2_1_stats_InfluxOutputMetric() throws Exception {
		String testOutput = sh.getAllInfluxStats(true, 10);
		log.info(testOutput);
		assertEquals(true, testOutput.contains("operation="));
	}
	
	@Test
	public void test2_2_stats_Operations() throws Exception {
		String name = "DankRq";
		String id = "666";
		sh.startOperation(id);
		Thread.sleep(300);
		long responseTime = sh.stopOperation(id);
		assertEquals(true, responseTime >= 300 & responseTime <= 320);
		sh.putOperation(id, name, System.currentTimeMillis(), responseTime);
		String influxData = sh.getAllInfluxOperations(10);
		log.info("TEST: OPERATIONS: " + influxData);
		assertEquals(true, influxData.contains("Name=DankRq"));
	}
	
	@Test
	public void test2_3_stats_multiple_Operations() throws Exception {
		String name = "DankRq";
		for(int i = 0; i < 20; i++){
		String id = UUID.randomUUID().toString();
		sh.startOperation(id);
		long responseTime = sh.stopOperation(id);
		sh.putOperation(id, name, System.currentTimeMillis(), responseTime);
		}
		String influxData = sh.getAllInfluxOperations(3);
		log.info("TEST: OPERATIONS: \n" + influxData);
		assertEquals(true, StringUtils.countMatches(influxData, name) == 3);
	}
	
	@Test
	public void test3_stats_Set2zero() throws Exception {
		assertEquals(true, sh.getAllInfluxStats(true, 10) == "");
	}

	@Test
	public void test4_sql_checkSQLintegration() throws Exception {
		Response rs = qp.getMeme(1);
		assertNotNull(rs.getMemeInfo());
		assertEquals(true, "Forever Alone".equals(rs.getMemeInfo().getName()));
	}
	
	
//	@Test
//	public void test5_xml_parseString() throws Exception{
//		String xmlStr = FileUtils.readFileToString(new File(this.getClass().getResource("/xmlData/sample1.xml").toURI()), "utf-8");
//		doc = QuickDocumentParser.parseFromString(xmlStr);
//		assertNotNull(doc);
//		String status = QuickDocumentParser.getByTag(doc.getDocumentElement(), "Status");
//		log.info("TEST: STATUS VALUE = " + status);
//		assertEquals(true, "Confirmed".equals(status));
//	}
//	
//	@Test
//	public void test6_xml_setXmlValue(){
//		QuickDocumentParser.setTagValue(doc.getDocumentElement(), "Year", "666");
//		assertEquals(true, "666".equals(QuickDocumentParser.getByTag(doc.getDocumentElement(), "Year")));
//	}
	
	@Test
	public void test5_xml_jdom_parseString() throws Exception{
		String xmlStr = FileUtils.readFileToString(new File(this.getClass().getResource("/xmlData/sample1.xml").toURI()), "utf-8");
		jdoc = JQuickDocumentParser.parseFromString(xmlStr);
		assertNotNull(jdoc);
		String status = JQuickDocumentParser.getByTag(jdoc.getRootElement(), "Status");
		log.info("TEST: STATUS VALUE = " + status);
		assertEquals(true, "Confirmed".equals(status));
	}
	
	@Test
	public void test6_xml_jdom_setXmlValue(){
		JQuickDocumentParser.setTagValue(jdoc.getRootElement(), "Year", "666");
		assertEquals(true, "666".equals(JQuickDocumentParser.getByTag(jdoc.getRootElement(), "Year")));
	}

	@Test
	public void test7_xml_jdom_document2string() throws Exception{
		log.info("TEST: DOC2STRING = " + JQuickDocumentParser.doc2string(jdoc));
		String xmlStr = FileUtils.readFileToString(new File(this.getClass().getResource("/xmlData/sample1.xml").toURI()), "utf-8");
		new CompareXMLs(xmlStr, JQuickDocumentParser.doc2string(jdoc), true, "Year");
	}
	
	@Test
	public void test8_xml_jdom_mergeDocs() {
		Element te = new Element("DANK");
		te.setAttribute(new Attribute("id", "1"));
		te.addContent(new Element("BlazeIt").setText("4/20"));
		
		Element root = jdoc.getRootElement();
		log.info("TEST: ROOT = " + root.getChildren());
		List<Element> ch = root.getChildren();
		assertNotNull(ch.get(0));
		JQuickDocumentParser.mergeDocs(te, ch.get(1));
		log.info("TEST: MERGED = " + JQuickDocumentParser.doc2string(jdoc));
	}
	
}
