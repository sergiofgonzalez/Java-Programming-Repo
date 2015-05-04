package org.joolzminer.examples.async.api;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.joolzminer.examples.async.utils.Utils;

public class ConciseShop {
	private static final Random random = new Random();
	
	public Future<Double> getPriceAsync(String product) {
		return CompletableFuture.supplyAsync(() -> calculatePrice(product));
	}
	
	private double calculatePrice(String product) {
		if (random.nextBoolean()) {
			throw new IllegalArgumentException("Fabricated Exception in calculatePrice()");
		}
		Utils.randomDelay();
		return random.nextDouble() * product.charAt(0) + product.charAt(1);
	}
}
