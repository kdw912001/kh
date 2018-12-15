package com.loop;
import java.util.*;

public class Count {
	
	public void countInputCharacter() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 입력 : ");
		String str = sc.nextLine();
		/*for(int i=0; i<str.length(); i++) {
			if((65<=str.charAt(i)&&str.charAt(i)<=90)||(97<=str.charAt(i)&&str.charAt(i)<=122))
			{
			}
		}
		*/
		System.out.print("문자 입력 : ");
		char ch1 = sc.next().charAt(0);
		
		int count =0;
		

		
		//영문자 a~z A~Z 저장 후 여기 없으면 영문자가 아닙니다 출력
		for(int i=0; i<str.length(); i++) {
			
			if(str.charAt(i)==ch1){
					count+=1;
				}
		}
					
		
		System.out.println("포함된 갯수 : " +count);
	}
}

