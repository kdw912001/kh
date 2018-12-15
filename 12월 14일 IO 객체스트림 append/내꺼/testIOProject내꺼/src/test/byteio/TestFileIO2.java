package test.byteio;

import java.util.*;
import java.io.*;

public class TestFileIO2 {
	private static Scanner sc = new Scanner(System.in);
	
	public static void menu() {
		int no;
		TestFileIO2 test = new TestFileIO2();
		
		do {
			System.out.println("**** 간단 메모장 ****");
			System.out.println();
			System.out.println("1. 새 메모 기록 저장");
			System.out.println("2. 메모 읽어오기");
			System.out.println("3. 종료");
			System.out.print("번호 선택 : ");
			no = sc.nextInt();
			
			switch(no){
			case 1: test.fileSave(); break;
			case 2:	test.fileRead(); break;
			case 3:	System.out.println("메모장을 종료합니다."); 
					return; //메인에서 실행했으니 메인으로 돌려보냄
			default : 	System.out.println("잘못 입력하셨습니다.");
						System.out.println("다시 입력하십시오.");
			}
		}while(true);	
	}
	public void fileSave() {
		//바이트기반 파일출력스트림사용
		//파일명은 키보드로 입력받음
		//기록할 내용은 키보드로 문자열로
		//입력받아서 파일에 기록함
		//반복 입력과 기록 처리함
		//종료 조건 : "exit" 가 입력되면 종료
		FileOutputStream fout = null;
		System.out.print("파일명 입력 : ");
		String filename = sc.next();
		sc.nextLine(); //버퍼의 엔터키 제거
		
		try {
			fout = new FileOutputStream(filename);
			String str = "";
			byte[]b;
			/*내가 한거
			 * System.out.print("내용을 입력 : ");
			while(!str.equals("exit")) {
				
				str = sc.nextLine();
				System.out.print("내용을 입력 : ");
				b = str.getBytes();
				fout.write(b);
			}*/
			//차주님꺼
			System.out.print("내용 입력 : ");
			while(!(str = sc.nextLine()).equals("exit")) {
				System.out.print("내용 입력 : ");
				fout.write(str.getBytes());
			}
		} catch (FileNotFoundException e) {
			System.out.println(filename + " 파일이 존재하지 않습니다.");
		}catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				fout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void fileRead() {
		//바이트기반 파일입력스트림 사용
		//저장된 파일의 내용을 읽어서
		//콘솔에 출력 처리
		FileInputStream fin= null;
		System.out.print("읽을 파일명 입력 : ");
		String filename = sc.next();
		try {
			fin = new FileInputStream(filename);
			int data;
			while((data = fin.read()) != -1) {
				System.out.print((char)data);
			}
			System.out.println();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		// 바이트기반 파일 입출력 실습
		menu();

	}

}
