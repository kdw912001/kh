package udp.practice;
import java.net.*;
import java.io.*;
public class UDPSpamSender {
	//192.168.30.* 
	//무작위로 10개의 ip에 
	//스팸 메세지를 전송하는 프로그램 작성
	public static void sender() {
		int port = 4000;
		try {
			DatagramSocket ds = new DatagramSocket();
			String[] ip = new String[10];
			for(int i=0; i<ip.length;i++) {
				ip[i]=String.valueOf((int)(Math.random()*255)+1);
				InetAddress inet = InetAddress.getByName("192.168.30."+ip[i]);
				
				String msg = "Hi...";
				byte[] message = msg.getBytes();
				
				DatagramPacket dp = new DatagramPacket(message,message.length,inet,port);
				
				ds.send(dp);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		sender();

	}

}
