package test.chario;

import java.io.*;

public class TestByteToCharStream {

	public static void main(String[] args) {
		//바이트스트림을 문자스트림으로 바꾸기
		// 읽기용스트림에만 적용할 수 있음
		//기본스트림은 inputStream 임  보조스트림은 Reader 임
		
		//키보드 장치 : System.in   API 필드를 보면 변수형태가 static InputStream
		//public static final InputStream.in
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));//보조 스트림 2개를 연결
		//바이트스트림을 문자스트림으로 바꾸는 작업을 할 수 있음
		//얘는 예외 처리가 없음
		
		
		System.out.println("입력할 내용 : ");
		StringBuilder sb = new StringBuilder();
		String str = null;
		try {
			while((str = br.readLine()).equals("exit") == false) {
				sb.append(str + "\n");
			}
			
			System.out.println("--------------------");
			System.out.println(sb.toString());
			System.out.println("--------------------");
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}
	}
}	
