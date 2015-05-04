package org.joolzminer.examples.functional.runner;

import org.joolzminer.examples.functional.LogLevel;
import org.joolzminer.examples.functional.Logger;

import static org.joolzminer.examples.functional.Diagnostics.*;

public class CustomLoggerRunner {

	public static void main(String[] args) {
		Logger debugLogger = new Logger(LogLevel.DEBUG);
		
		if (debugLogger.isLoggable(LogLevel.DEBUG)) {
			debugLogger.debug("This is a debug message dumped through debugLogger");
		}
		
		if (debugLogger.isLoggable(LogLevel.ERROR)) {
			debugLogger.error("This is an error message dumped through debugLogger");
		}
		printSeparator();		
		
		Logger errorLogger = new Logger(LogLevel.ERROR);
		if (errorLogger.isLoggable(LogLevel.ERROR)) {
			errorLogger.error("This is an error message dumped through errorLogger");
		}
		
		if (errorLogger.isLoggable(LogLevel.DEBUG)) {
			errorLogger.debug("This is a debug message dumped through errorLogger");
		}		
		printSeparator();
		
		debugLogger.log(LogLevel.DEBUG, "This is a debug message dumped through debugLogger using log()");
		debugLogger.log(LogLevel.INFO, "This is an info message dumped through debugLogger using log()");
		printSeparator();
		
		errorLogger.log(LogLevel.ERROR, "This is an error message dumped through errorLogger using log()");
		errorLogger.log(LogLevel.INFO, "This is an info message dumped through errorLogger using log()");
		printSeparator();
		
		// Conditional Deferred Execution
		errorLogger.log(LogLevel.ERROR, "An error has occured: " + generateDiagnostics());
		errorLogger.log(LogLevel.INFO, "A weird thing has happened: " + generateDiagnostics());
		printSeparator();
		
		errorLogger.log(LogLevel.ERROR, () -> "An error has occurred: " + generateDiagnostics());
		errorLogger.log(LogLevel.INFO, () -> "A weird thing has happened: " + generateDiagnostics());
		
	}
	
	public static void printSeparator() {
		System.out.println("==============================================================================");
	}
}
