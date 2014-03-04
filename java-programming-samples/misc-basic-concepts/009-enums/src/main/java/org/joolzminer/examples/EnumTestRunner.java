package org.joolzminer.examples;


enum CustomerType {
	INDIVIDUAL,
	ORGANIZATION
}

enum EnhancedCustomerType {
	INDIVIDUAL("individual customer type"),
	ORGANIZATION("organization customer type");
	
	private String description;
	
	private EnhancedCustomerType(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return description;
	}
}


public class EnumTestRunner {

	public static void main(String[] args) {
		System.out.println("*** iterating on enum's values:");		
		for (CustomerType customerType : CustomerType.values()) {
			System.out.println(customerType);
		}
		
		System.out.println("*** switching on an enum:");
		CustomerType customerType = CustomerType.INDIVIDUAL;
		
		switch (customerType) {
			case INDIVIDUAL:
				System.out.println("customer is an individual");
				break;
			
			case ORGANIZATION:
				System.out.println("customer is an organization");
				break;
				
			default:
				System.out.println("customer is of an unknown type");
				break;
		}
		
		System.out.println("*** adding methods to enums:");
		EnhancedCustomerType enhancedCustomerType = EnhancedCustomerType.ORGANIZATION;
		System.out.println(enhancedCustomerType);
	}
}
