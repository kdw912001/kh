package com.practice2.controller;

import com.practice2.model.entity.Circle;
import com.practice2.model.entity.Rectangle;

public class Main {

	public static void main(String[] args) {
		// �ǽ����� 2
		Circle[] carr = {
				new Circle(10, 10, 50),
				new Circle(100, 100, 150),
				new Circle(50, 50, 120)};
		
		Rectangle[] rarr = {
				new Rectangle(5, 5, 12, 12),
				new Rectangle(20, 10, 50, 100),
				new Rectangle(100, 100, 150, 200)};
		
		//Circle ��ü ���� ���
		for(int i = 0; i < carr.length; i++) {
			carr[i].draw();
		}
		
		//Rectangle ��ü ���� ���
		for(int i = 0; i < rarr.length; i++) {
			rarr[i].draw();
		}
		
	}

}
