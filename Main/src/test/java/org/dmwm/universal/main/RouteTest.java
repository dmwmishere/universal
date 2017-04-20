package org.dmwm.universal.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.custommonkey.xmlunit.XMLTestCase;
import org.custommonkey.xmlunit.XMLUnit;
import org.dmwm.universal.core.data.xsds.Memedesc;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/resources/applicationContext.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RouteTest extends XMLTestCase {

	private static final Logger log = Logger.getLogger(BasicTests.class);
	
	@EndpointInject(uri = "mock:result_sys1_message")
	protected MockEndpoint resultEndpoint;

	@Produce(uri = "direct:test_input1")
	protected ProducerTemplate template;

	@Test
	public void test5_route_sys1_income2notif() throws Exception {
		XMLUnit.setIgnoreWhitespace(true);
		XMLUnit.setIgnoreDiffBetweenTextAndCDATA(true);
		resultEndpoint.expectedMessageCount(1);
		Memedesc md = new Memedesc();
		md.setId(1);
		md.setUuid("666");
		md.setDankLevel(1337);
		List<Integer> li = new ArrayList<>();
		li.add(0);
		li.add(1337);
		template.sendBody(li);
		String actualResponse = resultEndpoint.getExchanges().get(0).getIn().getBody(String.class);
		String requiredResponse = FileUtils.readFileToString(new File(this.getClass().getResource("/Responses/MemeRS.xml").toURI()));
		
		log.info("RECEIVED AT MOCK: " + actualResponse);
		log.info("REQUIRED: " + requiredResponse);
		resultEndpoint.assertIsSatisfied();
		this.assertXMLEqual(actualResponse, requiredResponse);
	}

}
