package com.practice.controller;

import com.practice.model.vo.*;

public class Run {
	public static void main(String[] args) {
		Vehicle[] arr = new Vehicle[3];
		
		arr[0] = new Car("BMW", 12.5, "sedan", 4);
		arr[1] = new Airplane("����747", 0.062, "���� ��Ʈ��", 16, 5);
		arr[2] = new Ship("���ù�", 3.0, "�", 1);
		
		//���� for��
		/* for(Ŭ���� ���۷������� : �迭��){
		 * 	   ���۷���.�޼ҵ�():
		 * }
		 */
		
		for(Vehicle ref : arr) {
			System.out.println(ref.toString());
			System.out.println(ref.howToMove());
			System.out.println(ref.howToStop());
			System.out.println("-------------------");
		}
	}
}
