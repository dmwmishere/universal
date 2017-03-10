package org.dmwm.universal.sys2.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;
import org.dmwm.universal.core.utils.database.QueryProcessor;
import org.dmwm.universal.sys1.data.xsds.MemeInfoType;
import org.springframework.beans.factory.annotation.Autowired;

public class MemeDBInterfaceImpl implements Processor {

	@Autowired
	QueryProcessor qp;

	private static final Logger log = Logger.getLogger(MemeDBInterfaceImpl.class);

	@Override
	public void process(Exchange msg) throws Exception {
		MemeInfoType mit = msg.getIn().getBody(MemeInfoType.class);
		log.info("Inserting a meme: " + mit.getName() + " - " + mit.getYear() + " - " + mit.getType() + " - " + mit.getOrigin() + " - " + mit.getStatus());
		qp.insertMeme(mit);

		msg.getOut().setBody("Success");
	}

}
