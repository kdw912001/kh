package udp.practice;

import java.net.*;
import java.io.*;
import java.util.*;

public class UDPSpamSender {
	//192.168.30.* 
	//무작위로 10개의 ip 에
	//스팸 메세지를 전송하는 프로그램 작성
	public static void sender() {
		String[] ip = new String[10];
		
		for(int i = 0; i < ip.length; i++)
			ip[i] = "192.168.30." + (new Random().nextInt(40) + 38);

		try {
			DatagramSocket sender = new DatagramSocket(4000);
			DatagramPacket packet = null;
			
			String spam = InetAddress.getLocalHost().getHostName() + 
					" 이 보낸 스팸입니다...ㅎㅎ";
			byte[] spamMessage = spam.getBytes();
			
			for(int i = 0; i < ip.length; i++){
				packet = new DatagramPacket(spamMessage, 
						spamMessage.length, InetAddress.getByName(ip[i]),
						4000);
				sender.receive(packet);
				System.out.println(ip[i] + "로 보냄...");
			}
			
			sender.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		sender();

	}

}
