package oop.practice.controller;

import oop.practice.model.Book;

public class TestBook {

	public static void main(String[] args) {
		Book b1 = new Book();
		Book b2 = new Book("���� �ڱ��ϴ� JAVA", 20000, 0.2, "������");
		
		b1.bookInfomation();
		b2.bookInfomation();
		
		b1.setTitle("�ڹ��� ����");
		b1.setPrice(35000);
		b1.setDiscountRate(0.1);
		b1.setAuthor("����");
		b1.bookInfomation();
		
		System.out.println("������ : "+b1.getTitle());
		int discountPrice = (int) (b1.getPrice()-(b1.getPrice()*b1.getDiscountRate()));
		System.out.println("���ε� ���� : "+discountPrice);
		
		System.out.println("������ : "+b1.getTitle());
		System.out.println("���ε� ���� : "+(int)(b2.getPrice()-(b2.getPrice()*b2.getDiscountRate())));
	}

}
