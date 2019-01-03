package test.udp;

import java.net.*;
import java.io.*;

public class TestUDPServer {
//TCP와 달리 보내기만 하고 끝 연결확인 안 함
	public static void udpSender() throws IOException {
		//1. port 번호 저장
		int port = 5555;
		
		//2. DatagramSocket 객체 생성함
		DatagramSocket userver = new DatagramSocket();//SocketException 
		
		//3. 데이터를 받을 클라이언트 주소 지정
		InetAddress clientIP = InetAddress.getByName("127.0.0.1");
		//InetAddress는 생성자가 없고 메소드가 static임	//IOException 발생
		
		//4.전송할 메세지 데이터 준비
		String message = "이것은 스팸메세지 입니다.";
		byte[] sendMsg = message.getBytes();//전송할 메세지를 byte배열로 변환
		
		//5.메세지 담을 객체 생성
		DatagramPacket packet = new DatagramPacket(sendMsg,0,sendMsg.length,clientIP,port);
									//보낼 바이트배열,몇번인덱스부터,어디까지,clientIP,port번호
		
		//6.패킷을 전송함
		userver.send(packet);
		
		//7. 소켓닫기
		userver.close();
	}
	
	public static void main(String[] args) throws IOException {
		//SocketException을 JVM에 넘김
		
		// udp 패킷 전송용 프로그램
		udpSender();
		System.out.println("스팸 전송 끝....");

	}
	

}
