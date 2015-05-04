package org.joolzminer.examples.functional;

public class LeMondeObserver implements Observer {

	@Override
	public void notify(String tweet) {
		if (tweet != null & tweet.contains("wine")) {
			System.out.println("Breaking news in Paris..." + tweet);
		}
	}
}
