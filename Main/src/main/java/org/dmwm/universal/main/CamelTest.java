package org.dmwm.universal.main;

import org.apache.camel.spring.Main;
import org.apache.log4j.Logger;

public class CamelTest {

	private static final Logger log = Logger.getLogger(CamelTest.class);

	public static void main(String[] args) throws Exception {
		log.trace("test");
		log.warn(
				"STARTING THE APP...\nRequired systems (docker containers):\n\tactivemq(activemq),\n\thsqldb(chsqldb),\n\tkafka(ckafka),\n\tinflux (cinflux)");
		Main main = new Main();
		main.setApplicationContextUri("applicationContext.xml");
		main.start();
	}
}