package org.joolzminer.examples.predicates.runner;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.joolzminer.examples.domain.Apple;

public class PredicatesRunner {
	
	@SuppressWarnings("serial")
	private static List<Apple> apples = new ArrayList<Apple>() {{ 
		add(new Apple("red", 150));
		add(new Apple("green", 80));
		add(new Apple("yellow", 125));		
	}};

	public static void main(String[] args) {

		// Using anonymous classes
		apples.sort(new Comparator<Apple>() {

			@Override
			public int compare(Apple apple1, Apple apple2) {
				return apple1.getWeight().compareTo(apple2.getWeight());
			}
		});
		
		// Using lambdas
		apples.sort((Apple apple1, Apple apple2) -> apple1.getWeight().compareTo(apple2.getWeight()));
		
		System.out.println(apples);	
		
		// Now with Runnable
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("hello, world!!! (from a separate thread)");
			}
		});
		thread.start();
		System.out.println("Hello, world!!! (from main)");
		
		Thread lambdaThread = new Thread(() -> System.out.println("Hello, World!!! (from a separate thread using lambdas)"));
		lambdaThread.start();
		
	}
}
