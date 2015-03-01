package org.joolzminer.examples.predicates;

import org.joolzminer.examples.domain.Apple;

public class AppleHeavyWeightPredicate implements ApplePredicate {

	@Override
	public boolean test(Apple apple) {
		return apple.getWeight() > 100;
	}

}
