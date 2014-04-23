package org.joolzminer.examples;

public class Espresso extends Beverage {
	
	public Espresso() {
		this(BeverageSize.MEDIUM);
	}
	
	public Espresso(BeverageSize beverageSize) {		
		this.beverageSize = beverageSize;
		description = beverageSize + " Espresso Coffee";
	}
	
	@Override
	public double cost() {
		double price = 0.0;
		switch (beverageSize) {
			case SMALL:
				price = 1.89;
				break;
	
			case MEDIUM:
				price = 1.99;
				break;
				
			case LARGE:
				price = 2.09;
				break;
				
			default:
				throw new UnknownBeverageSizeException();
		}
		
		return price;
	}
}
