package org.joolzminer.examples.functional;

public class NYTimesObserver implements Observer {

	@Override
	public void notify(String tweet) {
		if (tweet != null & tweet.contains("money")) {
			System.out.println("Breaking news in NY..." + tweet);
		}
	}
}
