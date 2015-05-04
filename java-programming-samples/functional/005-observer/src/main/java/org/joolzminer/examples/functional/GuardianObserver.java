package org.joolzminer.examples.functional;

public class GuardianObserver implements Observer {

	@Override
	public void notify(String tweet) {
		if (tweet != null & tweet.contains("queen")) {
			System.out.println("Breaking news in London..." + tweet);
		}
	}
}
