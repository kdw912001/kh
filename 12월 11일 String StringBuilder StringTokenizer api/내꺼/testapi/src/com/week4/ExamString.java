package com.week4;

import java.util.Scanner;

public class ExamString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 입력 : ");
		String str = sc.next();
		System.out.print("문자 입력 : ");
		char ch = sc.next().charAt(0);
		
		System.out.println(preChar(str));
		System.out.println(charSu(str,ch));
		
	}
	public static String preChar(String s) {
		
		return s.replace(s.charAt(0), s.toUpperCase().charAt(0));
	}
	public static int charSu(String s, char ch) {
		int count=0;
		for(int i=0; i<s.length();i++) {
			if(s.charAt(i)==ch)
				count++;
		}
		return count;
	}


}
