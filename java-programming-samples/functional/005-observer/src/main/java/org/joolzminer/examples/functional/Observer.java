package org.joolzminer.examples.functional;

@FunctionalInterface
public interface Observer {
	void notify(String tweet);
}
