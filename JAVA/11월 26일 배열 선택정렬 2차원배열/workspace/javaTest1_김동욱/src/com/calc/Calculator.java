package com.calc;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1�ڸ� ������ 4Ģ�����ϴ� ���α׷��Դϴ�. 2���� ������ �Է����ּ���.");
		System.out.print("���� �ϳ� �Է� : ");
		int num1 = sc.nextInt();
	/*	if(num1<1 || num1>9) {
			System.out.println("1~9 ������ �Է��ϼ���.");
			return;
		}*/
		System.out.print("�ٸ� ���� �Է� : ");
		/*if(num1<1 || num1>9) {
			System.out.println("1~9 ������ �Է��ϼ���.");
			return;
		}*/
		int num2 = sc.nextInt();
		System.out.println("�� : "+(num1+num2));
		System.out.println("�� : "+(num1-num2));
		System.out.println("�� : "+(num1*num2));
		if(num2==0||num2<0)
			System.out.println("�и� 0�̰ų� 0���� �۽��ϴ�. ����� : 0");
		else
			System.out.println("������ : "+(num1/num2));

	}

}
