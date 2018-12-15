package com.week4;

import java.util.Scanner;

public class NumberOk {
	static Scanner sc = new Scanner(System.in);
	static int rnum = (int)(Math.random()*100)+1;
	public static void main(String[] args) {
		
		System.out.println("임의의 정수 발생 : "+rnum);
		int qnum;
		int count=0;
		char ch = ' ';
		while(ch!='N') {
			qnum = getNumber();
			if(questionNumber(qnum)==0) {
				count++;
				System.out.print("맞았습니다"+"("+count+"번)");
				System.out.print("계속 하시겠습니까?(y/n) : ");
				ch = sc.next().toUpperCase().charAt(0);
				
			}else if(questionNumber(qnum)==1) {
				System.out.println("크다");
				count++;
			}else if(questionNumber(qnum)==-1) {
				System.out.println("작다");
				count++;
			}
			
		}
		System.out.println("프로그램을 종료합니다");
	}
	
	public static int getNumber() {
		
		System.out.print("정수 입력 : ");
		 
		return sc.nextInt();
	}
	public static int questionNumber(int i) {
		if(rnum == i)
			return 0;
		else if(rnum >i)
			return -1;
		else
			return 1;
	}

}
