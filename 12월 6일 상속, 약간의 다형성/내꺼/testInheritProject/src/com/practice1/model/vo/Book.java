package com.practice1.model.vo;

public class Book {
	
	//Field
	private String title;		//책제목
	private String author;	//저자명
	private int price;			//가격
	
	//Constructor
	public Book() {}
	public Book(String title, String author, int price) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	//Getters and Setters
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
	
	//Method
	//어노테이션(annotation)-동적 바인딩
	//컴파일러 주석문
	@Override  //Annotation->java.lang패키지 아래에서 Annotation Types 확인 가능
					//Spring에서 Annotation 안 쓰면 오류남
	public String toString() { //api에서 그대로 복사
		//return "클래스명@해시코드";   Object 클래스에 있는 원래 소스
		return this.title+",  "+this.author+",  "+this.price;
	}
	
	@Override
	public boolean equals(Object obj) { //api에서 그대로 복사
		//return this == obj;  원래 소스
		//부모레퍼런스는 후손 객체의 주소를 받을 수 있음
		//실습 문제1을 해결하려면 두 객체의 모든 필드값이 일치하는지 물어야 되는데
		//obj는 Book객체와 상속 관계일 뿐 Book 클래스의 필드값을 갖고 있지 않기 때문에 
		//Object obj = new Book();	
		//부모레퍼런스는 상속된 부모멤버에만 접근할 수 있음.
		//후손 멤버에 접근하려면, 레퍼런스가 후손클래스형이어야 함.
		//클래스형변환 : 상속 관계일 때만 가능
		Book other = (Book)obj;
		boolean result = false;
		
		if(this.title.equals(other.title) &&this.author.equals(other.author) 
				&& this.price == other.price)
			result = true;
		
		return result;
		
	}
	
	@Override
	public Object clone(){
		//return this; Object 클래스에 있는 원래 소스
		return new Book(this.title, this.author, this.price);
				
	}
}
