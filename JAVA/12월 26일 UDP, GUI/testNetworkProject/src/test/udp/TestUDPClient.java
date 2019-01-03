package test.udp;

import java.net.*;
import java.io.*;

public class TestUDPClient {
	
	public static void udpReciever() throws IOException {
		//1. 데이터를 받기 위한 byte[] 준비
		byte[] recieveMsg = new byte[1024];
		
		//2. 소켓과 패킷 객체 생성
		DatagramSocket uclient = 
				new DatagramSocket(5555);
		DatagramPacket packet = 
				new DatagramPacket(recieveMsg, 1024);
		
		//3. 데이터 받기
		uclient.receive(packet);
		
		//4. 받은 데이터 출력 확인
		String message = new String(recieveMsg);
		System.out.println("받은 메세지 : " + message);
		
		//5. 소켓 닫기
		uclient.close();
	}

	public static void main(String[] args) throws IOException {
		// udp 데이터 받는 프로그램
		System.out.println("udpReciever run...");
		udpReciever();
	}

}
