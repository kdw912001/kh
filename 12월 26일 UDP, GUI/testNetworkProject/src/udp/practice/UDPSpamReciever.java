package udp.practice;

import java.net.*;
import java.io.*;

public class UDPSpamReciever {
	//�������� ���۵� ���Ը޼��� �޾Ƽ�
	//����ϴ� ���α׷�
	//���ѷ����� ���ۿ� ��Ŷ ������
	//��� �޾� ����ϴ� ���α׷���.
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
						" �� ���� ���� : " + 
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
