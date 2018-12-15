package test.byteio;

import java.util.*;
import java.io.*;

public class TestFileIO {
	private Scanner sc = new Scanner(System.in);
	
	//바이트 기반 파일출력스트림 클래스 사용
	//파일을 하나 만들어서 
	//파일에 키보드 입력값을 기록저장 처리
	public void fileSave() {
		FileOutputStream fout = null; //지역 변수는 일단 초기화
		//만약 레퍼런스를 try안에 만들면 finally문으로 못 감. 그래서 try문 밖에 선언함.
		
		System.out.print("저장할 파일명 : "); //문자는 txt,  byte의 경우엔 파일명.dat
		String fileName = sc.next(); //파일명에는 공백 들어가면 안된다는게 원칙 요즘엔 공백이 허용되긴함
		
		try {
			fout = new FileOutputStream(fileName);//생성과 동시에 파일과 연결된 스트림 만들어짐
			System.out.println(fileName+"에 저장완료");
			//파일과 현재 프로세스가 연결된 출력스트림 생성됨.
			//파일 출력스트림 생성 시에 대상 파일이 없으면, 자동으로 파일이 만들어짐.
			//대상 파일이 존재하면, 파일 안의 내용을 지우면서 새로쓰기 상태로 파일이 오픈됨.
			
			//파일에 데이터 기록 처리
			fout.write(65);
			byte[] bar = {74, 65, 86, 65}; //JAVA
			fout.write(bar);
			String str = "oop programming";
			byte[] bstr = str.getBytes();//public byte[] getBytes()Returns:The resultant byte array
			fout.write(bstr, 4, 7);//4번 인덱스부터 7개를 wirte->programming
			
			//fout.close();
			//close()는 스트림 반납
			//예외가 발생하든 안하든 무조건 반납해야 함.
			
		} catch(FileNotFoundException e) { 
			//IOException의 후손, catch문에선 자손먼저 써야 됨.
			System.out.println("파일이 존재하지 않습니다.");
		} catch(IOException e) {
			e.printStackTrace();
		}finally {
			//예외가 발생해도 실행하고 끝남
			//예외가 발생 안해도 실행하고 끝남
			try {
				fout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//바이트 기반 파일입력스트림 클래스 사용
	//파일의 데이터를 읽어서 
	//콘솔에 출력 처리
	public void fileRead() {
		FileInputStream fin = null;
		//만약 레퍼런스를 try안에 만들면 finally문으로 못 감. 그래서 try문 밖에 선언함.
		
		System.out.print("읽을 파일명(*.dat) : ");
		String fileName = sc.next();
		
		try {
			fin = new FileInputStream(fileName);
			//대상 파일이 없으면 에러 남-FileNotFonudException(OutputStream과 다름)
			
			int data;
			while((data = fin.read()) != -1) {
				//public int read() throws IOException
				//Returns: the next byte of data, or -1 if the end of the file is reached.
				System.out.println((char)data); //char형으로 바꿔줘야함
			}
			System.out.println("\n 읽기 완료");
			
		}catch(FileNotFoundException e ) {
			System.out.println(fileName + " 파일이 존재하지 않습니다.");
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fin.close(); //close메소드는 IOExcetion
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
