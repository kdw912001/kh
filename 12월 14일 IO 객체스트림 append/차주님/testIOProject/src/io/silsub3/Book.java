package io.silsub3;

import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class Book implements Serializable{
	private static final long serialVersionUID = 1L;

	//Field
	private String title;		//������
	private String author;		//����
	private int price;			//����
	private Calendar dates;		//���ǳ�¥
	private double discountRate;	//������

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
		//��¥�� ���� ������ ("yyyy'��' MM'��' dd'�� �Ⱓ')
		SimpleDateFormat fmt = 
				new SimpleDateFormat("yyyy'��' MM'��' dd'�� �Ⱓ'");
		return this.title + ", " + this.author + ", " + this.price + ", " + 
						fmt.format(this.dates.getTime()) + ", " 
						+ this.discountRate;
	}
}






