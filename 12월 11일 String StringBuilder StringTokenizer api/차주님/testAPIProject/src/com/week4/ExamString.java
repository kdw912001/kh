package com.week4;

public class ExamString {

	//1.���ڿ��� �Ѱܹ޾�, ù���ڸ� �빮�ڷ� �ٲٴ� �޼��� �ۼ�
	  public String preChar(String s){
		  StringBuilder sb = new StringBuilder(s);
		  char ch = sb.charAt(0);
		  
		  //if(ch >= 'a' && ch <= 'z')
		  if(Character.isLowerCase(ch))
			  ch -= 32;
		  
		  sb.setCharAt(0, ch);
		  return sb.toString();
	  }

	//2.���ڿ����� ã�� ���ڰ� � ���ԵǾ� �ִ��� ��ȯ�ϴ� �޼��� �ۼ�
	  public int charSu(String s, char ch){
		  int count = 0;
		  
		  for(int i = 0; i < s.length(); i++){
			  if(s.charAt(i) == ch)
				  count++;
		  }
		  
		  return count;
	  }
}
