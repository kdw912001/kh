package com.practice1.controller;

import com.practice1.model.vo.Book;

public class TestSilsub1 {

	public static void main(String[] args) {
		// ��Ӱ� �������̵� �׽�Ʈ
		//�ǽ����� 1
		Book b1 = new Book("�ڹ�����", "ȫ�浿", 28000);
		Book b2 = new Book("����Ŭ11g", "�迵��", 35000);
		
		System.out.println("b1 : " + b1/*.toString()*/);
		System.out.println("b2 : " + b2/*.toString()*/);
		System.out.println("b1.equals(b2) : " + b1.equals(b2));
		
		Book b3 = new Book("�ڹ�����", "ȫ�浿", 28000);
		System.out.println("b1.equals(b3) : " + b1.equals(b3));
		System.out.println("b1 == b3 : " + (b1 == b3));
		
		Book b4 = (Book)b1.clone();
		System.out.println("b4 : " + b4);
		System.out.println("b4 : " + b4.hashCode());
		System.out.println("b1 : " + b1.hashCode());
	}

}





