package io.silsub;

import java.io.*;
import java.util.*;

public class TestSilsub1 {
	private Scanner sc = new Scanner(System.in);
	
	public TestSilsub1() {}
	
	public void fileSave() {		
		System.out.print("저장할 파일명 : ");
		String fileName = sc.next();
		
		try(BufferedWriter bw 
			= new BufferedWriter(
				new FileWriter(fileName));) {
					
			System.out.println("파일에 저장할 내용을 입력하세요.");
			String line = null;
			sc.nextLine();  //버퍼 엔터키 제거
			while(!(line = sc.nextLine()).equals("exit")) {
				bw.write(line + "\n");
			}
			bw.flush();
			
			System.out.println("파일에 성공적으로 저장되었습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void fileRead() {
		System.out.print("읽을 파일명 : ");
		String fileName = sc.next();
		
		try(BufferedReader br 
			= new BufferedReader(
				new FileReader(fileName)); ){
			StringBuilder sb = new StringBuilder();
			String line = null;
			while((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			
			System.out.println("파일의 내용은 다음과 같습니다.");
			System.out.println(sb.toString());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// 입출력 실습문제 1
		TestSilsub1 test1 = new TestSilsub1();
		//test1.fileSave();
		test1.fileRead();

	}

}
