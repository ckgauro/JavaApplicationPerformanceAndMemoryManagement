package main;

public class Book implements ReadonlyBook {
	private int id;
	private String title;
	private String author;
	private Price price;
	
	@Override
	public int getId() {
		return id;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public String getAuthor() {
		return author;
	}

	public Book(int id, String title, String author, Double price) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = new Price(price);
	}

	@Override
	public String toString() {
		return title + " by " + author;
	}

	@Override
	public Price getPrice() {
		return this.price;
	}
	
	public void setPrice(Double price) {
		this.price = new Price(price);
	}
	
}
