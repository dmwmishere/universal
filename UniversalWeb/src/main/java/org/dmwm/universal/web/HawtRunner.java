package org.dmwm.universal.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import io.hawt.embedded.Main;

public class HawtRunner implements ServletContextListener {

	private static final Logger log = Logger.getLogger(HawtRunner.class);
	static Main main = new Main();
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		log.info("Starting HAWT interface...");
		
		main.setPort(9999);
		
		try {
			main.run();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

}
