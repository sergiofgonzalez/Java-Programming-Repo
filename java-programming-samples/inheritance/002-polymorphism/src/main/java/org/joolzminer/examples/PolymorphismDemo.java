package org.joolzminer.examples;

class Person {
	public void greet() {
		System.out.println("Hi, I'm a person.");
	}
}

class Employee extends Person {	
	public void work() {
		System.out.println("I am an employee.");
	}
	
	@Override
	public void greet() {
		System.out.println("Hi, I'm with the company.");
	}
}

class Manager extends Employee {
	@Override
	public void work() {
		System.out.println("I am a manager.");
	}
	
	public void manage() {
		System.out.println("Managing...");
	}
}


public class PolymorphismDemo {
	public static void main(String[] args) {
		// Upcasting
		Employee employee = new Manager();
		System.out.println("employee.getClass().getName()=" + employee.getClass().getName());
		employee.work();
		
		// compiler prevents this
//		employee.manage();
		
		// But runtime doesn't
		((Manager)employee).manage();
		
		// Calling method that does not exist on the type
		Person person = new Manager();
		person.greet();
	}
}
