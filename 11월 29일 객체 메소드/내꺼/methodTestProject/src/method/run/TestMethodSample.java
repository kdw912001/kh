package method.run;

import nonstatic.method.sample.MethodSample;

public class TestMethodSample {

	public static void main(String[] args) {
		// method test
		//non-static method 사용 테스트
		MethodSample msamp = new MethodSample();
		
		//1. 반환값 없고 매개변수 없는 메소드 사용
		//레퍼런스.메소드();
		msamp.printLotto();
		
		//2. 반환값 없고, 매개변수 있는 메소드 사용
		//레퍼런스.메소드(전달값);
		msamp.printUnicode('K');
		
		//3. 반환값 있고, 매개변수 없는 메소드 사용
		//리턴값 받아줄 변수 = 레퍼런스.메소드();
		int value = msamp.random1to100();
		System.out.println("value : "+ value);
		
		//4. 반환값 있고 매개변수 있는 메소드 사용
		//리턴값 받아줄 변수 = 레퍼런스.메소드(매개변수에게 전달할 값);
		int result = msamp.randomInt(51, 70);
		System.out.println("result : "+result);
		
		//반환값이 있는 메소드 사용2
		//반환값을 사용하는 위치에 메소드를 바로 사용할 수 있음
		System.out.println("리턴 결과 : " + msamp.random1to100());
		
		if(msamp.randomInt(1, 10) % 2 ==0) {
			System.out.println("리턴된 값은 짝수다.");
		}else {
			System.out.println("홀수다.");
		}
	}

}
