package org.joolzminer.examples;

import java.util.Arrays;

class Elephant implements Comparable<Elephant> {
	private float weight;
	private int age;
	private float tuskLength;
	
	public Elephant(float weight, int age, float tuskLength) {
		this.weight = weight;
		this.age = age;
		this.tuskLength = tuskLength;
	}

	@Override
	public int compareTo(Elephant o) {
		if (weight > o.weight) {
			return 1;
		} else if (weight < o.weight) {
			return -1;
		} else {
			return (this.age - o.age);
		}
	}
	
	@Override
	public String toString() {
		return "Elephant [weight=" + weight + ", age=" + age + ", tuskLength="
				+ tuskLength + "]";
	}
}

public class ComparableTestRunner {
	public static void main(String[] args) {
		Elephant[] elephants = { new Elephant(100.12F, 20, 5.7F),
									new Elephant(120.12F, 20, 45F),
									new Elephant(100.12F, 25, 3.4F) };
		
		System.out.println("*** Before sorting:");
		System.out.println(Arrays.asList(elephants));

		System.out.println("*** After sorting:");
		Arrays.sort(elephants);
		System.out.println(Arrays.asList(elephants));		
	}
}
