package org.joolzminer.examples.functional;

public class Validator {
	private final ValidationStrategy strategy;
	
	public Validator(ValidationStrategy validationStrategy) {
		this.strategy = validationStrategy;
	}
	
	public boolean validate(String s) {
		return strategy.execute(s);
	}
}
