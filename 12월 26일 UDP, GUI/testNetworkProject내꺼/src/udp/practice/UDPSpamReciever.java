package udp.practice;

import java.io.*;
import java.net.*;

public class UDPSpamReciever {
	// 무작위로 전송된 스팸메세지 받아서 출력하는 프로그램
	// 무한루프로 전송은 패킷 정보를 계속 받아 출력하는 프로그램
	public static void reciever() {
		int port = 4000;
		byte[] msg = new byte[1024];
		try {
			DatagramSocket ds = new DatagramSocket(8001);

			DatagramPacket dp = new DatagramPacket(msg, 1024);
			while (true) {
				ds.receive(dp);
				String ip = dp.getAddress().getHostAddress();
				String message = new String(msg);
				System.out.println(ip+"로부터 받은 메세지 : " + message);
				//ds.close();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		reciever();

	}

}
