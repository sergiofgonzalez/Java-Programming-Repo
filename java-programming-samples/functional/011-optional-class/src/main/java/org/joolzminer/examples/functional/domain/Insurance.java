package org.joolzminer.examples.functional.domain;

import java.util.Optional;

public class Insurance {
	private String name;
	
	public Insurance(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public Optional<String> getNameAsOptional() {
		return Optional.ofNullable(name);
	}
}
