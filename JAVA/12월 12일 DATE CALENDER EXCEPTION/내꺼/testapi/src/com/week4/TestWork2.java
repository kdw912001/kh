package com.week4;

import java.util.StringTokenizer;

public class TestWork2 {
	public static void main(String[]args) {
		String str = "J a v a P r o g r a m";
		System.out.println("토큰 처리전 글자 출력 : "+str);
		System.out.println("전 글자갯수 출력 : "+str.length());
		StringTokenizer st = new StringTokenizer(str);
		
		
		System.out.println("토큰 처리 후 글자갯수 : "+st.countTokens()+"개");
		char[] ch = new char[st.countTokens()];
		int i=0;
		System.out.print("char[] 값 : ");
		while(st.hasMoreTokens()) {
			ch[i++]=st.nextToken().charAt(0);
		}
		
		//char[] 값 출력
		for(int k=0; k<ch.length;k++) {
			System.out.print(ch[k]);
		}
		System.out.println();
		
		//char[]을 다시 String으로 바꾸는 방법
		String str2 = new String(ch);
		System.out.println("그냥 String : "+String.valueOf(ch));
		System.out.println("char[]을 String 으로 : "+str2);
		
		System.out.println("String 을 대문자로 : "+str2.toUpperCase());
	}
}
