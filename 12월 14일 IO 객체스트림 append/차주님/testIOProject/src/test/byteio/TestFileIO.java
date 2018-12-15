package test.byteio;

import java.util.*;
import java.io.*;

public class TestFileIO {
	private Scanner sc = new Scanner(System.in);
	
	//바이트기반 파일출력스트림 클래스 사용
	//파일을 하나 만들어서
	//파일에 키보드 입력값을 기록저장 처리
	public void fileSave() {
		FileOutputStream fout = null;
		
		System.out.print("저장할 파일명 : ");
		String fileName = sc.next();
		
		try {
			fout = new FileOutputStream(fileName);
			//파일과 현재 프로세스가 연결된 출력스트림 생성됨
			//파일 출력스트림 생성시에
			//대상 파일이 없으면, 자동으로
			//파일이 만들어짐
			//대상 파일이 존재하면, 파일 안의
			//내용을 지우면서 새로쓰기 상태로
			//파일이 오픈됨			
			
			//파일에 데이터 기록 처리
			fout.write(65);
			byte[] bar = {74, 65, 86, 65};
			fout.write(bar);
			String str = "oop programming";
			byte[] bstr = str.getBytes();
			fout.write(bstr, 4, 7);
			
			//fout.close();
			//스트림 반납
			//예외가 발생하든 안하든
			//무조건 반납해야 함
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			//예외가 발생해도 실행하고 끝남
			//예외가 발생 안해도 실행하고 끝남
			try {
				fout.close();
				System.out.println(fileName + "에 저장 완료.");
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}
	}
	
	//바이트기반 파일입력스트림 클래스 사용
	//파일의 데이터를 읽어서
	//콘솔에 출력 처리
	public void fileRead() {
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
		// 바이트스트림 파일입출력 테스트
		TestFileIO test = new TestFileIO();
		//test.fileSave();
		test.fileRead();

	}

}



