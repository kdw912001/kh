package com.practice1.model.vo;

public class Book {
	//Field
	private String title; //å����
	private String author; //���ڸ�
	private int price;  //����
	
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
	//������̼�(annotation)
	//�����Ϸ� �ּ���
	@Override
	public String toString() {
		//return "Ŭ������@�ؽ��ڵ�";
		return title + ", " + author 
				+ ", " + price;
	}
	
	@Override
	public boolean equals(Object obj) {
		//return this == obj;
		//�θ��۷����� �ļ� ��ü�� �ּҸ� 
		//���� �� ����
		//Object obj = new Book();
		//�θ��۷����� ��ӵ� �θ�������
		//������ �� ����
		//�ļո���� �����Ϸ���, ���۷�����
		//�ļ�Ŭ�������̾�� ��.
		//Ŭ��������ȯ : ��Ӱ����� ���� ����
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







