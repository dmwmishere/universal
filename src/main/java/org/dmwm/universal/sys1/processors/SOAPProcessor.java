package org.dmwm.universal.sys1.processors;

import java.util.List;
import java.util.UUID;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;
import org.dmwm.universal.core.stats.StatsHolder;
import org.dmwm.universal.sys1.data.xsds.ExtensionType;
import org.dmwm.universal.sys1.data.xsds.Memedesc;
import org.dmwm.universal.sys1.data.xsds.TFileType;
import org.springframework.beans.factory.annotation.Autowired;

public class SOAPProcessor implements Processor {
	
	@Autowired
	StatsHolder sh;
	
	private static final Logger log = Logger.getLogger(SOAPProcessor.class);
	
	@Override
	public void process(Exchange msg) throws Exception {
		try{
		log.info("Calling " + msg.getIn().getHeader("operationName"));
	//	SOAPMessage smsg = (SOAPMessage)msg.getIn().getBody(List.class).get(0);
		int memeid = (Integer)msg.getIn().getBody(List.class).get(0);
		int dankLevel = (Integer)msg.getIn().getBody(List.class).get(1);
		log.info("The meme is " + memeid);
		log.info("Its dank level is " + dankLevel);
	//	log.info("Got a meme: " + smsg.getSOAPPart().getEnvelope().getBody().getElementsByTagName("meme").item(0).getTextContent());
		Memedesc md = new Memedesc();
		md.setId(memeid);
		md.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
		md.setDankLevel(dankLevel);
		TFileType ft = new TFileType();
		ft.setSize(1337);
		ft.setExtension(ExtensionType.ZIP);
		md.setFileType(ft);
		msg.getOut().setBody(md);
		sh.putStat("WS-MemeRequest");
		}catch(Throwable t){
			t.printStackTrace();
		}
	}

}
