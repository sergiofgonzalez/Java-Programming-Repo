package org.joolzminer.examples.predicates.runner;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.joolzminer.examples.domain.Apple;

public class LambdasRunner {
	
	@SuppressWarnings("serial")
	private static List<Apple> apples = new ArrayList<Apple>() {{ 
		add(new Apple("Fuji", "pink", 150));
		add(new Apple("Green Lady", "green", 80));
		add(new Apple("Golden", "yellow", 125));		
	}};
	
	
	public static void main(String[] args) {
		// Pre Java 8
		@SuppressWarnings("unused")
		Comparator<Apple> byNameOldSchool = new Comparator<Apple>() {

			@Override
			public int compare(Apple apple1, Apple apple2) {
				return apple1.getName().compareTo(apple2.getName());
			}
		};
		
		@SuppressWarnings("unused")
		Comparator<Apple> byWeightOldSchool = new Comparator<Apple>() {

			@Override
			public int compare(Apple apple1, Apple apple2) {
				return apple1.getWeight().compareTo(apple2.getWeight());
			}
		};
		
		
		Comparator<Apple> byName = (Apple a1, Apple a2) -> a1.getName().compareTo(a2.getName());
		Comparator<Apple> byWeight = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
		
		apples.sort(byName);
		System.out.println("Apples (sorted by name): " + apples);
		
		apples.sort(byWeight);
		System.out.println("Apples (sorted by weight): " + apples);
	}
}
