package org.joolzminer.examples.functional;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.joolzminer.examples.functional.domain.Bond;
import org.joolzminer.examples.functional.domain.Loan;
import org.joolzminer.examples.functional.domain.Product;
import org.joolzminer.examples.functional.domain.Stock;

public class ProductFactory {
	
	@SuppressWarnings("serial")
	public static final Map<String,Supplier<Product>> supplierByNameMap = new HashMap<String,Supplier<Product>>() {{
		put("loan", Loan::new);
		put("bond", Bond::new);
		put("stock", Stock::new);
	}};
	
	public static Product createProduct(String name) {
		Supplier<Product> productSupplier = supplierByNameMap.get(name);
		if (productSupplier != null) {
			return productSupplier.get();
		} else {
			throw new IllegalArgumentException("No such product: " + name);
		}
	}
}
