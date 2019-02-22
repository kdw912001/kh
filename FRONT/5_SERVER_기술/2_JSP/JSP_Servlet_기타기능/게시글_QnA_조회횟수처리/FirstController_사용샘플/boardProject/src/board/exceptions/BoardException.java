package board.exceptions;

public class BoardException extends Exception{
	public BoardException(){
		super("게시글 서비스 관련 에러 발생");
	}
	
	public BoardException(String message){
		super(message);
	}
}
