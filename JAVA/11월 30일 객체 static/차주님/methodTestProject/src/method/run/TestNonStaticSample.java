package method.run;

import test.method.NonStaticSample;

public class TestNonStaticSample {

	public static void main(String[] args) {
		// non static method 실습1
		NonStaticSample samp = 
				new NonStaticSample();

		//1. 반환값 없고 매개변수 없는 메소드
		//samp.printLottoNumbers();
		
		//2. 반환값 없고 매개변수 있는 메소드
		//매개변수(parameter) <-- 전달인자(argument)
		//매개변수와 전달인자는 반드시
		//자료형과 갯수와 순서를 일치시켜야 함
		//samp.outputChar(10, '♠');
		
		//3. 반환값 있고 매개변수 없는 메소드
		/*char rc = samp.alphabette();
		System.out.println("문자 : " + rc);*/
		//System.out.println((int)rc);
		/*System.out.println("문자 : " 
				+ samp.alphabette());*/
		
		//4. 반환값 있고 매개변수 있는 메소드
		/*String result = samp.mySubstring("java program", 2, 8);
		System.out.println("result : " + result);*/
		System.out.println("result : " + 
		samp.mySubstring("java oop program", 5, 12));
	}
	

	
}
