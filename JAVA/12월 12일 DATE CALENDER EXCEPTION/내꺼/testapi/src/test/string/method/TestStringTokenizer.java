package test.string.method;

import java.util.*;

public class TestStringTokenizer {

	public static void main(String[] args) {
		// java.util.StringTokenizer test
		StringTokenizer st = new StringTokenizer("servlet jsp mybatis spring");
		//기본으로 공백문자가 토큰 구분문자
		System.out.println("분리된 토큰수 : "+st.countTokens());
		
		while(st.hasMoreTokens()) {
			//index가 없기 때문에 for문보단 while문
			//더이상 토큰이 없다면 false
			System.out.println(st.nextToken());
		}
		System.out.println("----------------");
		
		StringTokenizer st2 = new StringTokenizer("eclipse,editplus staruml&exerd", ",& ");
										//구분할 필요없이 구분할 문자를 입력하면 됨
		System.out.println("토큰수 : "+st2.countTokens());
		while(st2.hasMoreTokens()) {
			System.out.println(st2.nextToken());
		}
		//나중에 jsp할 때 StringTokenizer 사용함
	}
}
