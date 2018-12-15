package silsub3;

import java.text.SimpleDateFormat;
import java.util.*;



public class Book implements java.io.Serializable{
	
	private static final long serialVersionUID = 6681877589150129960L;
	private String title;
	private String author;
	private int price;

	private Calendar dates;
	
	private double discountRate;
	
	public Book() {}

	
	

	public Book(String title, String author, int price, Calendar dates, double discountRate, SimpleDateFormat sdf) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.dates = dates;
		this.discountRate = discountRate;
	}




	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Calendar getDates() {
		return dates;
	}

	public void setDates(Calendar dates) {
		this.dates = dates;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String toString() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy'년' MM'월' dd'일' 출간");
		
		//String str = sdf.format(dates);
		return title+", "+author+", "+price+", "+sdf.format(dates.getTime())+", "+discountRate;
		//return title+", "+author+", "+price+", "+discountRate;
	}
	
	
}
