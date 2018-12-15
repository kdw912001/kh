package com.week4;

import java.util.Scanner;

public class ExamTest {

	public static void main(String[] args) {
		// 실습문제 4 테스트
		Scanner sc = new Scanner(System.in);
		ExamString exam = new ExamString();
		
		System.out.print("문자열 입력 : ");
		String str = sc.next();
		System.out.print("문자 입력 : ");
		char ch = sc.next().charAt(0);

		System.out.println(exam.preChar(str));
		System.out.println("갯수 : " + 
				exam.charSu(str, ch));
	}

}
