package org.joolzminer.examples;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SystemReadUserInputTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(SystemReadUserInputTest.class);
	
	public String getUserInput() {
		StringBuilder stringBuilder = new StringBuilder();
		try {
			char c = (char) System.in.read();
			while (c != '\r') {
				stringBuilder.append(c);
				c = (char) System.in.read();
			}
		} catch (IOException e) {
			LOGGER.error("Exception caught reading user input: {}", e.getMessage());
			System.exit(1);
		}
		
		return stringBuilder.toString();
	}
	
	public static void main(String[] args) {
		SystemReadUserInputTest runner = new SystemReadUserInputTest();
		System.out.print("Enter your name: ");
		System.out.println("Hello, " + runner.getUserInput() + "!");
	}
}
