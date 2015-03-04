package org.joolzminer.examples.predicates.runner;

class StringTransformer {
	private String value;
	
	public StringTransformer(String value) {
		this.value = value;
	}
	
	String getTransformed(String s) {
		return value + " " + s + ": has been transformed";
	}
}
