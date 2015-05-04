package org.joolzminer.examples.functional;

public interface Subject {
	void registerObserver(Observer observer);
	void notifyObservers(String tweet);
}
