package com.week4;

import java.util.Scanner;

public class ExamTest {

	public static void main(String[] args) {
		// �ǽ����� 4 �׽�Ʈ
		Scanner sc = new Scanner(System.in);
		ExamString exam = new ExamString();
		
		System.out.print("���ڿ� �Է� : ");
		String str = sc.next();
		System.out.print("���� �Է� : ");
		char ch = sc.next().charAt(0);

		System.out.println(exam.preChar(str));
		System.out.println("���� : " + 
				exam.charSu(str, ch));
	}

}
