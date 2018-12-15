package com.week4;

public class ExamString {

	//1.문자열을 넘겨받아, 첫글자를 대문자로 바꾸는 메서드 작성
	  public String preChar(String s){
		  StringBuilder sb = new StringBuilder(s);
		  char ch = sb.charAt(0);
		  
		  //if(ch >= 'a' && ch <= 'z')
		  if(Character.isLowerCase(ch))
			  ch -= 32;
		  
		  sb.setCharAt(0, ch);
		  return sb.toString();
	  }

	//2.문자열에서 찾는 문자가 몇개 포함되어 있는지 반환하는 메서드 작성
	  public int charSu(String s, char ch){
		  int count = 0;
		  
		  for(int i = 0; i < s.length(); i++){
			  if(s.charAt(i) == ch)
				  count++;
		  }
		  
		  return count;
	  }
}
