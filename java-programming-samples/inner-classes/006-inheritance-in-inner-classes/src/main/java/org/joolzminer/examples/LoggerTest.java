package org.joolzminer.examples;

import java.util.Date;

interface Logger {
	void log(String message);
}

class BasicLogger {

	protected class LoggerImpl implements Logger {

		@Override
		public void log(String message) {
			System.out.println(message);			
		}		
	}
	
	public Logger getLogger() {
		return new LoggerImpl();
	}	
}

class PrefixLogger {
	
	protected class LoggerImpl extends BasicLogger.LoggerImpl {
		public LoggerImpl(BasicLogger basicLogger) {
			basicLogger.super();
		}

		@Override
		public void log(String message) {
			System.out.println(new Date() + ": " + message);
		}		
	}
	
	public Logger getLogger() {
		return new LoggerImpl(new BasicLogger());
	}
}


public class LoggerTest {
	public static void main(String[] args) {
		Logger logger = (new PrefixLogger()).getLogger();
		logger.log("Hello, world!");
	}
}
