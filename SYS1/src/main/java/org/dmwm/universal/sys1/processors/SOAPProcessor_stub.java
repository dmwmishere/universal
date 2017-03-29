package org.dmwm.universal.sys1.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;
import org.dmwm.universal.core.stats.StatsHolder;
import org.dmwm.universal.core.utils.database.QueryProcessorImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class SOAPProcessor_stub implements Processor {

	@Autowired
	StatsHolder sh;
	
	@Autowired
	QueryProcessorImpl qp;
	
	private static final Logger log = Logger.getLogger(SOAPProcessor_stub.class);
	
	@Override
	public void process(Exchange msg) throws Exception {
		
		log.warn("at soap processor stub");
		long start = System.currentTimeMillis();
		msg.getOut().setBody(qp.getMeme(1));
		
		Thread.sleep(1000);
		
		log.info("Static resource resp = " + (System.currentTimeMillis() - start));
		
		sh.putStat("soap_stub");
	}

}
