package test.exception;

import java.io.*;

public class TestTryCatch {

	public void fileRead() {
		//sample.txt 파일의 내용을 읽어서
		//콘솔에 출력하는 메소드
		
		try {
			FileReader fr = 
				new FileReader("sample.txt");
			
			int ch;
			while((ch = fr.read()) != -1) {
				System.out.print((char)ch);
			}
			
			System.out.println("파일 읽기 완료.");
			
		}catch(FileNotFoundException e) {
			System.out.println("sample.txt 파일이 존재하지 않습니다.");
			System.out.println("다시 실행하십시요.");
		}catch(IOException e) {
			System.out.println("파일 읽기 오류 발생...");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// try ~ catch 테스트
		new TestTryCatch().fileRead();
	}

}
