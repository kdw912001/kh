package oop.practice.controller;

import oop.practice.model.Book;

public class TestBook {

	public static void main(String[] args) {
		/*1. Book Ŭ������ ���� ��ü�� ����Ʈ �����ڸ� ����ؼ� ������
		2. �Ű����� �ִ� �����ڸ� ����ؼ� �ι�° ��ü ������
		3. 2���� ��ü�� ���� ������ ȭ�������
		<��¿�>
		null	0	0.0	null
		���� �ڱ��ϴ� JAVA	20000	0.2	������*/

		Book b1 = new Book();
		Book b2 = new Book("���� �ڱ��ϴ� JAVA", 20000, 0.2, "������");
		
		b1.bookInfomation();
		b2.bookInfomation();

		/*1. ù��° ��ü�� ���� ���� setter �� ����ؼ� ����
		2. ���Ȯ����
		<��¿�>
		null	0	0.0	null
		���� �ڱ��ϴ� JAVA	20000	0.2	������

		������ ���Ȯ��
		�ڹ��� ����     35000  0.1   ����*/
		b1.setTitle("�ڹ��� ����");
		b1.setPrice(35000);
		b1.setDiscountRate(0.1);
		b1.setAuthor("����");
		
		System.out.println("\n������ ��� Ȯ��");
		b1.bookInfomation();
		
		/*1. �� ��ü ���� �������� ������ å ������ ����ؼ� �����
		���ε� ���� = ���� - (���� * ������);

		<��°��>
		������ : �ڹ��� ����
		���ε� ���� : 31500 ��
		������ : ���� �ڱ��ϴ� �ڹ�
		���ε� ���� : 16000 ��*/
		int discountPrice1 = b1.getPrice() - (int)(b1.getPrice() * b1.getDiscountRate()); 
		int discountPrice2 = b2.getPrice() - (int)(b2.getPrice() * b2.getDiscountRate());
		
		System.out.println("\n������ : " + b1.getTitle());
		System.out.println("���ε� ���� : " + discountPrice1 + "��");
		System.out.println("������ : " + b2.getTitle());
		System.out.println("���ε� ���� : " + discountPrice2 + "��");
	}

}
