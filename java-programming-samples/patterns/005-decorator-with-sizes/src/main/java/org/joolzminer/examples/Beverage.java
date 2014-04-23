package org.joolzminer.examples;

public abstract class Beverage {
	protected String description = "Unknown Beverage";
	protected BeverageSize beverageSize;

	public String getDescription() {
		return description;
	}
	
	public abstract double cost();
	
	public BeverageSize getSize() {
		return beverageSize;
	}
	
	public void setSize(BeverageSize beverageSize) {
		this.beverageSize = beverageSize;
	}
	
	@SuppressWarnings("serial")
	public static class UnknownBeverageSizeException extends RuntimeException {		
	}
}
