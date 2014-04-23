package org.joolzminer.examples.decorator;

import org.joolzminer.examples.Beverage;
import org.joolzminer.examples.BeverageSize;

public class Mocha extends CondimentDecorator {
	
	private Beverage beverage;
	
	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public BeverageSize getSize() {
		return beverage.getSize();
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}

	@Override
	public double cost() {
		double price = 0.0;
		switch (getSize()) {
			case SMALL:
				price = 0.15;
				break;
	
			case MEDIUM:
				price = 0.20;
				break;
				
			case LARGE:
				price = 0.25;
				break;
				
			default:
				throw new UnknownBeverageSizeException();
		}
		
		return beverage.cost() + price;
	}
	
}
