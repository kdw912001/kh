package test.byteio;

import java.util.*;
import java.io.*;

public class TestFileIO2 {
	private static Scanner sc = new Scanner(System.in);
	
	public static void menu() {
		int no;
		TestFileIO2 test = new TestFileIO2();
		
		do {
			System.out.println("*** 간단 메모장 ***");
			System.out.println();
			System.out.println("1. 새 메모 기록 저장");
			System.out.println("2. 메모 읽어오기");
			System.out.println("3. 종료");
			System.out.print("번호 선택 : ");
			no = sc.nextInt();
			
			switch(no) {
			case 1:  test.fileSave();  break;
			case 2:  test.fileRead();  break;
			case 3:	System.out.println("메모장을 종료합니다.");
			        return;
			default: System.out.println("잘못 입력하셨습니다.");
			       System.out.println("다시 입력하십시오.");
			}
			
		}while(true);
	}
	
	public void fileSave() {
		//바이트기반 파일출력스트림 사용
		//파일명은 키보드로 입력받음
		//기록할 내용은 키보드로 문자열로
		//입력받아서 파일에 기록함
		//반복 입력과 기록 처리함
		//종료조건 : "exit" 가 입력되면 종료함
		FileOutputStream fout = null;
		
		System.out.print("저장할 파일명 : ");
		String fileName = sc.next();
		sc.nextLine();  //버퍼의 엔터키 제거
		
		try {
			fout = new FileOutputStream(fileName);
			
			System.out.println(fileName + "에 기록할 내용을 입력하세요.");
			String line = null;
			while(!(line = sc.nextLine()).equals("exit")) {
				fout.write(line.getBytes());
			}
			
			System.out.println("파일저장 완료.");
		} catch (FileNotFoundException e) {
			System.out.println(fileName + " 파일이 존재하지 않습니다.");
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fout.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void fileRead() {
		//바이트기반 파일입력스트림 사용
		//저장된 파일의 내용을 읽어서
		//콘솔에 출력 처리
		FileInputStream fin = null;
		
		System.out.print("읽을 파일명(*.dat) : ");
		String fileName = sc.next();
		
		try {
			fin = new FileInputStream(fileName);
			//대상 파일이 없으면 에러 남
			
			int data;
			while((data = fin.read()) != -1) {
				System.out.print((char)data);
			}
			
			System.out.println("\n읽기완료!");
			
		} catch (FileNotFoundException e) {
			System.out.println(fileName + " 파일이 존재하지 않습니다.");
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fin.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// 바이트기반 파일입출력 실습
		menu();

	}

}
