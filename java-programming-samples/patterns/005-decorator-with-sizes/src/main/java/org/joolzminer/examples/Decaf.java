package org.joolzminer.examples;

public class Decaf extends Beverage {
	
	public Decaf() {
		this(BeverageSize.MEDIUM);
	}
	
	public Decaf(BeverageSize beverageSize) {		
		this.beverageSize = beverageSize;
		description = beverageSize + " Decaf Coffee";
	}
	
	@Override
	public double cost() {
		double price = 0;
		switch (beverageSize) {
		case SMALL:
			price = 0.95;
			break;

		case MEDIUM:
			price = 1.05;
			break;
			
		case LARGE:
			price = 1.15;
			break;
			
		default:
			throw new UnknownBeverageSizeException();
		}
		
		return price;
	}
}
