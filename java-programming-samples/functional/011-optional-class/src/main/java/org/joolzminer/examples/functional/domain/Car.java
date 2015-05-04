package org.joolzminer.examples.functional.domain;

import java.util.Optional;

public class Car {
	private Optional<Insurance> insurance;
	
	public Car(Insurance insurance) {
		this.insurance = Optional.of(insurance);
	}

	public Optional<Insurance> getInsurance() {
		return insurance;
	}
}
