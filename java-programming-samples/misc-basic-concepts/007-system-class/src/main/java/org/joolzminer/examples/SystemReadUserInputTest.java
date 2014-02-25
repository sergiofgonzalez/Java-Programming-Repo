package org.joolzminer.examples;

import java.io.IOException;
import java.util.Scanner;

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
	
	public String getUserInput2() {
		Scanner scanner = new Scanner(System.in);
		String userInput = scanner.next();
		scanner.close();
		return userInput;
	}
	
	
	public static void main(String[] args) {
		SystemReadUserInputTest runner = new SystemReadUserInputTest();
		System.out.print("Enter your name: ");
		System.out.println("Hello, " + runner.getUserInput() + "!");
		
		System.out.print("Enter your age: ");
		System.out.println("You're " + runner.getUserInput2() + " years old");
	}
}
