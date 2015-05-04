package org.joolzminer.examples.async.api;

import java.util.Random;
import org.joolzminer.examples.async.utils.Utils;

public class Shop {
	private static final Random random = new Random();
	
	private final String shopName;
	
	public Shop(String shopName) {
		this.shopName = shopName;
	}
		
	public String getPrice(String product) {
		double price = calculatePrice(product);
		Discount.Code code = Discount.Code.values() [random.nextInt(Discount.Code.values().length)];
		return String.format("%s::%.2f::%s", shopName, price, code.toString());
	}
	
	private double calculatePrice(String product) {
		Utils.randomDelay();
		return random.nextDouble() * product.charAt(0) + product.charAt(1);
	}

	public String getShopName() {
		return shopName;
	}	
}
