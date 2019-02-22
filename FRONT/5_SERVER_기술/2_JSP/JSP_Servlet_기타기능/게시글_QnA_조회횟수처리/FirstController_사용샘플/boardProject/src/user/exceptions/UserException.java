package user.exceptions;

public class UserException extends Exception{
	public UserException(){
		super("사용자 관리 관련 예외 발생");
	}
	
	public UserException(String message){
		super(message);
	}
}
