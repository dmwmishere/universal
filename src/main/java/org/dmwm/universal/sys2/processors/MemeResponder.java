package org.dmwm.universal.sys2.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;
import org.dmwm.universal.core.stats.StatsHolder;
import org.dmwm.universal.core.utils.database.QueryProcessor;
import org.dmwm.universal.core.utils.xml.QuickDocumentParser;
import org.dmwm.universal.sys1.data.xsds.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Element;

public class MemeResponder implements Processor {
	
	@Autowired
	StatsHolder sh;
	
	@Autowired
	QueryProcessor qp;
	
	private static final Logger log = Logger.getLogger(MemeRequestHandler.class);
	
	@Override
	public void process(Exchange msg) throws Exception {
		String request = msg.getIn().getBody(String.class);
		log.debug("SYS-2: RESPONDING...");
		Element el = QuickDocumentParser.parseFromString(request).getDocumentElement()	;
		String uid = QuickDocumentParser.getByTag(el, "uuid");
		
		sh.putStat("SYS-2-RS");
		Response rs = qp.getMeme(Integer.parseInt(QuickDocumentParser.getByTag(el, "id")));
		rs.setRqUID(uid);
		msg.getOut().setBody(rs);
		sh.stopOperation(rs.getRqUID());
	}

}
