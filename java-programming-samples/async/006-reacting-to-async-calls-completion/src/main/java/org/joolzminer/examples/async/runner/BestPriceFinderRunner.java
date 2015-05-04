package org.joolzminer.examples.async.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Stream;

import org.joolzminer.examples.async.api.Discount;
import org.joolzminer.examples.async.api.Quote;
import org.joolzminer.examples.async.api.Shop;

public class BestPriceFinderRunner {
	
	private static List<Shop> shops; 
		
	@SuppressWarnings({ "serial", "rawtypes" })
	public static void main(String[] args) {
		
		shops = new ArrayList<Shop>() {{
			add(new Shop("BestPrice"));
			add(new Shop("LetsSaveBig"));
			add(new Shop("MyFavoriteShop"));
			add(new Shop("BuyItAll"));
		}};

		CompletableFuture[] futures = findPricesStream("Nexus 5")
												.map(future -> future.thenAccept(System.out::println))
												.toArray(size -> new CompletableFuture[size]);
		CompletableFuture.allOf(futures)
						.join();
		
		printSeparator();
		
	}
	
	
	
	public static Stream<CompletableFuture<String>> findPricesStream(String product) {
		Executor executor = Executors.newFixedThreadPool(Math.min(100, shops.size() * 2), new ThreadFactory() {
			
			@Override
			public Thread newThread(Runnable r) {
				Thread t = new Thread(r);
				t.setDaemon(true);
				return t;
			}
		});
		
		return shops.stream()
					.map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product), executor))
					.map(future -> future.thenApply(Quote::parse))
					.map(future -> future.thenCompose((Quote quote) -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), executor)));		
	}
		
	
	public static void printSeparator() {
		System.out.println("=======================================================");
	}
}
