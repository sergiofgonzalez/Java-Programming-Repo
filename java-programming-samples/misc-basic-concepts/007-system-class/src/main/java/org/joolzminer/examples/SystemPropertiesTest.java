package org.joolzminer.examples;

import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SystemPropertiesTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(SystemPropertiesTest.class);
	
	
	public static void main(String[] args) {
		for (Entry<Object, Object> property : System.getProperties().entrySet()) {
			LOGGER.info("{}={}", property.getKey(), property.getValue());
		}
		
		String javaVersion = System.getProperty("java.version", "unknown");
		LOGGER.info("User is running Java {}", javaVersion);
		
		System.setProperty("java.revision", javaVersion.split("_")[1]);
		LOGGER.info("java.revision={}", System.getProperty("java.revision", "unknown"));
	}
}
