package main;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		List<Customer> customers = new ArrayList<Customer>();
		while(true) {
			Customer c = new Customer("Matt");
			customers.add(c);
			if (customers.size() > 10000) 
				for (int i = 0; i < 5000; i++)
					customers.remove(0);
			
			Thread.sleep(1000);
		}

	}

}
