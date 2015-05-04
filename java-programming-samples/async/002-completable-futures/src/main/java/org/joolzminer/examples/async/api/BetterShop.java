package org.joolzminer.examples.async.api;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.joolzminer.examples.async.utils.Utils;

public class BetterShop {
	private static final Random random = new Random();
	
	public Future<Double> getPriceAsync(String product) {
		CompletableFuture<Double> futurePrice = new CompletableFuture<>();
		
		// this is non blocking
		new Thread(() -> {	
				try {
					double price = calculatePrice(product);
					futurePrice.complete(price);
				} catch (Exception e) {
					futurePrice.completeExceptionally(e);
				}
		}).start();

		return futurePrice;			
	}
	
	private double calculatePrice(String product) {
		if (random.nextBoolean()) {
			throw new IllegalArgumentException("Fabricated Exception in calculatePrice()");
		}
		Utils.randomDelay();
		return random.nextDouble() * product.charAt(0) + product.charAt(1);
	}
}
