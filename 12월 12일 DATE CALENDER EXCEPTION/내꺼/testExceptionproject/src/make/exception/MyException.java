package make.exception;

public class MyException extends Exception{//사용자 정의 예외 클래스
	//Exception 클래스 상속, 생성자 message
	public MyException(String message) {
		super(message);
	}
	
}
