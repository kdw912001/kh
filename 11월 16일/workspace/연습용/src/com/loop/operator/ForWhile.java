package com.loop.operator;
import java.util.*;



public class ForWhile{
	
	public void printStar1() {
		System.out.print("���� �ϳ� �Է� : ");
		int a=new Scanner(System.in).nextInt();
		
		if(a>0)
			for(int i=1; i<=a; i++) {
				System.out.println(i);
				for(int j=0; j<i;j++) {
					if(i==a)
						break;
					else
						System.out.print("*");
				}
			}
		else
			System.out.println("����� �ƴմϴ�.");
			
	}
	
	public void printStar2() {
		System.out.print("���� �Է� : ");
		int a = new Scanner(System.in).nextInt();
		if(a>0)
			for(int i=0; i<a; i++)
			{
				
				for(int j=0; j<=i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		else if(a==0)
		{
			System.out.print("��� ����� �����ϴ�.");
		}
		else
		{
			a=-a;
			for(int i=0;i<a;i++) {
				for (int j=0; j<(a-i);j++) {
				System.out.print("*");
				}
				System.out.println();
				for(int k=0; k<=i; k++) {
				System.out.print(" ");
				}
			}
		}
	}
		
	
	
	public void countInputCharacter() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���ڿ� �Է� : ");
		String str = sc.next();
		int count = 0;
		for(int i=0; i<str.length(); i++) {
			char ch1=str.charAt(i);
			if((ch1>='a'&& ch1<='z') || (ch1>='A' && ch1<='Z')) {
				/*if(i==str.length()-1) {
					System.out.println("���Ե� ���� : "+count+"��");
				}
				else {
					
				}*/
					
			}
			else {
				System.out.println("�����ڰ� �ƴմϴ�.");
				System.exit(0);
			}
		}
		
		System.out.print("���� �Է� : ");
		char ch = sc.next().charAt(0);
		for(int j=0; j<str.length();j++) {
			
			if(str.charAt(j)==ch) {
					count+=1;
			}
			
		}
		System.out.println("���Ե� ���� : "+count+"��");
			
		
				
	}

}

