package oop.model.vo;

import java.util.Scanner;

public class Person {
	//자료형이 다른 변수(필드)들의 묶음 + 접근제한기능 =>클래스
	//멤버변수(Field)
	//접근제한자 [예약어] 자료형 필드명 [ = 초기값];
	private String name; //이름   
					//private이 있으면 캡슐화(class 밖에서 접근 못함), class내에서만 사용가능
					//private 없으면 (default) 상태임. class밖에서 접근 가능,같은 패키지 내에서 가능(구조체와 동일)
					//public 패키지 안팎 어디서나 접근 가능(완전 공개)
	private int age; //나이
	private char gender; //성별
	private String phone; //전화번호
	private double point; //포인트
	
	//생성자(Constructor)
	//
	
	//멤버함수(Method)
	//필드는 private으로 보호(캡슐화) 하고 멤버함수를 호출하여 사용
	public void inputName() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 : ");
		name = sc.next();
	}
	public void printPerson() {
		System.out.println(name+", "+age+"세, "+gender+"자, "+phone);
	}
	
}
