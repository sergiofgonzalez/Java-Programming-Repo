package org.joolzminer.examples;

import java.util.Date;

interface BasicLogger {
	void log(String message);
}

class PrefixLogger implements BasicLogger {

	protected String prefix;

	public PrefixLogger(String prefix) {
		this.prefix = prefix;
	}
	
	@Override
	public void log(String message) {
		System.out.println(prefix + ": " + message);
	}	
}

public class LoggerTestRunner {
	public BasicLogger getBasicLogger() {
		return new PrefixLogger(this.getClass().getSimpleName()) {

			@Override
			public void log(String message) {
				System.out.println(new Date() + ": " + prefix + ": " + message);
			}			
		};
	}
	
	public static void main(String[] args) {
		BasicLogger logger = (new LoggerTestRunner()).getBasicLogger();
		logger.log("hello, world!");
	}
}
