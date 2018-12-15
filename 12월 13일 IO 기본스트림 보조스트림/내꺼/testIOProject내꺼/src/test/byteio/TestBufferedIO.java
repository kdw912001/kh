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
			//보조스트림은 반드시 기본 스트림이 있어야 생성 가능
			
			System.out.print("파일에 기록할 내용을 입력하세요. ");
			String str = null;
			sc.nextLine(); //버퍼 엔터키 제거
			while(!(str = sc.nextLine()).equals("exit")) {
				bout.write(str.getBytes());
			}
			bout.flush(); //혹시나 남아있을 데이터 찌꺼기 제거
			System.out.println("파일 저장 종료");
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
		} catch (IOException e) {
			System.out.println("파일 기록 오류 발생");
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				bout.close();//위에서 FileOutputStream 만들고 BufferedOutputStream 
				fout.close();//만들었기 때문에 버퍼 종료 후 파일스트림 종료
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void fileSave2() {
		System.out.print("저장할 파일명 : ");
		String fileName = sc.next();
		
		try(BufferedOutputStream bout = new BufferedOutputStream(
				new FileOutputStream(fileName));){
			//close()처리, BufferedOutputStream 한 문장에 작성 가능
						
			System.out.print("파일에 기록할 내용을 입력하세요. ");
			String str = null;
			sc.nextLine(); //버퍼 엔터키 제거
			while(!(str = sc.nextLine()).equals("exit")) {
				bout.write(str.getBytes());
			}
			bout.flush(); //혹시나 남아있을 데이터 찌꺼기 제거
			
			System.out.println("파일 저장 종료");
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
		} catch (IOException e) {
			System.out.println("파일 기록 오류 발생");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void fileRead() {
		System.out.print("읽을 파일명 : ");
		String fileName = sc.next();
		
		try(BufferedInputStream bin = new BufferedInputStream(
				new FileInputStream(fileName));){//기본스트림부터 버퍼스트림까지 연결
			int readData;
			while((readData = bin.read()) != -1) {
				System.out.print((char)readData);
			}
			System.out.println("\n파일 읽기 완료.");
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
