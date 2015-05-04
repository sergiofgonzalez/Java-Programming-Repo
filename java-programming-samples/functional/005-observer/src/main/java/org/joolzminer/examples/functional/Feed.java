package org.joolzminer.examples.functional;

import java.util.ArrayList;
import java.util.List;

public class Feed implements Subject {

	private final List<Observer> observers = new ArrayList<>();
	
	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void notifyObservers(String tweet) {
		observers.forEach(observer -> observer.notify(tweet));
	}

}
