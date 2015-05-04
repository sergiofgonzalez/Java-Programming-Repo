package org.joolzminer.examples.functional;

@FunctionalInterface
public interface ValidationStrategy {
	boolean execute(String s);
}
