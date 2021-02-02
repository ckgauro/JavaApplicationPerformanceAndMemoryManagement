package com.virtualpairprogrammers.escapingreferences.customers.customerImplementation;
import com.virtualpairprogrammers.escapingreferences.customers.ReadonlyCustomer;

public class Customer implements ReadonlyCustomer {
	private String name;

	@Override
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Customer(String name) {
		this.name = name;
	}
	
	public Customer(ReadonlyCustomer c) {
		this.name = c.getName();
	}

		@Override
		public String toString() {
		return name;
	}
	
}
