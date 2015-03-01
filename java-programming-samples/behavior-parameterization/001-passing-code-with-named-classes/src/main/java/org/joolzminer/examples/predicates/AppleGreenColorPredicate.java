package org.joolzminer.examples.predicates;

import org.joolzminer.examples.domain.Apple;

public class AppleGreenColorPredicate implements ApplePredicate {

	@Override
	public boolean test(Apple apple) {
		return "green".equals(apple.getColor());
	}

}
