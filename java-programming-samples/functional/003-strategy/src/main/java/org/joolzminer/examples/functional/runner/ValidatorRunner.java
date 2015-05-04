package org.joolzminer.examples.functional.runner;

import org.joolzminer.examples.functional.IsAllLowerCase;
import org.joolzminer.examples.functional.Validator;

public class ValidatorRunner {
	public static void main(String[] args) {
		// Old School
		Validator validator = new Validator(new IsAllLowerCase());
		System.out.println(validator.validate("ValidatorRunner"));
		System.out.println(validator.validate("validators"));
		printSeparator();
		
		Validator numericValidator = new Validator((s) -> s.matches("\\d+"));
		System.out.println(numericValidator.validate("12345"));
		System.out.println(numericValidator.validate("6789abcdef"));
	}
	
	public static void printSeparator() {
		System.out.println("================================================");
	}
}
