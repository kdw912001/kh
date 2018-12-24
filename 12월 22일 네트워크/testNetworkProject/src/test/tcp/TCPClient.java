package test.tcp;

import java.net.*;
import java.io.*;

public class TCPClient {
	
	public static void clientStart() {
		//1. 서버가 정한 포트번호와
		//서버의 ip주소가 필요함
		int port = 7777;
		
		BufferedReader br = null;
		PrintWriter pw = null;
		Socket socket = null;
		
		try {
			String serverIP = InetAddress.getLocalHost().getHostAddress();
			//String serverIP = "192.168.30.28";
			
			//2. 클라이언트 자신의 소켓 객체 생성함
			socket = new Socket(serverIP, port);
			//객체 생성과 동시에 서버와 연결됨.
			//서버와 연결 실패시 null 리턴됨.
			
			if(socket != null) {
				//서버와 연결이 되었다면
				
				//3. 서버와 클라이언트 간의 스트림 생성함
				br = new BufferedReader(
						new InputStreamReader(
							socket.getInputStream()));
				pw = new PrintWriter(
						socket.getOutputStream());
			
				//4. 메세지 주고 받기
				//서버로 먼저 보내고
				pw.println("안녕하세요....");
				pw.flush();
				
				//답 받기
				String recieveMsg = br.readLine();
				System.out.println("서버가 보낸 답 : "
						+ recieveMsg);
				
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				pw.close();
				br.close();
				socket.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// TCP Client 측 프로그램
		clientStart();
	}

}


