package test.udp;

import java.net.*;
import java.io.*;

public class TestUDPServer {
	
	public static void udpSender() 
			throws IOException {
		//1. port 번호 지정
		int port = 5555;
		
		//2. DatagramSocket 객체 생성함
		DatagramSocket userver = 
				new DatagramSocket();
		//3. 데이터를 받을 클라이언트 주소지정
		InetAddress clientIP = 
			InetAddress.getByName("127.0.0.1");
		//4. 전송할 메세지 데이터 준비
		String message = "이것은 스팸메세지 입니다.";
		byte[] sendMsg = message.getBytes();
		
		//5. 메세지 담을 객체 생성
		DatagramPacket packet = 
			new DatagramPacket(sendMsg, 
			0, sendMsg.length, clientIP, port);
		
		//6. 패킷을 전송함
		userver.send(packet);
		
		//7. 소켓 닫기
		userver.close();
	}

	public static void main(String[] args) 
			throws IOException {
		// udp 패킷 전송용 프로그램
		udpSender();
		System.out.println("스팸 전송 끝...");
	}

}
