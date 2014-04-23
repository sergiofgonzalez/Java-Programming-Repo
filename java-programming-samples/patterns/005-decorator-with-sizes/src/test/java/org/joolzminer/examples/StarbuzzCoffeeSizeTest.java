package org.joolzminer.examples;

import org.joolzminer.examples.decorator.Mocha;
import org.joolzminer.examples.decorator.Soy;
import org.joolzminer.examples.decorator.Whip;
import org.junit.Test;
import static org.joolzminer.examples.BeverageSize.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/*
 * This JUnit test is aware of sizes (Tall/Grande/Venti)
 *  
 * Coffees		Tall/Grande/Venti	Condiments      Tall/Grande/Venti
 * -------------------------------	----------------------------------
 * House Blend	 0.79/0.89/0.99		Steamed Milk	.05/.10/.15
 * Dark Roast	 0.89/0.99/1.09		Mocha			.15/.20/.25
 * Decaf		 0.95/1.05/1.15		Soy				.10/.15/.20
 * Espresso		 1.89/1.99/2.09		Whip			.05/.10/.15
 * 
 */
public class StarbuzzCoffeeSizeTest {
	
	@Test
	public void testTallHouseBlendDoubleMochaSoyLatteWithWhip() {
		Beverage beverage = new Whip(new Soy(new Mocha(new Mocha(new HouseBlend(SMALL)))));
		
		assertThat(beverage.getDescription(), is(equalTo("Tall House Blend Coffee, Mocha, Mocha, Soy, Whip")));
		assertThat(beverage.cost(), is(equalTo(.79 + .15 + .15 + .10 + .05)));
	}
	
	@Test
	public void testGrandeHouseBlendDoubleMochaSoyLatteWithWhip() {
		Beverage beverage = new Whip(new Soy(new Mocha(new Mocha(new HouseBlend(MEDIUM)))));
		
		assertThat(beverage.getDescription(), is(equalTo("Grande House Blend Coffee, Mocha, Mocha, Soy, Whip")));
		assertThat(beverage.cost(), is(equalTo(.89 + .20 + .20 + .15 + .10)));
	}
	
	
	@Test
	public void testVentiEspressoNoCondiments() {
		Beverage beverage = new Espresso(LARGE);
		
		assertThat(beverage.getDescription(), is(equalTo("Venti Espresso Coffee")));
		assertThat(beverage.cost(), is(equalTo(2.09)));
	}
	
	@Test
	public void testTallDarkRoastDoubleMochaSoyLatteWithWhip() {
		Beverage beverage = new Whip(new Soy(new Mocha(new Mocha(new DarkRoast(SMALL)))));
		
		assertThat(beverage.getDescription(), is(equalTo("Tall Dark Roast Coffee, Mocha, Mocha, Soy, Whip")));
		assertThat(beverage.cost(), is(equalTo(.89 + .15 + .15 + .10 + .05)));
	}
	
	@Test
	public void testVentiHouseBlendWithSoyMochaAndWhip() {
		Beverage beverage = new Whip(new Mocha(new Soy(new HouseBlend(LARGE))));
		
		assertThat(beverage.getDescription(), is(equalTo("Venti House Blend Coffee, Soy, Mocha, Whip")));
		assertThat(beverage.cost(), is(equalTo(.99 + .25 + .20 + .15)));
	}
}
