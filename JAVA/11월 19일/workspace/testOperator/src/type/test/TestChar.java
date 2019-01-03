package type.test;

public class TestChar {
	public static void main(String[] args) {
		//문자값 계산 확인
		char ch = 'a'; //97
		char result = (char)(ch +1);
		System.out.println(result + "->" + (int)result);
		
		System.out.println(++result);
		System.out.println('a' - 'A'); // 대소문자 변환 32 이용
				
	}
}
