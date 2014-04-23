package org.joolzminer.examples;

public enum BeverageSize {
	SMALL("Tall"),
	MEDIUM("Grande"),
	LARGE("Venti");
	
	private String description;
	
	private BeverageSize(String description) {
		this.description = description;
	}
	
	public String toString() {
		return description;
	}
}
