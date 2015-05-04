package org.joolzminer.examples.functional;

import java.util.function.Supplier;

public class Logger {
	private final LogLevel logLevel;
	
	public Logger(LogLevel logLevel) {
		this.logLevel = logLevel;
	}
	
	public void debug(String message) {
		System.out.println("DEBUG: " + message);
	}
	
	public void info(String message) {
		System.out.println("INFO: " + message);
	}
	
	public void error(String message) {
		System.out.println("ERROR: " + message);
	}
	
	public void warning(String message) {
		System.out.println("WARNING: " + message);
	}
	
	public boolean isLoggable(LogLevel logLevel) {
		if (this.logLevel.ordinal() >= logLevel.ordinal()) {
			return true;
		} else {
			return false;
		}
	}
	
	// This prevents logLevel checking to be exposed in the client code
	// but does not implement conditional deferred execution
	public void log(LogLevel logLevel, String message) {
		if (isLoggable(logLevel)) {
			System.out.println(logLevel.toString() + ": " + message);
		}
	}
	
	public void log(LogLevel logLevel, Supplier<String> messageSupplier) {
		if (isLoggable(logLevel)) {
			System.out.println(logLevel.toString() + ": " + messageSupplier.get());
		}
	}
}
