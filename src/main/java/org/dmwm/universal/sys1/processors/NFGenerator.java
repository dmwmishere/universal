package org.dmwm.universal.sys1.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;
import org.dmwm.universal.core.stats.StatsHolder;
import org.dmwm.universal.sys1.data.xsds.Memedesc;
import org.springframework.beans.factory.annotation.Autowired;

public class NFGenerator implements Processor {
	
	@Autowired
	StatsHolder sh;
	
	private static final Logger log = Logger.getLogger(NFGenerator.class);
	
	@Override
	public void process(Exchange msg) throws Exception {
		Memedesc md = msg.getIn().getBody(Memedesc.class);
		log.info("Generating notification for " + md.getUuid() + "...");
		msg.getOut().setBody(md);
		sh.putStat("NOTIF");
		sh.startOperation(md.getUuid());
	}
}
