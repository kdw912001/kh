package test.iphost;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress2 {

	public static void main(String[] args) 
			throws UnknownHostException {
		// ip �ּҷ� ȣ��Ʈ�� �˾Ƴ���
		byte[] naverIP = {125, (byte)209, (byte)222, (byte)141};
		InetAddress naverInet = 
			InetAddress.getByAddress(naverIP);
		System.out.println("�˾Ƴ� ȣ��Ʈ�� : "
				+ naverInet.getHostName());
		System.out.println("host name : "
				+ naverInet.getCanonicalHostName());
		System.out.println("toString() : " + 
				naverInet.toString());

	}

}
