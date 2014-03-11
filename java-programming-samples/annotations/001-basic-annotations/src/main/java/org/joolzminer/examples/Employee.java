package org.joolzminer.examples;

import org.joolzminer.examples.annotation.Author;

public class Employee {
	@Author(firstName = "John", lastName = "Doe", internalEmployee = false)
	public Employee() {
	}
	
	@Author(firstName = "Jane", lastName = "Doe", internalEmployee = false)
	public void someMethod() {		
	}
}
