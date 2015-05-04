package org.joolzminer.examples.async.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.function.Function;

import org.joolzminer.examples.async.api.Discount;
import org.joolzminer.examples.async.api.Quote;
import org.joolzminer.examples.async.api.Shop;

import static java.util.stream.Collectors.*;

public class BestPriceFinderRunner {
	
	private static List<Shop> shops; 
		
	@SuppressWarnings("serial")
	public static void main(String[] args) {
		
		shops = new ArrayList<Shop>() {{
			add(new Shop("BestPrice"));
			add(new Shop("LetsSaveBig"));
			add(new Shop("MyFavoriteShop"));
			add(new Shop("BuyItAll"));
		}};
		
		// We must return a List of Strings with the format
		// {shopName} price is {productPrice}.

		// A. Sequential approach using streams
		List<String> prices = timedExecution("Nexus 5", BestPriceFinderRunner::findPricesBest);
		prices.forEach(System.out::println);
		printSeparator();
		
	}
	
	
	public static List<String> findPricesSequential(String product) {
		List<String> prices = shops.stream()
					.map(shop -> shop.getPrice(product))
					.map(Quote::parse)
					.map(Discount::applyDiscount)
					.collect(toList());
		
		return prices;
	}
	
	// this implementation only half-solves the issue	
	public static List<String> findPrices(String product) {
		List<CompletableFuture<String>> futurePrices = shops.stream()
				.map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product)))
				.collect(toList());
		
		List<String> prices = futurePrices.stream()
				.map(CompletableFuture::join)
				.map(Quote::parse)
				.map(Discount::applyDiscount)
				.collect(toList());
		
		return prices;
	}
	
	
	public static List<String> findPricesBest(String product) {
		Executor executor = Executors.newFixedThreadPool(Math.min(100, shops.size() * 2), new ThreadFactory() {
			
			@Override
			public Thread newThread(Runnable r) {
				Thread t = new Thread(r);
				t.setDaemon(true);
				return t;
			}
		});
		
		List<CompletableFuture<String>> priceFutures =
				shops.stream()
					.map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product), executor))
					.map(future -> future.thenApply(Quote::parse))
					.map(future -> future.thenCompose((Quote quote) -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), executor)))
					.collect(toList());
					
		return priceFutures.stream()
					.map(CompletableFuture::join)
					.collect(toList());
	}
		
	private static List<String> timedExecution(String product, Function<String, List<String>> findPricesFunction) {
		long start = System.nanoTime();
		List<String> prices = findPricesFunction.apply(product);
		System.out.println(" -> function execution took: " + (System.nanoTime() - start) / 1_000_000 + " msecs.");
		return prices;
	}

	
	public static void printSeparator() {
		System.out.println("=======================================================");
	}
}
