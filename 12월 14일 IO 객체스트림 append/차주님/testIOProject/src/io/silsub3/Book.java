package io.silsub3;

import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class Book implements Serializable{
	private static final long serialVersionUID = 1L;

	//Field
	private String title;		//도서명
	private String author;		//저자
	private int price;			//가격
	private Calendar dates;		//출판날짜
	private double discountRate;	//할인율

	//Constructor
	public Book(){}
	
	public Book(String title, String author, int price, 
			Calendar dates, double discountRate) {
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

	@Override
	public String toString(){
		//날짜에 포맷 적용함 ("yyyy'년' MM'월' dd'일 출간')
		SimpleDateFormat fmt = 
				new SimpleDateFormat("yyyy'년' MM'월' dd'일 출간'");
		return this.title + ", " + this.author + ", " + this.price + ", " + 
						fmt.format(this.dates.getTime()) + ", " 
						+ this.discountRate;
	}
}






