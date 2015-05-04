package org.joolzminer.examples.functional.domain;

import java.util.Optional;

public class Person {
	private Optional<Car> car;
	
	public Person(Car car) {
		this.car = Optional.of(car);
	}

	public Optional<Car> getCar() {
		return car;
	}
	
	// for the Quiz 10.2
	public int getAge() {
		return 35;
	}
}
