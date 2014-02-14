package org.joolzminer.examples;

interface PrefixLogger {
	void log(String message);
}

public class LocalClassTest2 {

	public PrefixLogger getLogger(final String prefix) {
		class LoggerImpl implements PrefixLogger {

			@Override
			public void log(String message) {
				System.out.println(prefix + " : " + message);			
			}			
		}
		
		return new LoggerImpl();
	}
	
	
	public static void main(String[] args) {
		LocalClassTest2 localClassTest2 = new LocalClassTest2();
		PrefixLogger logger = localClassTest2.getLogger("DEBUG");
		logger.log("Local Inner Class Example");
	}
}
