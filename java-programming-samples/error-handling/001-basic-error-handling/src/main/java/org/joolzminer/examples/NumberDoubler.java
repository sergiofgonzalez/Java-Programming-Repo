package org.joolzminer.examples;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NumberDoubler {

	private static final Logger LOGGER = LoggerFactory.getLogger(NumberDoubler.class);
	
	public static void main(String[] args) {
		System.out.print("Type a number: ");
		Scanner scanner = new Scanner(System.in);
		String userInput = scanner.next();
		try {
			double number = Double.parseDouble(userInput);
			System.out.printf("The double of your number is: %s\n", number * 2);
		} catch (NumberFormatException e) {
			LOGGER.error("Invalid input: '{}' is not a number", userInput);
		} finally {
			scanner.close();	
		}		
	}
}
