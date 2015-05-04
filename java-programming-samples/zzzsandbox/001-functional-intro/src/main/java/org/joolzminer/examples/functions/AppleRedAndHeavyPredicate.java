package org.joolzminer.examples.functions;

import org.joolzminer.examples.domain.Apple;

public class AppleRedAndHeavyPredicate implements ApplePredicate {

	@Override
	public boolean test(Apple apple) {
		return "red".equalsIgnoreCase(apple.getColor()) && apple.getWeight() > 100;
	}
}
