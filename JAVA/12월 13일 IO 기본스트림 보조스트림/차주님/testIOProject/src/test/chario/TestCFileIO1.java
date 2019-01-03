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
			fw = new FileWriter(fileName);
			//대상 파일이 없으면 파일을 새로 만듦
			//대상 파일이 있으면, 새로쓰기 상태로 열림
			
			fw.write('A');
			fw.write("java program" + "\n");
			char[] charr = {'a', 'p', 'p', 'l', 'e'};
			fw.write(charr);
			fw.flush();
			
			System.out.println("파일 기록 저장 완료.");
			
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
	
	//문자스트림으로 파일로 부터 읽어와서
	//콘솔에 출력
	public void fileRead() {
		//FileReader fr = null;
		
		System.out.print("읽을 파일명 : ");
		String fileName = sc.next();
		
		try(FileReader fr = 
				new FileReader(fileName);) {
			//fr = new FileReader(fileName);
			//파일이 없으면 에러임
			
			int readData;
			while((readData = fr.read()) != -1) {
				System.out.print((char)readData);
			}
			
			System.out.println("\n파일읽기 완료.");
			
		} catch (Exception e) {
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
		//test.fileSave();
		test.fileRead();

	}

}






