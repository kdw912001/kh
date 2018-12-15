package kh.day1.test;

public class TestExample1 {
	public static void main(String[] args) {
		//연습문제
		//클래스명 레퍼런스변수명 = new 클래스명();
		//레퍼런스변수.메소드명();
		TestExample1 test = new TestExample1();
		test.example();
	}
	public void example() {
		//변수 : 값 저장할 방
		//자료형 변수명 값 = 초기값;
		String 이름 = "김동욱";
		int 나이 = 25;
		double 키 = 178.5; //(소수점 아래 첫째자리까지)
		double 몸무게 = 72.3; //(소수점 아래 첫째자리까지)
		char 성별 = 'M';     //(남 : M, 여 : F)
		String 전화번호 = "010-1234-5678";
		String 이메일 = "hong123@iei.or.kr";
		
		System.out.println("이름 : "+ 이름);
		System.out.println("나이 : "+ 나이);
		System.out.println("키 : " +키);
		System.out.println("몸무게 : "+몸무게);
		System.out.println("성별 : "+ 성별);
		System.out.println("전화번호 :" +전화번호);
		System.out.println("이메일 : " +이메일);
				
	}
}
