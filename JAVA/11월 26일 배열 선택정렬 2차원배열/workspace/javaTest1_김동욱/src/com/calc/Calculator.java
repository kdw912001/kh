package com.calc;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1자리 정수를 4칙연산하는 프로그램입니다. 2개의 정수를 입력해주세요.");
		System.out.print("정수 하나 입력 : ");
		int num1 = sc.nextInt();
	/*	if(num1<1 || num1>9) {
			System.out.println("1~9 정수만 입력하세요.");
			return;
		}*/
		System.out.print("다른 정수 입력 : ");
		/*if(num1<1 || num1>9) {
			System.out.println("1~9 정수만 입력하세요.");
			return;
		}*/
		int num2 = sc.nextInt();
		System.out.println("합 : "+(num1+num2));
		System.out.println("차 : "+(num1-num2));
		System.out.println("곱 : "+(num1*num2));
		if(num2==0||num2<0)
			System.out.println("분모가 0이거나 0보다 작습니다. 결과값 : 0");
		else
			System.out.println("나누기 : "+(num1/num2));

	}

}
