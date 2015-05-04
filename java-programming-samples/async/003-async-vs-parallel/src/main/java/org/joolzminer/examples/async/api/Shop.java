package org.joolzminer.examples.async.api;

import java.util.Random;
import org.joolzminer.examples.async.utils.Utils;

public class Shop {
	private static final Random random = new Random();
	
	private final String shopName;
	
	public Shop(String shopName) {
		this.shopName = shopName;
	}
		
	public double getPrice(String product) {
		return calculatePrice(product);	
	}
	
	private double calculatePrice(String product) {
		Utils.randomDelay();
		return random.nextDouble() * product.charAt(0) + product.charAt(1);
	}

	public String getShopName() {
		return shopName;
	}	
}
