package test.iphost;

import java.net.*;

public class TestInetAddress1 {

	public static void main(String[] args) {
		// java.net.InetAddress class test

		try {
		//host name : domain name
		InetAddress neverIP = 
				InetAddress.getByName(
						"www.naver.com");
		System.out.println("���̹� �������� ip�ּ� : "
				+ neverIP.getHostAddress());
		
		InetAddress[] googles = 
				InetAddress.getAllByName(
						"www.google.com");
		System.out.println("google ������ ���� : "
				+ googles.length);
		for(InetAddress inet : googles) {
			System.out.println(inet.getHostAddress());
		}
		
		InetAddress[] navers = 
				InetAddress.getAllByName(
						"www.naver.com");
		System.out.println("���̹� ������ ���� : "
				+ navers.length);
		for(InetAddress ipes : navers) {
			System.out.println(ipes.getHostAddress());
		}
		
		InetAddress myIp = InetAddress.getLocalHost();
		System.out.println("�� ��ǻ�� ip �ּ� : "
				+ myIp.getHostAddress());
		
		}catch(UnknownHostException e) {
			System.out.println("�����θ��� Ʋ�Ƚ��ϴ�.");
			System.out.println("Ȯ���ϰ� �ٽ� �����ϼ���.");
		}
	}
}






