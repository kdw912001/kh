package test.url;

import java.net.*;
import java.io.*;

public class TestURLReading {

	public static void main(String[] args) {
		// url 의 파일을 읽어와서 콘솔에 출력
		String urlStr = "https://www.oracle.com/technetwork/java/javase/downloads/index.html";
		BufferedReader br = null;
		
		try {
			URL url = new URL(urlStr);
			br = new BufferedReader(
					new InputStreamReader(
						url.openStream()));
			
			int lineNumber = 1;
			String lineStr = null;
			while((lineStr = br.readLine()) != null) {
				System.out.println(lineNumber++ 
						+ " : " + lineStr);
			}
			
			System.out.println("==============");
			URLConnection uc = url.openConnection();
			System.out.println("file : " + url.getFile());
			System.out.println("length : " + uc.getContentLength());
			System.out.println("type : " + uc.getContentType());
			System.out.println("encoding : " + uc.getContentEncoding());
			
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







