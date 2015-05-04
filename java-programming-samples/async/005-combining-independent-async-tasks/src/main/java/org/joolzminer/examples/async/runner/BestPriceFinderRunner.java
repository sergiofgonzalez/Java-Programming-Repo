package org.joolzminer.examples.async.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

import org.joolzminer.examples.async.api.ExchangeService;
import org.joolzminer.examples.async.api.Shop;


import static java.util.stream.Collectors.*;
import static org.joolzminer.examples.async.api.ExchangeService.Money;

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
		

		// A. Sequential approach using streams
		List<String> prices = timedExecution("Nexus 5", BestPriceFinderRunner::findPricesInUSDAsync);
		prices.forEach(System.out::println);
		printSeparator();	
	}
	
	
	
	
	public static List<String> findPricesInUSDSequential(String product) {
		List<String> prices = shops.stream()
					.map(shop -> shop.getPrice(product))
					.map(price -> ExchangeService.getRate(ExchangeService.Money.EUR, ExchangeService.Money.USD))
					.map(price -> String.format("price is %.2f USD", price))
					.collect(toList());
		
		return prices;
	}
	
	public static List<String> findPricesInUSDAsync(String product) {
		List<CompletableFuture<Double>> priceFutures = new ArrayList<>();
		for (Shop shop : shops) {
			CompletableFuture<Double> futurePriceInUSD =
					CompletableFuture.supplyAsync(() -> shop.getPrice(product))
						.thenCombine(CompletableFuture.supplyAsync(() -> ExchangeService.getRate(Money.EUR, Money.USD)), (price, rate) -> price * rate);
			priceFutures.add(futurePriceInUSD);		
		}
		
		List<String> prices = priceFutures
					.stream()
					.map(CompletableFuture::join)
					.map(price -> "price is " + price + " USD")
					.collect(toList());
		
		return prices;
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
