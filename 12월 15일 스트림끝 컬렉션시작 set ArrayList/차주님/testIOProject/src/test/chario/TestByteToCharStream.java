package test.chario;

import java.io.*;

public class TestByteToCharStream {

	public static void main(String[] args) {
		// 바이트스트림을 문자스트림으로 바꾸기
		// 읽기용 스트림에만 적용할 수 있음
		//기본스트림은 InputStream 임
		//보조스트림이 Reader 임
		
		//키보드 장치 : System.in 
		//public static final InputStream in;
		BufferedReader br = 
			new BufferedReader(
				new InputStreamReader(
						System.in));
		
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





