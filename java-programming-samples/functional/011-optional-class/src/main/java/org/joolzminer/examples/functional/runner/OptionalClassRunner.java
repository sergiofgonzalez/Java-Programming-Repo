package org.joolzminer.examples.functional.runner;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.joolzminer.examples.functional.domain.Car;
import org.joolzminer.examples.functional.domain.Insurance;
import org.joolzminer.examples.functional.domain.Person;
import org.joolzminer.examples.functional.exception.UnavailableData;

public class OptionalClassRunner {
	public static void main(String[] args) {
		Insurance insurance = new Insurance("Allianz");
		Car car = new Car(insurance);
		Person person = new Person(car);
		
		// Person with car that is insured
		System.out.println(person
							.getCar().get()
							.getInsurance().get());	
		
		// Require non null exception
		try {
			new Insurance("Mapfre");
			new Car(null);
			Person person2 = new Person(null);
			System.out.println(person2
					.getCar().get()
					.getInsurance().get());		
		} catch (Exception e) {
			e.printStackTrace();
		}	
		printSeparator();
		
		// Optional.empty(): Creating an empty Optional
		Optional<Car> noCar = Optional.empty();
		System.out.println(noCar);
		System.out.println("isPresent: " + noCar.isPresent());
		printSeparator();
		
		
		// Optional.of(): Creating an optional from a non-null value
		Optional<Car> optCar = Optional.of(car);
		System.out.println(optCar);
		System.out.println("isPresent: " + optCar.isPresent());
		printSeparator();
		
		// Optional.of(): if car is null, a NullPointerException will be immediately thrown
		try {
			optCar = Optional.of(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		printSeparator();
		
		// Optional.ofNullable() : creating an optional from an object that may be null
		optCar = Optional.ofNullable(car);
		System.out.println(optCar);
		System.out.println("isPresent: " + optCar.isPresent());
		printSeparator();
		
		// Optional.ofNullable(): if car is null, a NullPointerException will be immediately thrown
		optCar = Optional.ofNullable(null);
		System.out.println(optCar);
		System.out.println("isPresent: " + optCar.isPresent());
		printSeparator();
		
		
		// Optional.map() : Transforming values from optional when not null
		Optional<Insurance> optInsurance = Optional.ofNullable(insurance);
		Optional<String> optName = optInsurance.map(Insurance::getName);
		System.out.println(optName);
		System.out.println(optName.isPresent());
		printSeparator();
		
		// Optional.map() : Transforming values from optional when null
		optInsurance = Optional.ofNullable(null);
		optName = optInsurance.map(Insurance::getName);
		System.out.println(optName);
		System.out.println(optName.isPresent());
		printSeparator();
		
		// Optional.map() : chaining
		// This is the equivalent of
		// person.getCar().getInsurance().getName()
		Optional<Person> optPerson = Optional.ofNullable(person);
		System.out.println(optPerson
							.flatMap(Person::getCar)
							.flatMap(Car::getInsurance)
							.map(Insurance::getName)
							.orElse("Unknown"));
		printSeparator();
		
		
		// Optional.get(): returns value when not empty
		optPerson = Optional.ofNullable(new Person(new Car(new Insurance("Allianz"))));
		System.out.println(optPerson.get());
		printSeparator();
		
		// Optional.get(): throws no SuchElementException when empty
		optPerson = Optional.ofNullable(null);
		try {
			System.out.println(optPerson.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
		printSeparator();
		
		// Optional.orElse(): returns the value if present or the given parameter otherwise
		optPerson = Optional.ofNullable(new Person(new Car(new Insurance("Allianz"))));
		System.out.println(optPerson.orElse(OptionalClassRunner.unknownPerson()));
		
		optPerson = Optional.ofNullable(null);
		System.out.println(optPerson.orElse(OptionalClassRunner.unknownPerson()));
		printSeparator();
		
		// Optional.orElseGet(): returns the value if present. Otherwise it lazily invokes the
		// Supplier function passed.
		// That is, the supplier is only called if the optional is not present.
		optPerson = Optional.ofNullable(new Person(new Car(new Insurance("Allianz"))));
		System.out.println(optPerson.orElseGet(OptionalClassRunner::unknownPerson));
		
		optPerson = Optional.ofNullable(null);
		System.out.println(optPerson.orElseGet(OptionalClassRunner::unknownPerson));
		printSeparator();		
		
		// Optional.orElseThrow(): returns the value if present. Otherwise it lazily throws
		// the specified exception.
		optPerson = Optional.ofNullable(new Person(new Car(new Insurance("Allianz"))));
		System.out.println(optPerson.orElseThrow(UnavailableData::new));
		
		optPerson = Optional.ofNullable(null);
		try {
			System.out.println(optPerson.orElseThrow(() -> new UnavailableData()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		printSeparator();		
		
		
		// Optional.ifPresent(): lets you execute an action if a value is present. 
		optPerson = Optional.ofNullable(new Person(new Car(new Insurance("Allianz"))));
		optPerson.ifPresent(System.out::println);
		
		optPerson = Optional.ofNullable(null);
		optPerson.ifPresent(System.out::println);
		printSeparator();
		
		// Combining Optionals: see static function implementations
		Optional<Insurance> cheapestInsurance = uglyNullSafeFindCheapestInsurance(optPerson, optCar);
		System.out.println(cheapestInsurance);
		
		cheapestInsurance = nullSafeFindCheapestInsurance(optPerson, optCar);
		System.out.println(cheapestInsurance);	
		printSeparator();
		
		// Filtering: call a method on an object and check some property
		optInsurance = Optional.of(new Insurance("Allianz"));
		optInsurance.filter(i -> "Allianz".equals(i.getName()))
					.ifPresent(x -> System.out.println("Insurance correctly validated"));
		printSeparator();
		
		
		// Quiz 10.2
		
		// somePerson is not empty, minAge is fulfilled
		Optional<Person> somePerson = Optional.ofNullable(new Person(new Car(new Insurance("Allianz"))));
		System.out.println(getCarInsuranceName(somePerson, 18));
		
		// somePerson is not empty, minAge is not fulfilled
		System.out.println(getCarInsuranceName(somePerson, 65));
		
		// somePerson is empty
		somePerson = Optional.ofNullable(null);
		System.out.println(getCarInsuranceName(somePerson, 18));
		printSeparator();
		
		// Practical Examples: Wrapping a potentially null value in an optional
		// map.get() cannot be rewritten to provide an optional, but you can wrap it yourself
		
		Map<String,String> capitals = new HashMap<>();
		capitals.put("Spain", "Madrid");
		capitals.put("Great Britain", "London");
		capitals.put("France", "Paris");
		
		System.out.println("Capital of Portugal: " + capitals.get("Portugal"));
		System.out.println("Capital of Portugal: " + Optional.ofNullable(capitals.get("Portugal"))
				  											.orElse("Not Available"));
		printSeparator();
		
		// Convert an validation failure into an Optional.empty()
		String numStr = "g33k";
		Optional<Integer> num;
		try {
			num = Optional.of(Integer.parseInt(numStr));
		} catch (NumberFormatException e) {
			num = Optional.empty();
		}
		num.ifPresent(System.out::println);			
		printSeparator();
		
	
	
	}
	
	
	public static Person unknownPerson() {
		System.out.println("unknownPerson factory has been called");
		return new Person(new Car(new Insurance("Unknown")));
	}
	
	
	public static Optional<Insurance> uglyNullSafeFindCheapestInsurance(Optional<Person> person, Optional<Car> car) {
		// this implementation remembers the old-school null checking logic
		if (person.isPresent() && car.isPresent()) {
			return Optional.of(findCheapestInsurance(person.get(), car.get()));
		} else {
			return Optional.empty();
		}
	}
	
	public static Optional<Insurance> nullSafeFindCheapestInsurance(Optional<Person> person, Optional<Car> car) {
		return person.flatMap(p -> car.map(c -> findCheapestInsurance(p, c)));
	}
	
	// Quiz 10.2 : Should Returns the insurance company name only if the person
	// has a Car with an Insurance and the age of the person is greater than the
	// minAge
	public static String getCarInsuranceName(Optional<Person> person, int minAge) {
		return person
					.filter(p -> p.getAge() >= minAge)
					.flatMap(Person::getCar)
					.flatMap(Car::getInsurance)
					.map(Insurance::getName)
					.orElse("Unavailable Insurance");
	}
	
	private static Insurance findCheapestInsurance(Person p, Car c) {
		return new Insurance("Cheapest LLP");
	}
	
	public static void printSeparator() {
		System.out.println("=====================================================");
	}
}
