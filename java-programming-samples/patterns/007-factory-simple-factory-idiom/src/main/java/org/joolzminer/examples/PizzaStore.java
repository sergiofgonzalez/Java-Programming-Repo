package org.joolzminer.examples;

import org.joolzminer.examples.domain.Pizza;
import org.joolzminer.examples.factory.SimplePizzaFactory;

public class PizzaStore {
	private SimplePizzaFactory factory;
	
	public PizzaStore(SimplePizzaFactory simplePizzaFactory) {
		factory = simplePizzaFactory;
	}
	
	public Pizza orderPizza(String type) {
		Pizza pizza = factory.createPizza(type);
		
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		
		return pizza;
	}
}
