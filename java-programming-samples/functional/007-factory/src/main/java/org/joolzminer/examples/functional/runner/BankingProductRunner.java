package org.joolzminer.examples.functional.runner;


import org.joolzminer.examples.functional.OldSchoolProductFactory;
import org.joolzminer.examples.functional.ProductFactory;
import org.joolzminer.examples.functional.domain.Product;

public class BankingProductRunner {
	public static void main(String[] args) {
		
		// Old School
		Product product = OldSchoolProductFactory.createProduct("loan");		
		System.out.println(product);
		printSeparator();
		
		// Using Lambdas
		Product product2 = ProductFactory.createProduct("bond");
		System.out.println(product2);
		printSeparator();
		
	}
	
	public static void printSeparator() {
		System.out.println("==================================================");
	}
}
