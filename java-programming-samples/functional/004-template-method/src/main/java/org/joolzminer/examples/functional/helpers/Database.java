package org.joolzminer.examples.functional.helpers;

import org.joolzminer.examples.functional.domain.Customer;

public class Database {
	public static Customer getCustomerWithId(int id) {
		return new Customer(id, "Sergio F. Gonzalez");
	}
}
