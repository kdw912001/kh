package make.exception;

public class Calculator {
	public Calculator() {}
	
	public int sum(int a, int b) throws MyException{
		//내가 만든 조건 : 두 수 모두 한 자리 정수여야 함
		int result = 0;
		
		if((a>=1 && a<=9)&&(b>=1&&b<=9)) {
			result = a + b;
		}else {
			//예외 발생 시킴
			throw new MyException("두 수 모두 한자리 정수여야 합니다.");
			//throw 사용하는 구문이 있다면 메소드에 throws MyException 명시
		}
		return result;
	}
	
	public int sub(int a, int b) {
		return a-b;
	}
	public int mul(int a, int b) {
		return a*b;
	}
	public int div(int a, int b) throws MyException{
		int result = 0;
		if(b==0)
			throw new MyException("0으로 나눌 수 없습니다.");
		//throw 사용하는 구문이 있다면 메소드에 throws MyException 명시
		else
			result=a/b;
		
		return result;
	}
	

}
