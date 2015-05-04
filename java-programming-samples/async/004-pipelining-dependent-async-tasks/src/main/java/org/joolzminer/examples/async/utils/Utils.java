package org.joolzminer.examples.async.utils;

import java.util.Random;

public class Utils {
	
	private static final Random random = new Random();
	
	public static void delay() {
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void randomDelay() {
		int delaySec = random.nextInt(5) + 1;
		System.out.println("  -> will wait for " + delaySec + " second(s)");
		try {
			Thread.sleep(delaySec * 1_000); // a number between [0, 5) + 1, that is, between [1, 5]
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
