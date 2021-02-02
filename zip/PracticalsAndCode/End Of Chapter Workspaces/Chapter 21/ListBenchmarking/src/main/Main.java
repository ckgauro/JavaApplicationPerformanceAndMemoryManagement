package main;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		
		Date start = new Date();
		Map<Book, Double> books = new HashMap<>();
		for (int i = 0; i < 10000000; i++) {
			books.put(new Book(i,"Jane Eyre","Charlotte Bronte",14.99),14.99);
		}
		
		Date end = new Date();
		System.out.println("Elapsed time was " + (end.getTime() - start.getTime()) +" ms.");
		
	}
}
