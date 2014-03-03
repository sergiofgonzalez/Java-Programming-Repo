package org.joolzminer.examples;

import java.text.NumberFormat;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NumberFormatTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(NumberFormatTest.class);
	
	
	public static void main(String[] args) {
		System.out.println("Type a number to be parsed and formatted: ");
		Scanner scanner = new Scanner(System.in);
		String userInput = scanner.next();
		Double number = null;
		try {
			number = Double.parseDouble(userInput);
		} catch (NumberFormatException e) {
			LOGGER.error("Incorrect user input: '{}' is not a number");
			System.exit(1);
		}
		
		NumberFormat numberFormat = NumberFormat.getInstance();
		System.out.println("You typed: " + numberFormat.format(number));
		System.out.println("I used " + numberFormat.getClass().getName() 
							+ " class to format the number");
		scanner.close();
	}
}
