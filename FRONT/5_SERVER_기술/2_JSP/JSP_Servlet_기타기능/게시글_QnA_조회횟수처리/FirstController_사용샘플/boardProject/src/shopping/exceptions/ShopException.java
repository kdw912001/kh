package shopping.exceptions;

public class ShopException extends Exception{
	public ShopException(){
		super("쇼핑몰 서비스 관련 예외 발생");
	}
	
	public ShopException(String message){
		super(message);
	}
}
