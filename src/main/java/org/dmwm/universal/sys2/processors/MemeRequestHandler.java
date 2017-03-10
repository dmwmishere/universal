package org.dmwm.universal.sys2.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;
import org.dmwm.universal.core.stats.StatsHolder;
import org.dmwm.universal.core.utils.xml.QuickDocumentParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;

public class MemeRequestHandler implements Processor{
	@Autowired
	StatsHolder sh;
	

	
	private static final Logger log = Logger.getLogger(MemeRequestHandler.class);
	
	@Override
	public void process(Exchange msg) throws Exception {
		String request = msg.getIn().getBody(String.class);
		log.debug("SYS-2 RECEIVED: " + request);
		
		Document doc = QuickDocumentParser.parseFromString(request);
		String fileName = QuickDocumentParser.getByTag(doc.getDocumentElement(), "uuid") + 
				"." + QuickDocumentParser.getByTag(doc.getDocumentElement(), "extension").toLowerCase();
		int id = Integer.parseInt(QuickDocumentParser.getByTag(doc.getDocumentElement(), "id"));
		log.info("SYS-2: file=" + fileName + ", id=" + id);
		msg.getOut().setHeader(Exchange.FILE_NAME, fileName);
		msg.getOut().setBody(request);
		sh.putStat("SYS-2-PROCESSOR");
		
	}

}
