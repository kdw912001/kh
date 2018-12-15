package com.array1.controller;

import java.util.Scanner;

import com.oop.array1.model.Person;

public class TestPersonArray {

	public static void main(String[] args) {
		// 객체배열실습 문제1
		// Person 실행 테스트
		Person[] par = new Person[5];
		Scanner sc = new Scanner(System.in);
		
		//키보드로 입력받아 기록
		for(int i = 0; i < par.length; i++) {
			par[i] = new Person();
			
			System.out.print(i + "번째 이름 : ");
			par[i].setName(sc.next());
			System.out.print("나이 : ");
			par[i].setAge(sc.nextInt());
			System.out.print("키 : ");
			par[i].setHeight(sc.nextDouble());
			System.out.print("몸무게 : ");
			par[i].setWeight(sc.nextDouble());
			System.out.print("재산 : ");
			par[i].setMoney(sc.nextInt());
		}
		
		//출력
		double sumHeight = 0, sumWeight = 0;
		int sumAge = 0, sumMoney = 0;
		
		for(int i = 0; i < par.length; i++) {
			System.out.println(par[i].personInfo());
			
			sumHeight += par[i].getHeight();
			sumWeight += par[i].getWeight();
			sumAge += par[i].getAge();
			sumMoney += par[i].getMoney();
		}
		
		System.out.println("키 평균 : " 
				+ sumHeight / par.length);
		System.out.println("몸무게평균 : " 
				+ sumWeight / par.length);
		System.out.println("나이 평균 : " 
				+ sumAge / par.length);
		System.out.println("재산 평균 : " 
				+ sumMoney / par.length);
		

		
	}

}
