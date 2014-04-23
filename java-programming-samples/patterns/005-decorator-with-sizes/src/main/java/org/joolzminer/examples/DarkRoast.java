package org.joolzminer.examples;

public class DarkRoast extends Beverage {
	
	public DarkRoast() {
		this(BeverageSize.MEDIUM);
	}
	
	public DarkRoast(BeverageSize beverageSize) {
		this.beverageSize = beverageSize;
		description = beverageSize + " Dark Roast Coffee";
	}
	
	@Override
	public double cost() {
		double price = 0;
		
		switch (beverageSize) {
			case SMALL:
				price = 0.89;
				break;
	
			case MEDIUM:
				price = 0.99;
				break;
				
			case LARGE:
				price = 1.09;
				break;
				
			default:
				throw new UnknownBeverageSizeException();
		}
		
		return price;
	}
}
