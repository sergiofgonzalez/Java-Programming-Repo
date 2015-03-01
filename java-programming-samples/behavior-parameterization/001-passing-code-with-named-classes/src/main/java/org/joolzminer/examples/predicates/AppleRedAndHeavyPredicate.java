package org.joolzminer.examples.predicates;

import org.joolzminer.examples.domain.Apple;

public class AppleRedAndHeavyPredicate implements ApplePredicate {

	@Override
	public boolean test(Apple apple) {
		return "red".equals(apple.getColor()) && apple.getWeight() > 100;
	}

}
