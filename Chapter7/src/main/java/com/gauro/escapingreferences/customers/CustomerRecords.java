package com.gauro.escapingreferences.customers;

import com.gauro.escapingreferences.customers.customerImplementation.Customer;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CustomerRecords implements Iterable<Customer>{
    private Map<String, Customer> records;

    public CustomerRecords() {
        this.records = new HashMap<String, Customer>();
    }

    public void addCustomer(Customer c) {
        this.records.put(c.getName(), c);
    }

    public Map<String, Customer> getCustomers() {
        //THis  creates new HashMap
       // return new HashMap<>(this.records);

       // return Collections.unmodifiableMap(records);
        return Map.copyOf(records);
        //return this.records;
    }

    @Override
    public Iterator<Customer> iterator() {
        return records.values().iterator();
    }

//    //For set Find
//    public Customer find(String name){
//
//        return new Customer((records.get(name)));
//        //  return records.get(name);
//    }

    public ReadOnlyCustomer find(String name){

        return new Customer((records.get(name)));
      //  return records.get(name);
    }
}
