package org.joolzminer.examples.functional;

import org.joolzminer.examples.functional.domain.Customer;
import org.joolzminer.examples.functional.helpers.Database;

public abstract class ClassicBanking {
	void processCustomer(int id) {
		Customer c = Database.getCustomerWithId(id);
		performAdditionalOperation(c);
	}
	
	public abstract void performAdditionalOperation(Customer c);
}
