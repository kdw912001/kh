package com.practice1.model.vo;

public class Book {
	
	//Field
	private String title;		//å����
	private String author;	//���ڸ�
	private int price;			//����
	
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
	//������̼�(annotation)-���� ���ε�
	//�����Ϸ� �ּ���
	@Override  //Annotation->java.lang��Ű�� �Ʒ����� Annotation Types Ȯ�� ����
					//Spring���� Annotation �� ���� ������
	public String toString() { //api���� �״�� ����
		//return "Ŭ������@�ؽ��ڵ�";   Object Ŭ������ �ִ� ���� �ҽ�
		return this.title+",  "+this.author+",  "+this.price;
	}
	
	@Override
	public boolean equals(Object obj) { //api���� �״�� ����
		//return this == obj;  ���� �ҽ�
		//�θ��۷����� �ļ� ��ü�� �ּҸ� ���� �� ����
		//�ǽ� ����1�� �ذ��Ϸ��� �� ��ü�� ��� �ʵ尪�� ��ġ�ϴ��� ����� �Ǵµ�
		//obj�� Book��ü�� ��� ������ �� Book Ŭ������ �ʵ尪�� ���� ���� �ʱ� ������ 
		//Object obj = new Book();	
		//�θ��۷����� ��ӵ� �θ������� ������ �� ����.
		//�ļ� ����� �����Ϸ���, ���۷����� �ļ�Ŭ�������̾�� ��.
		//Ŭ��������ȯ : ��� ������ ���� ����
		Book other = (Book)obj;
		boolean result = false;
		
		if(this.title.equals(other.title) &&this.author.equals(other.author) 
				&& this.price == other.price)
			result = true;
		
		return result;
		
	}
	
	@Override
	public Object clone(){
		//return this; Object Ŭ������ �ִ� ���� �ҽ�
		return new Book(this.title, this.author, this.price);
				
	}
}
