package org.joolzminer.examples;

public class HouseBlend extends Beverage {
	
	public HouseBlend() {
		this(BeverageSize.MEDIUM);
	}
	
	public HouseBlend(BeverageSize beverageSize) {		
		this.beverageSize = beverageSize;
		description = beverageSize + " House Blend Coffee";
	}
	
	@Override
	public double cost() {
		double price = 0.0;
		
		switch (beverageSize) {
			case SMALL:
				price = 0.79;
				break;
	
			case MEDIUM:
				price = 0.89;
				break;
				
			case LARGE:
				price = 0.99;
				break;
				
			default:
				throw new UnknownBeverageSizeException();
		}
		
		return price;		
	}
}
