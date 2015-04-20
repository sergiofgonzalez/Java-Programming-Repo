package org.joolzminer.examples.streams.runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.joolzminer.examples.streams.domain.Currency;
import org.joolzminer.examples.streams.domain.Transaction;

import static java.util.stream.Collectors.*;

public class TransactionGroupingRunner {

	public static void main(String[] args) {
		
		List<Transaction> transactions = Arrays.asList(
				new Transaction(Currency.EUR, 1500.0),
				new Transaction(Currency.USD, 2300.0),
				new Transaction(Currency.GBP, 9900.0),
				new Transaction(Currency.EUR, 1100.0),
				new Transaction(Currency.JPY, 7800.0),
                new Transaction(Currency.CHF, 6700.0),
                new Transaction(Currency.EUR, 5600.0),
                new Transaction(Currency.USD, 4500.0),
                new Transaction(Currency.CHF, 3400.0),
                new Transaction(Currency.GBP, 3200.0),
                new Transaction(Currency.USD, 4600.0),
                new Transaction(Currency.JPY, 5700.0),
                new Transaction(Currency.EUR, 6800.0)
				);
		
		
		// You have a list of transactions and you have to group them
		// based on their nominal currency
		
		// Approach 1: old school
		Map<Currency, List<Transaction>> trxByCurrencies = new HashMap<>();
		for (Transaction transaction : transactions) {
			List<Transaction> transactionsForCurrency = trxByCurrencies.get(transaction.getCurrency());
			if (transactionsForCurrency == null) {
				transactionsForCurrency = new ArrayList<Transaction>();
				trxByCurrencies.put(transaction.getCurrency(), transactionsForCurrency);
			}
			transactionsForCurrency.add(transaction);
		}
		
		prettyPrintTransactionList(trxByCurrencies);
	
		
		// Approach 2: using stream collectors
		Map<Currency, List<Transaction>> trxByCurrenciesAlt = transactions.stream()
																.collect(groupingBy(Transaction::getCurrency));
		prettyPrintTransactionList(trxByCurrenciesAlt);
		
	}
	
	public static void prettyPrintTransactionList(Map<Currency, List<Transaction>> transactionsByCurrencies) {
		System.out.println("======================================");
		for (Entry<Currency, List<Transaction>> group : transactionsByCurrencies.entrySet()) {
			System.out.println(group.getKey());
			for (Transaction transaction : group.getValue()) {
				System.out.println("\t" + transaction);
			}
		}		
	}
}
