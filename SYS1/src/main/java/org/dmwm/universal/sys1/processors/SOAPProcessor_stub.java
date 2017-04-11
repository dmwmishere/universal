package org.dmwm.universal.sys1.processors;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.cxf.CxfPayload;
import org.apache.camel.converter.jaxp.XmlConverter;
import org.apache.cxf.binding.soap.SoapHeader;
import org.apache.log4j.Logger;
import org.dmwm.universal.core.data.xsds.MemeInfoType;
import org.dmwm.universal.core.stats.StatsHolder;
import org.dmwm.universal.core.utils.database.QueryProcessorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class SOAPProcessor_stub implements Processor {

	@Autowired
	StatsHolder sh;

	@Autowired
	QueryProcessorImpl qp;

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
