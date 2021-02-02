package main;

public interface ReadonlyBook {

	int getId();

	String getTitle();

	String getAuthor();

	String toString();

	Price getPrice();

}