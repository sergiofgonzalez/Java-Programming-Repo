package org.joolzminer.examples;

import org.joolzminer.examples.decorator.Mocha;
import org.joolzminer.examples.decorator.Soy;
import org.joolzminer.examples.decorator.Whip;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/*
 * This JUnit test is not aware of sizes, so all Beverages are Medium Sized (Grande)
 * 
 * Coffees					Condiments
 * -----------------		-------------------
 * House Blend	 .89		Steamed Milk	.10
 * Dark Roast	 .99		Mocha			.20
 * Decaf		1.05		Soy				.15
 * Espresso		1.99		Whip			.10
 * 
 */
public class StarbuzzCoffeeDecoratorTest {
	
	@Test
	public void testHouseBlendDoubleMochaSoyLatteWithWhip() {
		Beverage beverage = new Whip(new Soy(new Mocha(new Mocha(new HouseBlend()))));
		
		assertThat(beverage.getDescription(), is(equalTo("Grande House Blend Coffee, Mocha, Mocha, Soy, Whip")));
		assertThat(beverage.cost(), is(equalTo(.89 + .20 + .20 + .15 + .10)));
	}
	
	@Test
	public void testEspressoNoCondiments() {
		Beverage beverage = new Espresso();
		
		assertThat(beverage.getDescription(), is(equalTo("Grande Espresso Coffee")));
		assertThat(beverage.cost(), is(equalTo(1.99)));
	}
	
	@Test
	public void testDarkRoastDoubleMochaSoyLatteWithWhip() {
		Beverage beverage = new Whip(new Soy(new Mocha(new Mocha(new DarkRoast()))));
		
		assertThat(beverage.getDescription(), is(equalTo("Grande Dark Roast Coffee, Mocha, Mocha, Soy, Whip")));
		assertThat(beverage.cost(), is(equalTo(.99 + .20 + .20 + .15 + .10)));
	}
	
	@Test
	public void testHouseBlendWithSoyMochaAndWhip() {
		Beverage beverage = new Whip(new Mocha(new Soy(new HouseBlend())));
		
		assertThat(beverage.getDescription(), is(equalTo("Grande House Blend Coffee, Soy, Mocha, Whip")));
		assertThat(beverage.cost(), is(equalTo(.89 + .20 + .15 + .10)));
	}
}
