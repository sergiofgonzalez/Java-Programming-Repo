package org.joolzminer.examples.async.api;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import org.joolzminer.examples.async.utils.Utils;

public class Shop {
	
	private static final Random random = new Random();
	
	public double getPrice(String product) {
		return calculatePrice(product);
	}
	
	public Future<Double> getPriceAsync(String product) {
		CompletableFuture<Double> futurePrice = new CompletableFuture<>();
		
		// this is non blocking
		new Thread(() -> {			
				double price = calculatePrice(product);
				futurePrice.complete(price);
		}).start();

		return futurePrice;			
	}
	
	private double calculatePrice(String product) {
		Utils.delay();
		return random.nextDouble() * product.charAt(0) + product.charAt(1);
	}
}
