package org.joolzminer.examples.behaviors;

public class Quack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("*** Quack");
	}
}