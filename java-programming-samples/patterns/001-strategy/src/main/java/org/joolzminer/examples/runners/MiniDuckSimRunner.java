package org.joolzminer.examples.runners;

import org.joolzminer.examples.Duck;
import org.joolzminer.examples.MallardDuck;
import org.joolzminer.examples.ModelDuck;
import org.joolzminer.examples.behaviors.FlyRocketPowered;

public class MiniDuckSimRunner {
	
	public static void main(String[] args) {
		Duck mallardDuck = new MallardDuck();
		mallardDuck.display();
		mallardDuck.performFly();
		mallardDuck.performQuack();
		mallardDuck.swim();
		
		Duck modelDuck = new ModelDuck();
		modelDuck.display();
		modelDuck.performFly();
		modelDuck.performQuack();
		
		// Changing behavior dynamically
		System.out.println("*** now model duck gets berserk!");
		modelDuck.setFlyBehavior(new FlyRocketPowered());
		modelDuck.performFly();
	}
}
