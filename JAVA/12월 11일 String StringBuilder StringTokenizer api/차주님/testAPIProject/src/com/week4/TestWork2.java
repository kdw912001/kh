package com.week4;

import java.util.StringTokenizer;

public class TestWork2 {

	public static void main(String[] args) {
		// �ǽ����� 2
		String str = "J a v a  P r o g r a m ";
		//��ū ó���� ���� ���
		System.out.println(str);
		//��ü ���ڰ��� ���
		System.out.println("���ڰ��� : " + str.length());
		
		//���ڿ� ���� ���� ������ Tocken ó���Ͽ� 
		StringTokenizer st = new StringTokenizer(str);
		//��ū ó�� �� ���ڰ��� ��� Ȯ��
		System.out.println("���ڰ��� : " + st.countTokens());
		
		//char [] �� �����Ͽ� ����Ͻÿ�.
		char[] chArr = 
			new char[st.countTokens()];
		int index = 0;
		while(st.hasMoreTokens()){
			chArr[index++] = 
					st.nextToken().charAt(0);
		}		
		
		//char [] �� ���
		for(int i = 0; i < chArr.length; i++)
			System.out.print(chArr[i]);
		System.out.println();
		
		//char [] �� �ٽ� String ���� �ٲ� �� 
		String afterStr = new String(chArr);
		//String afterStr = String.valueOf(chArr);
		
		//��� �빮�ڷ� ��ȯ�Ͽ� ���
		System.out.println(afterStr.toUpperCase());

	}

}

