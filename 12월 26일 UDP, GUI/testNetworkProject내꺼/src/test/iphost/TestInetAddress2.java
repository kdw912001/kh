package test.iphost;

import java.net.*;

public class TestInetAddress2 {

	public static void main(String[] args) throws UnknownHostException {
		// ip주소로 호스트명 알아내기
		byte[] naverIP = { 125, (byte) 209, (byte) 222, (byte) 141 };
		// byte범위는 127까지이므로 형변환 해야 함.
		
		InetAddress naverInet = InetAddress.getByAddress(naverIP);
		System.out.println("알아본 호스트명 : "+naverInet.getHostName());
		//Host명을 안 갖고 만든 객체기 때문에 IP주소만 나옴
		
		System.out.println("host name : "+naverInet.getCanonicalHostName());
		System.out.println("toString() : "+naverInet.toString());
		//IP주소 자체가 호스트명으로 나옴(직접 byte배열로 처리했기 때문)
		
		
	}
}
