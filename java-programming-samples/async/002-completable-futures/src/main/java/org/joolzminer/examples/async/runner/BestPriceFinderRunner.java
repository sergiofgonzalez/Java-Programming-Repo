package org.joolzminer.examples.async.runner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.joolzminer.examples.async.api.BetterShop;
import org.joolzminer.examples.async.api.ConciseShop;
import org.joolzminer.examples.async.api.Shop;

public class BestPriceFinderRunner {
	
	private static final SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");
	
	public static void main(String[] args) {
		
		// Sync call: not appropriate for a best price finder app that queries several shops
		// at the same time
		printTime();
		Shop shop = new Shop();
		System.out.println("Calculating Price for Nexus 5: " + shop.getPrice("Nexus 5"));
		printTime();
		printSeparator();

		// Async call
		printTime();
		Future<Double> futurePrice = shop.getPriceAsync("Nexus 5");	 // this is a non-blocking call 
		printTime();
		
		try {
			double price = futurePrice.get();	// this is a blocking call on current thread
			System.out.println("Price for Nexus 5: " + price);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		printTime();
		printSeparator();
		
		
		// Async call with better error management
		BetterShop betterShop = new BetterShop();
		printTime();
		futurePrice = betterShop.getPriceAsync("Nexus 5");	 // this is a non-blocking call 
		printTime();
		
		try {
			double price = futurePrice.get(2, TimeUnit.SECONDS);	// this is a blocking call on current thread
			System.out.println("Price for Nexus 5: " + price);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		printTime();
		printSeparator();		
		
		// Async call with the concise supplyAsync() factory method
		ConciseShop conciseShop = new ConciseShop();
		printTime();
		futurePrice = conciseShop.getPriceAsync("Nexus 5");	 // this is a non-blocking call 
		printTime();
		
		try {
			double price = futurePrice.get(2, TimeUnit.SECONDS);	// this is a blocking call on current thread
			System.out.println("Price for Nexus 5: " + price);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		printTime();
		printSeparator();
	}
	
	public static void printTime() {
		System.out.println(formatter.format(new Date()));
	}
	
	public static void printSeparator() {
		System.out.println("=======================================================");
	}
}
