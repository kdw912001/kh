package test.exception;

import java.io.*;

public class TestTryCatch {

	public void fileRead() {
		//sample.txt 파일의 내용을 읽어서
		//콘솔에 출력하는 메소드
		
		try {
		FileReader fr = new FileReader("sample.txt");
		int ch;//리턴 타입이 int이기 때문에
		while((ch = fr.read()) != -1) { //-1이면 읽을 character의 number가 없음.
			System.out.print((char)ch);
		}
		System.out.println("파일 읽기 완료.");
		
		}/*catch(Exception e) {}*/ 
		//부모 exception이 제일 위로 올라가면 아래 catch문이 구동이 안되기 떄문에 아래 cat문이 모두 에러
		catch (FileNotFoundException e) {//IO Exception의 자손 exception
			System.out.println("sample.txt 파일이 존재하지 않습니다.");
			System.out.println("다시 실행하십시오");
		}catch(IOException e) {
			System.out.println("파일 읽기 오류 발생...");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// try ~ catch 테스트 
		new TestTryCatch().fileRead(); 
		//fileRead()가 static이 아니므로 new를 써야되는데 위와같은 방식은
		//1번만 호출함.
	}
}
