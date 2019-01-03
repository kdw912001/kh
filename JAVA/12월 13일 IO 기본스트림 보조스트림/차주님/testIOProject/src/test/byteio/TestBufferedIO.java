package test.byteio;

import java.util.*;
import java.io.*;

public class TestBufferedIO {
	private Scanner sc = new Scanner(System.in);
	
	public TestBufferedIO() {}
	
	public void fileSave() {
		BufferedOutputStream bout = null;
		FileOutputStream fout = null;
		
		System.out.print("저장할 파일명 : ");
		String fileName = sc.next();
		
		try {
			fout = new FileOutputStream(fileName);
			bout = new BufferedOutputStream(fout);
			
			System.out.println("파일에 기록할 내용을 입력하세요.");
			String str = null;
			sc.nextLine();  //버퍼 엔터키 제거
			while(!(str = sc.nextLine()).equals("exit")) {
				bout.write(str.getBytes());
			}
			bout.flush();
			
			System.out.println("파일 저장 종료.");
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
		}catch (IOException e) {
			System.out.println("파일 기록 오류 발생");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				bout.close();
				fout.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void fileSave2() {		
		System.out.print("저장할 파일명 : ");
		String fileName = sc.next();
		
		try(BufferedOutputStream bout 
			= new BufferedOutputStream(
				new FileOutputStream(fileName));) {
					
			System.out.println("파일에 기록할 내용을 입력하세요.");
			String str = null;
			sc.nextLine();  //버퍼 엔터키 제거
			while(!(str = sc.nextLine()).equals("exit")) {
				bout.write(str.getBytes());
			}
			bout.flush();
			
			System.out.println("파일 저장 종료.");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void fileRead() {
		System.out.print("읽을 파일명 : ");
		String fileName = sc.next();
		
		try(BufferedInputStream bin 
			= new BufferedInputStream(
				new FileInputStream(fileName)); ){
			int readData;
			while((readData = bin.read()) != -1) {
				System.out.print((char)readData);
			}
			System.out.println("\n파일읽기 완료.");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// Buffer 를 이용한 보조스트림 사용 테스트
		TestBufferedIO test = new TestBufferedIO();
		//test.fileSave();
		//test.fileSave2();
		test.fileRead();
	}

}
