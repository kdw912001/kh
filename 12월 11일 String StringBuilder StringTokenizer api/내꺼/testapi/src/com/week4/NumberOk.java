package com.week4;

import java.util.Scanner;

public class NumberOk {
	static Scanner sc = new Scanner(System.in);
	static int rnum = (int)(Math.random()*100)+1;
	public static void main(String[] args) {
		
		System.out.println("������ ���� �߻� : "+rnum);
		int qnum;
		int count=0;
		char ch = ' ';
		while(ch!='N') {
			qnum = getNumber();
			if(questionNumber(qnum)==0) {
				count++;
				System.out.print("�¾ҽ��ϴ�"+"("+count+"��)");
				System.out.print("��� �Ͻðڽ��ϱ�?(y/n) : ");
				ch = sc.next().toUpperCase().charAt(0);
				
			}else if(questionNumber(qnum)==1) {
				System.out.println("ũ��");
				count++;
			}else if(questionNumber(qnum)==-1) {
				System.out.println("�۴�");
				count++;
			}
			
		}
		System.out.println("���α׷��� �����մϴ�");
	}
	
	public static int getNumber() {
		
		System.out.print("���� �Է� : ");
		 
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
