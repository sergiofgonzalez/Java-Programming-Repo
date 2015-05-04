package org.joolzminer.examples.functional;

import org.joolzminer.examples.functional.domain.Bond;
import org.joolzminer.examples.functional.domain.Loan;
import org.joolzminer.examples.functional.domain.Product;
import org.joolzminer.examples.functional.domain.Stock;

public class OldSchoolProductFactory {
	
	public static Product createProduct(String name) {
		switch (name) {
			case "loan" : 
				return new Loan();
			case "stock" :
				return new Stock();
				
			case "bond" :
				return new Bond();
				
			default :
				throw new IllegalArgumentException("No such product: " + name);
		}
	}
}
