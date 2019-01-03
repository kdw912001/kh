package test.string.method;

public class TestStringMethod {

	/*public static void main(String[] args) {
		// java.lang.String 클래스가 제공하느
		//메소드 사용 테스트
		String s = "";
		//초기값으로 빈 따옴표를 사용가능
		System.out.println("갯수 : " + s.length());
		
		//char ch = '';  //에러
		//문자는 빈 따옴표 사용 못 함
		
		String s1 = null;
		//s1 = "apple";
		if(s1 != null && s1.length() > 0)
			System.out.println(s1.length());
		else
			System.out.println("문자열값이 필요합니다.");
		
		
	}*/
	
	/*public static void main(String[] args) {
		//String 생성자 사용 테스트 
		String s1 = "apple";
		String s2 = new String("banana");
		
		byte[] bar = {74, 65, 86, 65};
		String s3 = new String(bar);
		
		char[] car = {'o', 'r', 'a', 'c', 'l', 'e'};
		String s4 = new String(car);
		
		int[] iar = {74, 65, 86, 65};
		String s5 = new String(iar, 0, iar.length);
		
		StringBuilder sb = 
			new StringBuilder("html5 & css3");
		String s6 = new String(sb);
		
		System.out.println("s1 : " + s1.toString());
		System.out.println("s2 : " + s2);
		System.out.println("s3 : " + s3);
		System.out.println("s4 : " + s4);
		System.out.println("s5 : " + s5);
		System.out.println("s6 : " + s6);
	}*/
	
	public static void main(String[] args) {
		//String 클래스 메소드 사용 테스트
		String s = "Hello";
		String n = "0123456";
		
		char c = s.charAt(1);
		char c2 = n.charAt(1);
		
		System.out.println("c = " + c);
		System.out.println("c2 = " + c2);
	}

}







