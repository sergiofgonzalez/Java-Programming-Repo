package org.joolzminer.examples;

import java.util.Date;

interface Logger {
	void log(String message);
}

public class LocalClassTest1 {
	String appStartTime = (new Date()).toString();
	
	public Logger getLogger() {
		class LoggerImpl implements Logger {

			@Override
			public void log(String message) {
				System.out.println(appStartTime + " : " + message);
			}
			
		}
		
		return new LoggerImpl();
	}
	
	public static void main(String[] args) {
		LocalClassTest1 localClassTest1 = new LocalClassTest1();
		Logger logger = localClassTest1.getLogger();
		logger.log("Local Inner Class Example");
	}
}
