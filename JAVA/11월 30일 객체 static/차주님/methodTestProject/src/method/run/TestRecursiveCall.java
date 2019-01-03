package method.run;

public class TestRecursiveCall {
	
	//펙토리얼 구하기 : 재귀호출 메소드
	//5! = 5*4*3*2*1
	public static int fectorial(int num) {
		if(num == 1)
			return 1;
		else 
			return num * fectorial(num - 1);
	}

	public static void main(String[] args) {
		// 재귀호출 메소드 테스트
		System.out.println("5! : " + fectorial(5));
	}

}








