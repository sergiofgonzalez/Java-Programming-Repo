package org.joolzminer.examples.async.runner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.function.Function;

import org.joolzminer.examples.async.api.Shop;

import static java.util.stream.Collectors.*;

public class BestPriceFinderRunner {
	
	private static final SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");

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
		List<String> prices = timedExecution("Nexus 5", BestPriceFinderRunner::findPricesSequential);
		prices.forEach(System.out::println);
		printSeparator();
		
		// B. Parallel approach using streams
		prices = timedExecution("Nexus 5", BestPriceFinderRunner::findPricesParallel);
		prices.forEach(System.out::println);
		printSeparator();
		
		// C: Async approach using CompletableFutures
		prices = timedExecution("Nexus 5", BestPriceFinderRunner::findPricesAsync);
		prices.forEach(System.out::println);
		printSeparator();
		
		// What option scales better? Well, C does because it is not limited by the number of cores
		
		
		shops.add(new Shop("MoreShops1"));
		shops.add(new Shop("MoreShops2"));
		shops.add(new Shop("MoreShops3"));
		shops.add(new Shop("MoreShops4"));
		shops.add(new Shop("MoreShops5"));
		shops.add(new Shop("MoreShops6"));
		shops.add(new Shop("MoreShops7"));
		shops.add(new Shop("MoreShops8"));
		
		// If we don'f fine tune the Executor, we won't see the difference
		System.out.println("Parallel:");
		prices = timedExecution("Nexus 5", BestPriceFinderRunner::findPricesParallel);
		System.out.println("Async (ForkJoinPool):");
		prices = timedExecution("Nexus 5", BestPriceFinderRunner::findPricesAsync);
		
		// but if we do, Async will be much faster
		
		System.out.println("Async (CustomPool):");
		prices = timedExecution("Nexus 5", BestPriceFinderRunner::findPricesAsyncCustomPool);
		
		
	}
	
	
	public static List<String> findPricesSequential(String product) {
		List<String> prices = shops.stream()
				.map(shop -> String.format("%s price is %.2f", shop.getShopName(), shop.getPrice(product)))			
				.collect(toList());	
		return prices;
	}
	
	public static List<String> findPricesParallel(String product) {
		List<String> prices = shops.stream()
									.parallel()
									.map(shop -> String.format("%s price is %.2f", shop.getShopName(), shop.getPrice(product)))			
									.collect(toList());	
		return prices;
	}
	
	public static List<String> findPricesAsync(String product) {
		List<CompletableFuture<String>> futurePrices =
				shops.stream()
					.map(shop -> CompletableFuture.supplyAsync(() -> String.format("%s price is %.2f", shop.getShopName(), shop.getPrice(product))))
					.collect(toList());
		
		return futurePrices.stream()
					.map(CompletableFuture::join)
					.collect(toList());
		
	}
	
	public static List<String> findPricesAsyncCustomPool(String product) {
		Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100), new ThreadFactory() {
			
			@Override
			public Thread newThread(Runnable r) {
				Thread t = new Thread(r);
				t.setDaemon(true);	// allow program to exit even when threads are running
				return t;
			}
		});

		
		List<CompletableFuture<String>> futurePrices =
				shops.stream()
					.map(shop -> CompletableFuture.supplyAsync(() -> String.format("%s price is %.2f", shop.getShopName(), shop.getPrice(product)), executor))
					.collect(toList());
		
		return futurePrices.stream()
					.map(CompletableFuture::join)
					.collect(toList());
		
	}
	
	
	private static List<String> timedExecution(String product, Function<String, List<String>> findPricesFunction) {
		long start = System.nanoTime();
		List<String> prices = findPricesFunction.apply(product);
		System.out.println(" -> function execution took: " + (System.nanoTime() - start) / 1_000_000 + " msecs.");
		return prices;
	}
	
	
	public static void printTime() {
		System.out.println(formatter.format(new Date()));
	}
	
	public static void printSeparator() {
		System.out.println("=======================================================");
	}
}
