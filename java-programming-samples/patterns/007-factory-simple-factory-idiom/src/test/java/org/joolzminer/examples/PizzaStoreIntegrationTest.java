package org.joolzminer.examples;

import org.joolzminer.examples.factory.SimplePizzaFactory;
import org.junit.Test;

public class PizzaStoreIntegrationTest {

	@Test
	public void testPizzaStoreCheese() {
		PizzaStore pizzaStore = new PizzaStore(new SimplePizzaFactory());
		pizzaStore.orderPizza("cheese");
	}
	
	@Test
	public void testPizzaStoreClam() {
		PizzaStore pizzaStore = new PizzaStore(new SimplePizzaFactory());
		pizzaStore.orderPizza("clam");
	}
	
	@Test
	public void testPizzaStorePepperoni() {
		PizzaStore pizzaStore = new PizzaStore(new SimplePizzaFactory());
		pizzaStore.orderPizza("pepperoni");
	}
	
	@Test
	public void testPizzaStoreVeggie() {
		PizzaStore pizzaStore = new PizzaStore(new SimplePizzaFactory());
		pizzaStore.orderPizza("veggie");
	}
}
