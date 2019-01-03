package test.udp;

import java.net.*;
import java.io.*;

public class TestUDPServer {
	
	public static void udpSender() 
			throws IOException {
		//1. port ��ȣ ����
		int port = 5555;
		
		//2. DatagramSocket ��ü ������
		DatagramSocket userver = 
				new DatagramSocket();
		//3. �����͸� ���� Ŭ���̾�Ʈ �ּ�����
		InetAddress clientIP = 
			InetAddress.getByName("127.0.0.1");
		//4. ������ �޼��� ������ �غ�
		String message = "�̰��� ���Ը޼��� �Դϴ�.";
		byte[] sendMsg = message.getBytes();
		
		//5. �޼��� ���� ��ü ����
		DatagramPacket packet = 
			new DatagramPacket(sendMsg, 
			0, sendMsg.length, clientIP, port);
		
		//6. ��Ŷ�� ������
		userver.send(packet);
		
		//7. ���� �ݱ�
		userver.close();
	}

	public static void main(String[] args) 
			throws IOException {
		// udp ��Ŷ ���ۿ� ���α׷�
		udpSender();
		System.out.println("���� ���� ��...");
	}

}
