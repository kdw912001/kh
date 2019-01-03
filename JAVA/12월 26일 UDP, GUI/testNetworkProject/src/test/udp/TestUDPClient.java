package test.udp;

import java.net.*;
import java.io.*;

public class TestUDPClient {
	
	public static void udpReciever() throws IOException {
		//1. �����͸� �ޱ� ���� byte[] �غ�
		byte[] recieveMsg = new byte[1024];
		
		//2. ���ϰ� ��Ŷ ��ü ����
		DatagramSocket uclient = 
				new DatagramSocket(5555);
		DatagramPacket packet = 
				new DatagramPacket(recieveMsg, 1024);
		
		//3. ������ �ޱ�
		uclient.receive(packet);
		
		//4. ���� ������ ��� Ȯ��
		String message = new String(recieveMsg);
		System.out.println("���� �޼��� : " + message);
		
		//5. ���� �ݱ�
		uclient.close();
	}

	public static void main(String[] args) throws IOException {
		// udp ������ �޴� ���α׷�
		System.out.println("udpReciever run...");
		udpReciever();
	}

}
