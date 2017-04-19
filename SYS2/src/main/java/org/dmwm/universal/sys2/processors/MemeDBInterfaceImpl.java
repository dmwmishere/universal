package org.dmwm.universal.sys2.processors;

import javax.annotation.Resource;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;
import org.dmwm.universal.core.data.xsds.MemeInfoType;
import org.dmwm.universal.core.utils.database.QueryProcessor;

public class MemeDBInterfaceImpl implements Processor {

	@Resource(name="qpi1")
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
