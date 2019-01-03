package type.test;

public class TestType {

	public static void main(String[] args) {
		//자바가 byte 자료형과 short 자료형
		//계산의 결과를 int 자료형으로 
		//정했음
		byte b =12;
		int result = b + b;
		byte result2 = (byte)(b + b); //계산결과가 int형이기 때문에 byte형변환
		
		short s = 234;
		short result3 = (short)(s + s); //계산결과가 int형이기 때문에 short형변환
		int result4 = s + s;
		
		int result5 = b + s; //자동형변환 byte형인 b->short 고로 short+short=int형
		
	}

}
