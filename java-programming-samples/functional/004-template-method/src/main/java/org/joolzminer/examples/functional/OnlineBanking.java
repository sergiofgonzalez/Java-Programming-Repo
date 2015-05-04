package org.joolzminer.examples.functional;

import java.util.function.Consumer;

import org.joolzminer.examples.functional.domain.Customer;
import org.joolzminer.examples.functional.helpers.Database;

public class OnlineBanking {
	public void processCustomer(int id, Consumer<Customer> customerProcessor) {
		Customer c = Database.getCustomerWithId(id);
		customerProcessor.accept(c);
	}
}
