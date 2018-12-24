package test.iphost;

import java.net.*;
import java.util.*;

public class TestInetAddress3 {

	public static void searchIP() {
		Scanner sc = new Scanner(System.in);
		String hostName = "";
		
		try {
			System.out.print("��ȸ�� ȣ��Ʈ�� : ");
			hostName = sc.next();
			
			InetAddress[] inets = 
				InetAddress.getAllByName(hostName);
			
			System.out.println("��ȸ�� ȣ��Ʈ�� ���� ���� : "
					+ inets.length);
			
			for(int i = 0; i < inets.length; i++)
				System.out.println(inets[i].toString());
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// Ű����� �����θ��� �Է¹޾�
		// �ش� ȣ��Ʈ ������ ��� ip �ּ� ��ȸ
		// ��ȸ�� ip �ּҿ� ȣ��Ʈ�� ��� ó��
		searchIP();
	}

}
