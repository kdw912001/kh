package oop.model.vo;

import java.util.Scanner;

public class Person {
	//자료형이 다른 변수(필드)들의 묶음
	// + 접근제한기능 => 클래스
	//멤버변수(Field)
	//접근제한자 [예약어] 자료형 필드명 [= 초기값];
	private String name;  //이름
	private int age;  //나이
	private char gender;  //성별
	private String phone; //전화번호
	private double point;  //포인트
	
	//생성자(Constructor)
	
	
	//멤버함수(Method)
	public void inputName() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 : ");
		name = sc.next();
	}
	
	public void printPerson() {
		System.out.println(name + ", "
				+ age + "세, " + 
				+ gender + "자, "
				+ phone);
	}
	
}








