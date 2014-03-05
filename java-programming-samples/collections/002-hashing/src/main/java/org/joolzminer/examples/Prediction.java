package org.joolzminer.examples;

import java.util.Random;

public class Prediction {
	private static Random random = new Random(47);
	private boolean isShadow = random.nextBoolean();

	@Override
	public String toString() {
		return isShadow ? "Six more weeks of Winter!" : "Early Spring!";
	}	
}
