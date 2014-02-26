package org.joolzminer.examples;

class Animal {
	private float weight;

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public final void incrementWeight(float increment) {
		weight += increment;
	}
	
	public void move(String location) {
		System.out.println("animal moving to " + location);
	}
}


class Bird extends Animal {

	@Override
	public void move(String location) {
		System.out.println("bird flying to " + location);
	}

	// Error: cannot override final method
//	@Override
//	public void incrementWeight(float increment) {		
//	}
}

public class FinalMethodsTest {

}
