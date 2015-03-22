package org.joolzminer.examples.streams.runner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.joolzminer.examples.streams.domain.Trader;
import org.joolzminer.examples.streams.domain.Transaction;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

public class TradersRunner {

	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
				new Transaction(raoul, 2011,  400),
				new Transaction(raoul, 2012, 1000),
				new Transaction(brian, 2011,  300),
				new Transaction(mario, 2012,  710),
				new Transaction(mario, 2012,  700),
				new Transaction(alan,  2012,  950)
				);
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// Query 1: Find all the transactions in the year 2011 and sort them by value
		List<Transaction> q1Transactions = transactions.stream()
														.filter(transaction -> transaction.getYear() == 2011)
														.sorted(comparing(Transaction::getValue))
														.collect(toList());
		System.out.println(q1Transactions);
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// Query 2: Where are all the unique cities where traders work?
		List<String> q2Cities = transactions.stream()
											.map(Transaction::getTrader)
											.map(Trader::getCity)
											.distinct()
											.collect(toList());
		System.out.println(q2Cities);
		
		System.out.println("================================================================================");
		// Book solution
		System.out.println(
					transactions.stream()
								.map(transaction -> transaction.getTrader().getCity())
								.distinct()
								.collect(toList())
				);
		
		System.out.println("================================================================================");
		// Yet another solution provided by the book
		System.out.println(
				transactions.stream()
							.map(transaction -> transaction.getTrader().getCity())
							.collect(toSet())
			);		
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// Query 3: Find all the traders from Cambridge and sort them by name
		List<Trader> q3TradersInCambridge = transactions.stream()
													.map(Transaction::getTrader)
													.filter(trader -> "Cambridge".equals(trader.getCity()))
													.distinct()
													.sorted(comparing(Trader::getName))
													.collect(toList());
		System.out.println(q3TradersInCambridge);
													
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// Query 4: Return a string of all traders' names sorted alphabetically
		String traderNames = transactions.stream()
										.map(transaction -> transaction.getTrader().getName())
										.distinct()
										.sorted()
										.reduce("", (accumulatedStr, traderName) -> accumulatedStr + traderName);
		System.out.println(traderNames);
		
		System.out.println("================================================================================");
		// The book proposes a more efficient solution as the reduce implementation creates a 
		// new String with each iteration
		System.out.println(
					transactions.stream()
								.map(transaction -> transaction.getTrader().getName())
								.distinct()
								.sorted()
								.collect(joining())
				);
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// Query 5: Are there any traders based in Milan
		boolean q5AnyTraderBasedInMilan = transactions.stream()
											.anyMatch(transaction -> "Milan".equals(transaction.getTrader().getCity()));
		System.out.println(q5AnyTraderBasedInMilan);
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// Query 6: Print all transactions' values from the traders living in Cambridge
		transactions.stream()
					.filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
					.map(Transaction::getValue)
					.forEach(System.out::println);
														
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// Query 7: What's the highest value of all the transactions
		Optional<Integer> q7HighestTransactionValue = transactions.stream()
											.map(Transaction::getValue)
											.reduce((maxTransactionValueSoFar, currentTransactionValue) -> Integer.max(maxTransactionValueSoFar, currentTransactionValue));
				
		q7HighestTransactionValue.ifPresent(System.out::println);
		
		System.out.println("================================================================================");
		// The book proposes a more concise solution
		transactions.stream()
					.map(Transaction::getValue)
					.reduce(Integer::max)
					.ifPresent(System.out::println);
					
		
		System.out.println("================================================================================");
		// The book also proposes yet another solution using max
		System.out.println(transactions.stream()
					.max(comparing(Transaction::getValue))
					.get()
					.getValue());

		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// Query 8: Find the transaction with the smallest value
		Optional<Transaction> q8TransactionWithLowestValue = transactions.stream()
											.reduce((tranWithLowestValueSoFar, currentTransaction) -> currentTransaction.getValue() < tranWithLowestValueSoFar.getValue() ? currentTransaction : tranWithLowestValueSoFar);
		
		q8TransactionWithLowestValue.ifPresent(System.out::println);
		
		System.out.println("================================================================================");
		// The book also proposes a more concise solution
		transactions.stream()
					.min(comparing(Transaction::getValue))
					.ifPresent(System.out::println);		
	}
}
