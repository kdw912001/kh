package udp.practice;

import java.net.*;
import java.io.*;

public class UDPSpamReciever {
	//무작위로 전송된 스팸메세지 받아서
	//출력하는 프로그램
	//무한루프로 전송온 패킷 정보를
	//계속 받아 출력하는 프로그램임.
	public static void reciever() {
		try {
			DatagramSocket reciever = 
					new DatagramSocket(4000);
			DatagramPacket packet = null;
			
			byte[] recieveMessage = new byte[1024];
			
			while(true){
				packet = new DatagramPacket(recieveMessage, 
						recieveMessage.length);
				reciever.receive(packet);
				System.out.println(
						packet.getAddress().getHostAddress() + 
						" 가 보낸 스팸 : " + 
						new String(packet.getData()));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		reciever();
	}

}
