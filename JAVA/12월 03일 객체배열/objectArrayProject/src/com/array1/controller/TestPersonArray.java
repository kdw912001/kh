package com.array1.controller;

import java.util.Scanner;

import com.oop.array1.model.Person;

public class TestPersonArray {

	public static void main(String[] args) {
		// ��ü�迭�ǽ� ����1
		// Person ���� �׽�Ʈ
		Person[] par = new Person[5];
		Scanner sc = new Scanner(System.in);
		
		//Ű����� �Է¹޾� ���
		for(int i = 0; i < par.length; i++) {
			par[i] = new Person();
			
			System.out.print(i + "��° �̸� : ");
			par[i].setName(sc.next());
			System.out.print("���� : ");
			par[i].setAge(sc.nextInt());
			System.out.print("Ű : ");
			par[i].setHeight(sc.nextDouble());
			System.out.print("������ : ");
			par[i].setWeight(sc.nextDouble());
			System.out.print("��� : ");
			par[i].setMoney(sc.nextInt());
		}
		
		//���
		double sumHeight = 0, sumWeight = 0;
		int sumAge = 0, sumMoney = 0;
		
		for(int i = 0; i < par.length; i++) {
			System.out.println(par[i].personInfo());
			
			sumHeight += par[i].getHeight();
			sumWeight += par[i].getWeight();
			sumAge += par[i].getAge();
			sumMoney += par[i].getMoney();
		}
		
		System.out.println("Ű ��� : " 
				+ sumHeight / par.length);
		System.out.println("��������� : " 
				+ sumWeight / par.length);
		System.out.println("���� ��� : " 
				+ sumAge / par.length);
		System.out.println("��� ��� : " 
				+ sumMoney / par.length);
		

		
	}

}
