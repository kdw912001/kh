package com.loop;
import java.util.*;

public class Count {
	
	public void countInputCharacter() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���ڿ� �Է� : ");
		String str = sc.nextLine();
		/*for(int i=0; i<str.length(); i++) {
			if((65<=str.charAt(i)&&str.charAt(i)<=90)||(97<=str.charAt(i)&&str.charAt(i)<=122))
			{
			}
		}
		*/
		System.out.print("���� �Է� : ");
		char ch1 = sc.next().charAt(0);
		
		int count =0;
		

		
		//������ a~z A~Z ���� �� ���� ������ �����ڰ� �ƴմϴ� ���
		for(int i=0; i<str.length(); i++) {
			
			if(str.charAt(i)==ch1){
					count+=1;
				}
		}
					
		
		System.out.println("���Ե� ���� : " +count);
	}
}

