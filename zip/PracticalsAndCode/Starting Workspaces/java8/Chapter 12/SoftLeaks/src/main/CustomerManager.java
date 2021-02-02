package main;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


public class CustomerManager {

	private List<Customer> customers = new ArrayList<Customer>();
	private int nextAvalailbleId = 0;
	private int lastProcessedId = -1;

	public  void addCustomer(Customer customer) {
		synchronized (this) {
			customer.setId(nextAvalailbleId);
			synchronized(customers) {
				customers.add(customer);
			}
			nextAvalailbleId++;
		}

	}

	public Optional<Customer> getNextCustomer() {

				if (lastProcessedId + 1 > nextAvalailbleId) {
					lastProcessedId++;
					return Optional.of(customers.get(lastProcessedId));
				}
				return Optional.empty();
	}	

	public void howManyCustomers() {
		int size = 0;
		size = customers.size();
		System.out.println("" + new Date() + " Customers in queue : " + size + " of " + nextAvalailbleId);
	}

}
