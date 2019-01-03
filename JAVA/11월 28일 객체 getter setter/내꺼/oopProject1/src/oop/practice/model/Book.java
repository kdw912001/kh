package oop.practice.model;

public class Book {
	//Field
	private String title;
	private int price;
	private double discountRate;
	private String author;
	
	//Constructor
	public Book() {}
	
	public Book(String title, int price, double discountRate, String author) {
		this.title=title;
		this.price=price;
		this.discountRate=discountRate;
		this.author=author;
	}
	
	//Method
	public void bookInfomation() {
		System.out.println(this.title+"  "+this.price+"  "+this.discountRate+"  "+author);
	}
	
	//Steer & getter
	public void setTitle(String title) {
		this.title = title;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getTitle() {
		return this.title;
	}
	public int getPrice() {
		return this.price;
	}
	public double getDiscountRate() {
		return this.discountRate;
	}
	public String getAuthor() {
		return this.author;
	}
}
