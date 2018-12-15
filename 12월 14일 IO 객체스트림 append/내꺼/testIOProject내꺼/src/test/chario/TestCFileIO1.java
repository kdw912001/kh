package test.chario;

import java.util.*;
import java.io.*;

public class TestCFileIO1 {
	private Scanner sc = new Scanner(System.in);
	
	public TestCFileIO1() {}
	
	//문자스트림으로 파일에 저장 처리
	public void fileSave() {
		FileWriter fw = null;
		
		System.out.print("저장할 파일명 : ");
		String fileName = sc.next();
		
		try {
			fw = new FileWriter(fileName,true);//대상파일과 스트림(통로) 생성
			//대상 파일이 없으면 파일을 새로 만듦
			//대상 파일이 있으면, 새로쓰기 상태로 열림
			
			fw.write('A');
			fw.write("java program \n");
			char[] charr = {'a','p','p','l','e'};
			fw.write(charr);
			fw.flush(); //스트림에서 완전히 밀어버리는 작업
						//가끔 스트림에 남는 데이터가 있는데 그걸 다 밀어버림
			
			System.out.println("파일 기록 저장 완료");
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	//문자스트림으로 파일로부터 읽어와서 콘솔에 출력
	public void fileRead() {
		//FileReader fr = null;
		
		System.out.print("읽을 파일명 : ");
		String fileName = sc.next();
		
		try(FileReader fr = new FileReader(fileName);) {
			//선언과 생성이 같이 들어가야 함. 여러 개를 쓸수 있기때문에;도 가능
			//try 옆에 이런식으로 작성하게 되면 finally 에 close()생략 가능
			
			//fr = new FileReader(fileName);
			//파일이 없으면 에러임
			
			int readData;
			while((readData = fr.read()) != -1) { //read()는 문자 하나씩 읽음
				System.out.print((char)readData); //int형이기 때문에 형변환
			}
			System.out.println("\n파일읽기 완료");
		} catch (Exception e) { 
			//각각 에러 처리할 내용이 있으면 각각 Exception
			//하나의 에러메시지만 출력할거면 Exception 하나만 작성
			e.printStackTrace();
		}/*finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/
	}
	
	public static void main(String[] args) {
		// 문자기반 파일입출력 테스트
		TestCFileIO1 test = new TestCFileIO1();
		test.fileSave();
		test.fileRead();
	}
}
