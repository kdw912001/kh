package type.test;

public class TestPosition {

	/*public static void main(String[] args) {
		//실수값의 소수점 자릿수 지정
		double dnum = Math.PI;
		System.out.println("dnum : " + dnum);
		double result = (int)(dnum * 100) / 100.0; //(int)계산(int)=(int)이므로 100.0으로 나눠서
															//(int)/(double)형으로 계산
		System.out.println("result : " + result);
	}*/
	
	public void testLogical2() {
		//일반논리연산자 &&, || 특징
		//&& : 앞이 거짓이면 뒤를 실행안함
		//|| : 앞이 참이면 뒤를 실행 안함
		int num = 12;
		
		boolean result = 100 < 0 && ++num < 0;  //false기 때문에 ++num이 실행 안됨 
															//고로 num=12
		System.out.println("result : " + result);
		System.out.println("num : " + num);
		
		boolean result2 = 100>0 || ++num<0;  //true기 때문에 num=13
		System.out.println("result2 : " + result2);
		System.out.println("num : " +num);
		
	}
}
