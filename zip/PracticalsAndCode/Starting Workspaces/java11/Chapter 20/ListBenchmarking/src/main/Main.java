package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Date start = new Date();
		
		List<Book> books = new ArrayList<Book>();
		for (int i = 0; i < 10000000; i++) {
			books.add(new Book(i,"Jane Eyre","Charlotte Bronte",14.99));
		}
		
		Date end = new Date();
		System.out.println("Elapsed time was " + (end.getTime() - start.getTime()) +" ms.");
	}
}
