package test.string.method;

public class TestStringValue {

	public static void stringToData() {
		//문자열값 => 기본자료형값으로 변경
		//파싱(parsing)
		//Wrapper(레퍼) 클래스에서 메소드로 제공
		//기본자료형에 대한 클래스
		String value = "12345";
		//String value = "apple"; //NumberFormatException
		int num = Integer.parseInt(value);
		System.out.println("num : "+num);
		
		int num2 = Integer.valueOf(value);
		//위 문장은 아래와 같음 아래의 두 문장을 자동으로 처리
		//Auto UnBoxing 처리가 되었음
		//객체 => 값
		/*Integer ref = Integer.valueOf(value);
		int num2 = ref.intValue();*/
	}
	//static 메소드는 this레퍼런스가 없어서
	//클래스명.메소드로 사용
	public static void main(String[] args) {
		// 문자열값 <=>기본자료형값 변환처리
		stringToData();
	}

}
