package test.controller;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		System.out.print("입력 : ");
		int num= new Scanner(System.in).nextInt();
		if(num>0&&num<=100) {
			if(num%2==0)
				System.out.println("2의 배수입니다.");
			else
				System.out.println("2의 배수가 아닙니다.");
		}
	}

}
