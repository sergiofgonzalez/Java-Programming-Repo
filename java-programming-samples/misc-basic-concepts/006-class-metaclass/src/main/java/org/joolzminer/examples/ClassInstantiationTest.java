package org.joolzminer.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class SomeClass {
	int num;
	
	public SomeClass() {
		num = 0;
	}
	
	public SomeClass(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "SomeClass [num=" + num + "]";
	}	
}

public class ClassInstantiationTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(ClassInstantiationTest.class);

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Class<SomeClass> clazz = null;
		try {
			clazz = (Class<SomeClass>) Class.forName("org.joolzminer.examples.SomeClass");
		} catch (ClassNotFoundException e) {
			LOGGER.error("error using Class.forName(\"SomeClass\"): {}", e.getMessage());
			System.exit(1);
		}
		
		if (clazz != null) {
			SomeClass obj = null;
			try {
				obj = clazz.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				LOGGER.error("error using Class.newInstance(): {}", e);
				System.exit(1);
			}

			System.out.println("*** obj=" + obj);
		}
	}
}
