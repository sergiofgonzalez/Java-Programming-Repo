package org.joolzminer.examples.functional.runner;

import org.joolzminer.examples.functional.Feed;
import org.joolzminer.examples.functional.GuardianObserver;
import org.joolzminer.examples.functional.LeMondeObserver;
import org.joolzminer.examples.functional.NYTimesObserver;

public class FeedRunner {
	public static void main(String[] args) {
		// Old school
		Feed feed = new Feed();
				
		feed.registerObserver(new NYTimesObserver());
		feed.registerObserver(new GuardianObserver());
		feed.registerObserver(new LeMondeObserver());
		
		feed.notifyObservers("The queen said her favourite book is Java 8 in Action!");
		
		// using Lambdas
		feed.registerObserver(tweet -> {
			if (tweet != null && tweet.contains("Real Madrid")) {
				System.out.println("Breaking news in Spain..." + tweet);
			}
		});
		
		feed.notifyObservers("Gol del Real Madrid!!");
	}
}
