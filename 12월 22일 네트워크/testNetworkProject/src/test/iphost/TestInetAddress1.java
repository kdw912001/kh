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
		System.out.println("네이버 웹서버의 ip주소 : "
				+ neverIP.getHostAddress());
		
		InetAddress[] googles = 
				InetAddress.getAllByName(
						"www.google.com");
		System.out.println("google 웹서버 갯수 : "
				+ googles.length);
		for(InetAddress inet : googles) {
			System.out.println(inet.getHostAddress());
		}
		
		InetAddress[] navers = 
				InetAddress.getAllByName(
						"www.naver.com");
		System.out.println("네이버 웹서버 갯수 : "
				+ navers.length);
		for(InetAddress ipes : navers) {
			System.out.println(ipes.getHostAddress());
		}
		
		InetAddress myIp = InetAddress.getLocalHost();
		System.out.println("내 컴퓨터 ip 주소 : "
				+ myIp.getHostAddress());
		
		}catch(UnknownHostException e) {
			System.out.println("도메인명이 틀렸습니다.");
			System.out.println("확인하고 다시 실행하세요.");
		}
	}
}






