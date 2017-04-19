package org.dmwm.universal.sys1.processors;

import javax.annotation.Resource;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;
import org.dmwm.universal.core.stats.StatsHolder;
import org.dmwm.universal.core.utils.database.QueryProcessor;
import org.springframework.beans.factory.annotation.Autowired;

public class SOAPProcessor_stub implements Processor {

	@Autowired
	StatsHolder sh;

	@Resource(name="qpi1")
	QueryProcessor qp;

	private static final Logger log = Logger.getLogger(SOAPProcessor_stub.class);

	@Override
	public void process(Exchange msg) throws Exception {

		// msg.getOut().setBody(
		// "<soapenv:Envelope
		// xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"
		// xmlns:web=\"http://www.webserviceX.NET\">"
		// + "<soapenv:Header/>" + "<soapenv:Body>" + "<web:GetCitiesByCountry>"
		// + "<web:CountryName>Russia</web:CountryName>" +
		// "</web:GetCitiesByCountry>" + "</soapenv:Body>"
		// + "</soapenv:Envelope>");

//		msg.getOut().setBody(
//				"<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:smar=\"http://smartbear.com\">"
//						+ "<soapenv:Header/>" + "<soapenv:Body>" + "<smar:GetCurrentTime>ewq</smar:GetCurrentTime>"
//						+ "</soapenv:Body>" + "</soapenv:Envelope>");
		log.info("Adding a maymay...");

		
		msg.getOut().setBody("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ws=\"http://ws.sys2.universal.dmwm.org/\" xmlns:dat=\"http://www.example.org/dataTypes\">" +
				"<soapenv:Header/>" +
				"<soapenv:Body>" +
				"<ws:insertMeme>" +
				"<MemeInfo>" +
				"<dat:Name>FaZe</dat:Name>" +
				"<dat:Year>2015</dat:Year>" +
//				"<dat:Type>Shitposting</dat:Type>" +
//				"<dat:Origin>MLG</dat:Origin>" +
//				"<dat:Status>Confirmed</dat:Status>" +
//				"<dat:Badge>MLG</dat:Badge>" +
				"</MemeInfo>" +
				"</ws:insertMeme>" +
				"</soapenv:Body>" +
				"</soapenv:Envelope>");
		
		sh.putStat("soap_stub");
	}

}
