package org.joolzminer.examples;

import java.util.Arrays;
import java.util.Comparator;

class Person implements Comparable<Person> {

	private String firstName;
	private String lastName;
	private int age;

	public Person() {		
	}
	
	public Person(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(Person other) {
		return (this.age - other.getAge());
	}

	@Override
	public String toString() {
		return lastName + ", " + firstName + ". Age: " + age;
	}
}

class LastNameComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		String lastName1 = o1.getLastName().toUpperCase();
		String lastName2 = o2.getLastName().toUpperCase();
		if (lastName1.equals(lastName2)) {
			return o1.getFirstName().toUpperCase()
						.compareTo(o2.getFirstName().toUpperCase()); 
		} else {
			return lastName1.compareTo(lastName2);
		}
	}
	
}

class FirstNameComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		String firstName1 = o1.getFirstName().toUpperCase();
		String firstName2 = o2.getFirstName().toUpperCase();
		if (firstName1.equals(firstName2)) {
			return o1.getLastName().toUpperCase()
						.compareTo(o2.getLastName().toUpperCase()); 
		} else {
			return firstName1.compareTo(firstName2);
		}
	}
	
}

public class ComparatorAndComparableTestRunner {
	public static void main(String[] args) {
		Person[] persons = { new Person("Elvis", "Goodyear", 56),
								new Person("Stanley", "Clark", 8),
								new Person("Jane", "Graff", 16),
								new Person("Nancy", "Goodyear", 69)};
		
		System.out.println("*** Natural Order:");
		for (int i = 0; i < persons.length; i++) {
			System.out.println(persons[i]);
		}
		System.out.println();
		
		System.out.println("*** Order by last name:");
		Arrays.sort(persons, new LastNameComparator());
		for (int i = 0; i < persons.length; i++) {
			System.out.println(persons[i]);
		}
		System.out.println();		
		
		System.out.println("*** Order by first name:");
		Arrays.sort(persons, new FirstNameComparator());
		for (int i = 0; i < persons.length; i++) {
			System.out.println(persons[i]);
		}
		System.out.println();
		
		System.out.println("*** Order by age:");
		Arrays.sort(persons);
		for (int i = 0; i < persons.length; i++) {
			System.out.println(persons[i]);
		}
		System.out.println();
	}
}
