package org.dmwm.universal.main;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.log4j.Logger;
import org.dmwm.universal.core.data.xsds.Memedesc;
import org.dmwm.universal.core.data.xsds.Response;
import org.dmwm.universal.core.stats.StatsHolderImpl;
import org.dmwm.universal.core.utils.database.QueryProcessor;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

	@EndpointInject(uri = "mock:result_sys1_message")
    protected MockEndpoint resultEndpoint;
 
    @Produce(uri = "direct:test_input1")
    protected ProducerTemplate template;
	
	@Test
	public void test5_route_sys1_notif() throws Exception {
		resultEndpoint.expectedMessageCount(1);
		Memedesc md = new Memedesc();
		md.setId(1);
		md.setUuid("666");
		md.setDankLevel(1337);
		List<Integer> li = new ArrayList<>();
		li.add(0);
		li.add(1337);
		template.sendBody(li);
		log.info("RECEIVED AT MOCK: " + resultEndpoint.getExchanges().get(0).getIn().getBody(String.class));
		resultEndpoint.assertIsSatisfied();
	}
	
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
	public void test1_InputMetric() throws Exception {
		sh.putStat("testMetric");
		assertTrue(sh.getAllStats().containsKey("testMetric"));
	}

	@Test
	public void test2_InfluxOutputMetric() throws Exception {
		String testOutput = sh.getAllInfluxStats(true, 10);
		log.info(testOutput);
		assertEquals(true, testOutput.contains("operation="));
	}

	@Test
	public void test3_Set2zero() throws Exception {
		assertEquals(true, sh.getAllInfluxStats(true, 10) == "");
	}

	@Test
	public void test4_checkSQLintegration() throws Exception {
		Response rs = qp.getMeme(1);
		assertNotNull(rs.getMemeInfo());
		assertEquals(true, "Forever Alone".equals(rs.getMemeInfo().getName()));
	}
}
