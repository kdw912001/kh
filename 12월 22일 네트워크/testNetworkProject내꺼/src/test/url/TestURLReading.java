package test.url;

import java.net.*;
import java.io.*;

public class TestURLReading {

	public static void main(String[] args) {
		// url의 파일을 읽어와서 콘솔에 출력
		String urlStr = "https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html";
		BufferedReader br = null;
		
		//Input스트림으로 읽으면 int로 읽기 때문에 보조 스트림(Buffer) 이용
		try {
			URL url = new URL(urlStr);
			br = new BufferedReader(new InputStreamReader(url.openStream()));
			//url.openStream 리턴 값이 InputStream
			
			int lineNumber = 1;//읽을 때마다 줄번호
			String lineStr = null;
			while((lineStr = br.readLine()) !=null) {//readLine이 다 읽으면 null리턴
				System.out.println(lineNumber++ + " : "+lineStr);//lineNumber는 먼저 출력하고 1증가
			}
			System.out.println("================================");
			URLConnection uc = url.openConnection();//URLConnection객체 생성
			System.out.println("file : "+url.getFile());//파일 경로
			System.out.println("length : "+uc.getContentLength());//파일의 용량 -1로출력(대상 웹사이트에서 차단)
			System.out.println("type : "+uc.getContentType());//컨텐츠타입조회
			System.out.println("encoding : "+uc.getContentEncoding());//UTF-8일 경우 null
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
