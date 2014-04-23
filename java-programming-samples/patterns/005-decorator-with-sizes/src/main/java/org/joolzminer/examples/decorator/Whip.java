package org.joolzminer.examples.decorator;

import org.joolzminer.examples.Beverage;
import org.joolzminer.examples.BeverageSize;

public class Whip extends CondimentDecorator {
	
	private Beverage beverage;
	
	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public BeverageSize getSize() {
		return beverage.getSize();
	}
	
	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Whip";
	}

	@Override
	public double cost() {
		double price = 0.0;
		switch (getSize()) {
			case SMALL:
				price = 0.05;
				break;
	
			case MEDIUM:
				price = 0.10;
				break;
				
			case LARGE:
				price = 0.15;
				break;
				
			default:
				throw new UnknownBeverageSizeException();
		}
		
		return beverage.cost() + price;
	}
	
}
