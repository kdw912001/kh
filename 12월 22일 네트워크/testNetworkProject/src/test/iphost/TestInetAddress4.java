package test.iphost;

import java.net.*;
import java.util.*;

public class TestInetAddress4 {

	public static void searchIP() {
		//Ű����� ȣ��Ʈ���� �Է¹޾�
		//�ش� ȣ��Ʈ�� ���� ip �ּ� 
		//��� ��� ó�� �ݺ�������
		//"none" �Է½� ����ǰ� ��
		do{
			System.out.print("ȣ��Ʈ�� (����: none) : ");
			String host = new Scanner(System.in).next();
			
			if(host.equals("none") != true){
				InetAddress[] ips = null;
				try {
					ips = InetAddress.getAllByName(host);
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(host + "�� ���� ip�� " + 
						ips.length + "�� �Դϴ�.");
				for(InetAddress ip : ips)
					System.out.println(ip.getHostAddress());
				
			}else		break;
		}while(true);
	}
	
	public static void main(String[] args) {
		searchIP();
	}

}
