package org.joolzminer.examples.factory;

import org.joolzminer.examples.domain.CheesePizza;
import org.joolzminer.examples.domain.ClamPizza;
import org.joolzminer.examples.domain.PepperoniPizza;
import org.joolzminer.examples.domain.Pizza;
import org.joolzminer.examples.domain.VeggiePizza;

public class SimplePizzaFactory {
	public Pizza createPizza(String type) {
		Pizza pizza = null;
		
		switch (type) {
			case "cheese":
				pizza = new CheesePizza();				
				break;
			
			case "pepperoni":
				pizza = new PepperoniPizza();
				break;
			
			case "clam":
				pizza = new ClamPizza();
				break;
				
			case "veggie":
				pizza = new VeggiePizza();
				break;
				
			default:
				throw new UnknownPizzaTypeException();
		}
		
		return pizza;
	}
	
	@SuppressWarnings("serial")
	public static class UnknownPizzaTypeException extends RuntimeException {		
	}
}
