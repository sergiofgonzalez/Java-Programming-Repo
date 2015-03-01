package org.joolzminer.examples.predicates;

import org.joolzminer.examples.domain.Apple;

public class AppleVerboseFormatter implements AppleFormatter {

	@Override
	public String accept(Apple apple) {
		String output = "A " + apple.getColor() + " apple that weighs " + apple.getWeight() + " grams.";
		return output;
	}

}
