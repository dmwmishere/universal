package org.dmwm.universal.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.dmwm.universal.core.utils.xml.QuickDocumentParser;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/resources/applicationContext.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RouteTest extends TestCase {

	private static final Logger log = Logger.getLogger(BasicTests.class);
	
	@EndpointInject(uri = "mock:result_sys1_message")
	protected MockEndpoint mockNotif;

	@EndpointInject(uri = "mock:result_sys1_file")
	protected MockEndpoint mockFile;

	@EndpointInject(uri = "mock:result_sys2_response")
	protected MockEndpoint mockResponse;
	
	@Produce(uri = "direct:test_input1")
	protected ProducerTemplate sys1produce;
	
	@Produce(uri = "direct:test_input2")
	protected ProducerTemplate sys2produce;

	static String system1request;
	
	static String rqUID;
	
	@Test
	public void test1_route_sys1_income2notif() throws Exception {
		mockNotif.expectedMessageCount(1);
		List<Integer> li = new ArrayList<>();
		li.add(0);
		li.add(1337);
		sys1produce.sendBody(li);
		String actualResponse = mockNotif.getExchanges().get(0).getIn().getBody(String.class);
		String requiredResponse = FileUtils.readFileToString(new File(this.getClass().getResource("/Responses/MemeRQ.xml").toURI()), "utf-8");
		
		log.info("TEST: RECEIVED AT MOCK: " + actualResponse);
		log.info("TEST: REQUIRED: " + requiredResponse);
		mockNotif.assertIsSatisfied();
		new CompareXMLs(requiredResponse, actualResponse, true, "uuid", "crc32");
		system1request = actualResponse;
		rqUID = new String(QuickDocumentParser.getByTag(QuickDocumentParser.parseFromString(actualResponse).getDocumentElement(), "uuid"));
		log.info("TEST: EXTRACTED UUID = " + rqUID);
	}
	
	@Test
	public void test2_route_sys1_income2file() {
		mockFile.expectedMessageCount(1);
		String fileName = mockFile.getExchanges().get(0).getIn().getHeader(Exchange.FILE_NAME).toString();
		log.info("TEST: FILE NAME AT MOCK = " + fileName);
		assertEquals(true, fileName.contains(rqUID));
	}
	
	@Test
	public void test3_route_sys2_income2notif() throws Exception{
		mockResponse.expectedMessageCount(1);
		sys2produce.sendBody(system1request);
		String actualResponse = mockResponse.getExchanges().get(0).getIn().getBody(String.class);
		String requiredResponse = FileUtils.readFileToString(new File(this.getClass().getResource("/Responses/MemeRS.xml").toURI()), "utf-8");
		log.info("TEST: RECEIVED AT MOCK: " + actualResponse);
		log.info("TEST: REQUIRED: " + requiredResponse);
		mockNotif.assertIsSatisfied();
		new CompareXMLs(requiredResponse, actualResponse, true, "RqUID");
	}
	
}
