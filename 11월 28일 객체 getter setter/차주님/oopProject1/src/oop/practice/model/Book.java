package oop.practice.model;

public class Book {
	//Field
	private String title;		//	- title:String	//책제목
	private int price;			//	- price:int	//가격
	private double discountRate;	//	- discountRate:double	//할인율
	private String author;	//	- author:String	//저자명
	
	//Constructor
	public Book(){}

	public Book(String title, int price, 
			double discountRate, 
			String author) {
		this.title = title;
		this.price = price;
		this.discountRate = discountRate;
		this.author = author;
	}
		
	//Method
	public void bookInfomation(){
		System.out.println(this.title + ", " 
				+ this.price + ", " 
				+ this.discountRate + ", " 
				+ this.author);
	}

	//Setter & Getter
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
}
