package com.week4;

import java.util.StringTokenizer;

public class TestWork2 {
	public static void main(String[]args) {
		String str = "J a v a P r o g r a m";
		System.out.println("��ū ó���� ���� ��� : "+str);
		System.out.println("�� ���ڰ��� ��� : "+str.length());
		StringTokenizer st = new StringTokenizer(str);
		
		
		System.out.println("��ū ó�� �� ���ڰ��� : "+st.countTokens()+"��");
		char[] ch = new char[st.countTokens()];
		int i=0;
		System.out.print("char[] �� : ");
		while(st.hasMoreTokens()) {
			ch[i++]=st.nextToken().charAt(0);
		}
		
		//char[] �� ���
		for(int k=0; k<ch.length;k++) {
			System.out.print(ch[k]);
		}
		System.out.println();
		
		//char[]�� �ٽ� String���� �ٲٴ� ���
		String str2 = new String(ch);
		System.out.println("�׳� String : "+String.valueOf(ch));
		System.out.println("char[]�� String ���� : "+str2);
		
		System.out.println("String �� �빮�ڷ� : "+str2.toUpperCase());
	}
}
