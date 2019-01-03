package com.week4;

import java.util.StringTokenizer;

public class TestWork2 {

	public static void main(String[] args) {
		// 실습문제 2
		String str = "J a v a  P r o g r a m ";
		//토큰 처리전 글자 출력
		System.out.println(str);
		//전체 글자갯수 출력
		System.out.println("글자갯수 : " + str.length());
		
		//문자열 값을 공백 단위로 Tocken 처리하여 
		StringTokenizer st = new StringTokenizer(str);
		//토큰 처리 후 글자갯수 출력 확인
		System.out.println("글자갯수 : " + st.countTokens());
		
		//char [] 에 저장하여 출력하시오.
		char[] chArr = 
			new char[st.countTokens()];
		int index = 0;
		while(st.hasMoreTokens()){
			chArr[index++] = 
					st.nextToken().charAt(0);
		}		
		
		//char [] 값 출력
		for(int i = 0; i < chArr.length; i++)
			System.out.print(chArr[i]);
		System.out.println();
		
		//char [] 을 다시 String 으로 바꾼 후 
		String afterStr = new String(chArr);
		//String afterStr = String.valueOf(chArr);
		
		//모두 대문자로 변환하여 출력
		System.out.println(afterStr.toUpperCase());

	}

}

