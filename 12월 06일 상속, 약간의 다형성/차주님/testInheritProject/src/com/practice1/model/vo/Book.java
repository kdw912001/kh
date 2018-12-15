package com.practice1.model.vo;

public class Book {
	//Field
	private String title; //책제목
	private String author; //저자명
	private int price;  //가격
	
	//Constructor
	public Book() {}

	public Book(String title, 
			String authoe, int price) {
		super();
		this.title = title;
		this.author = authoe;
		this.price = price;
	}

	//Getters and Setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthoe() {
		return author;
	}

	public void setAuthoe(String authoe) {
		this.author = authoe;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	//Method
	//어노테이션(annotation)
	//컴파일러 주석문
	@Override
	public String toString() {
		//return "클래스명@해시코드";
		return title + ", " + author 
				+ ", " + price;
	}
	
	@Override
	public boolean equals(Object obj) {
		//return this == obj;
		//부모레퍼런스는 후손 객체의 주소를 
		//받을 수 있음
		//Object obj = new Book();
		//부모레퍼런스는 상속된 부모멤버에만
		//접근할 수 있음
		//후손멤버에 접근하려면, 레퍼런스가
		//후손클래스형이어야 함.
		//클래스형변환 : 상속관계일 때만 가능
		Book other = (Book)obj;
		boolean result = false;
		
		if(this.title.equals(other.title) 
			&& this.author.equals(other.author)
			&& this.price == other.price)
			result = true;
		
		return result;
	}
	
	@Override
	public Object clone() {	
		//return this;
		return new Book(this.title, 
				this.author, this.price);
	}
}







