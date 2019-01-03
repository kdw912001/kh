package oop.staticmethod;

public class TestStatic {

	public static void main(String[] args) {
		// static test
		//System.out.println(StaticMethod.value);
		System.out.println("value : " 
				+ StaticMethod.getValue());
		
		//필드값 변경
		StaticMethod.setValue("static method test");
		System.out.println("value : " 
				+ StaticMethod.getValue());
		
		//대문자로 변경
		StaticMethod.toUpper();
		System.out.println("value : " 
				+ StaticMethod.getValue());
		
		//글자갯수 확인
		System.out.println("글자갯수 : " 
				+ StaticMethod.valueLength());
		
		//문자변경
		StaticMethod.setChar(6, '-');
		System.out.println("value : " 
				+ StaticMethod.getValue());
		
		//문자열 합치기
		String result = 
			StaticMethod.valueConcat("실습문제");
		System.out.println("result : " + result);
		
	}

}
