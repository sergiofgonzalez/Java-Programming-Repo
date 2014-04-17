package org.joolzminer.examples;

import org.joolzminer.examples.behaviors.FlyNoWay;
import org.joolzminer.examples.behaviors.Quack;

public class ModelDuck extends Duck {
	
	public ModelDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new Quack();
	}
	
	@Override
	public void display() {
		System.out.println("I'm a model duck");
	}
	
}
