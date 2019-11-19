/**
 * <一句话功能简述>
 * <book类>
 *
 * @author sunmeng
 * @create 2019/11/14   10:00
 */
package com.it.bean;

public class Book {
	private int book_no;
	private String type_no;
	private String book_name;
	private String author;
	private String publisher;
	private double price;

	public Book() {
	}

	public Book(int book_no, String type_no, String book_name, String author, String publisher, double price) {
		this.book_no = book_no;
		this.type_no = type_no;
		this.book_name = book_name;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}

	public int getBook_no() {
		return book_no;
	}

	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}

	public String getType_no() {
		return type_no;
	}

	public void setType_no(String type_no) {
		this.type_no = type_no;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book{" +
				"book_no=" + book_no +
				", type_no='" + type_no + '\'' +
				", book_name='" + book_name + '\'' +
				", author='" + author + '\'' +
				", publisher='" + publisher + '\'' +
				", price=" + price +
				'}';
	}
}
