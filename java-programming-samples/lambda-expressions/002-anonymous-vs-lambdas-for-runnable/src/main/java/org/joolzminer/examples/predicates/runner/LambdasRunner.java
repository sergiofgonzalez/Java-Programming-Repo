package org.joolzminer.examples.predicates.runner;


public class LambdasRunner {

	public static void process(Runnable runnable) {
		runnable.run();
	}
	
	public static void main(String[] args) {
		// Runnable implementation using named class
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Hello, World!!! (from named class)");
			}
		};
		
		process(runnable);

		// Runnable implementation using anonymous inner class
		process(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Hello, World!!! (from an anonymous inner class)");				
			}
		});
		
		// Runnable implementation using a variable holding a lambda
		Runnable lambdaRunnable = () -> System.out.println("Hello, World!!! (from lambda variable)");
		process(lambdaRunnable);

		
		// Runnable implementation using inline lambda
		process(() -> System.out.println("Hello, World!!! (from inline lambda)"));
	}
}
