package com.practice2.controller;

import com.practice2.model.entity.*;

public class TestPolymorphism {

	public static void main(String[] args) {
		// ������ �׽�Ʈ
		//��Ӱ��迡 �ִ� Ŭ������ ��
		//�θ� Ŭ������ ���۷�����
		//�ļ� ��ü�� �ּҸ� ���� �� ����
		/*Circle cir = new Circle(10, 10, 50);
		Rectangle rec = 
			new Rectangle(50, 50, 100, 200);
		
		Point p = cir;		
		p = rec;*/
		
		Point p = new Circle(10, 10, 50);
		p.draw();
		
		p = new Rectangle(50, 50, 100, 200);
		p.draw();
		
		//�ļ� ���۷����� �θ�ü�� �ּҸ�
		//���� �� ����
		//Circle cir = new Point(); //����
	
		Object obj = new Point();
		obj = new Circle();
		obj = new Rectangle();
		obj = new String();
		obj = new java.util.ArrayList();
	}

}




