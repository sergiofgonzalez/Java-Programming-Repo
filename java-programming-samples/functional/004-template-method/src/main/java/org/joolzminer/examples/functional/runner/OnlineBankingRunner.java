package org.joolzminer.examples.functional.runner;

import org.joolzminer.examples.functional.OnlineBanking;

public class OnlineBankingRunner {
	public static void main(String[] args) {
		OnlineBanking onlineBanking = new OnlineBanking();
		
		onlineBanking.processCustomer(1337, (customer) -> System.out.println("Hello, " + customer.getName())); 
	}
}
