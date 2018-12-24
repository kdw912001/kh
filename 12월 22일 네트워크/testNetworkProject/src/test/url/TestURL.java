package test.url;

import java.net.*;

public class TestURL {

	public static void main(String[] args) {
		// java.net.URL class test
		// URL ��ü�� url ������ ������ ����
		String urlStr = "https://www.oracle.com/technetwork/java/javase/downloads/index.html";

		try {
			URL url = new URL(urlStr);
			System.out.println("�������� : " + url.getProtocol());
			System.out.println("ȣ��Ʈ�� : " + url.getHost());
			System.out.println("������� : " + url.getPath());
			System.out.println("����� ���� : " + url.getFile());
			System.out.println("��Ʈ��ȣ : " + url.getPort());
			System.out.println("������Ʈ�� : " + url.getQuery());
			System.out.println("�����̸� : " + url.getRef());
			
			String host = url.getHost();
			InetAddress[] ipes = 
					InetAddress.getAllByName(host);
			for(InetAddress inet : ipes)
				System.out.println(inet.toString());
			
		} catch (MalformedURLException | UnknownHostException e) {
			System.out.println("�߸��� url �Դϴ�.");
		}
	}

}







