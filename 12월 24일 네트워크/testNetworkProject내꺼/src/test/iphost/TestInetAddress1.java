package test.iphost;

import java.net.*;

public class TestInetAddress1 {

	public static void main(String[] args) {
		// java.net: InetAddress class test
		
		//host name : domain name
		try {
			InetAddress neverIp = InetAddress.getByName("www.naver.com");
			//방화벽 해제 나오면 해제 해야 함.
			System.out.println("네이버 웹서버의 ip주소 : "+neverIp);//도메인 명/ip주소를 toString() 오버라이딩
			System.out.println(neverIp.getHostAddress());//IP주소만 리턴가능
			InetAddress[] googles = InetAddress.getAllByName("www.google.com");
			//googles서버의 모든 IP주소를 조회(return이 InetAddress의 배열)
			System.out.println("google 웹서버 갯수 : " + googles.length);
			for(InetAddress inet : googles) {
				System.out.println(inet.getHostAddress());//IP주소만
			}
			
			InetAddress[] navers = InetAddress.getAllByName("www.naver.com");
			System.out.println("naver 웹 서버 갯수  : "+navers.length);
			for(InetAddress inet : navers) {
				System.out.println(inet.getHostAddress());
			}
			
			InetAddress myIp = InetAddress.getLocalHost();//내 컴퓨터의 IP주소 조회 메소드(static)
			System.out.println("내 컴퓨터 ip주소 : "+myIp.getHostAddress());
			 
		} catch (UnknownHostException e) {
			System.out.println("도메인 명이 틀렸습니다.");
			//기본 도메인 주소는 영문만 가능. 우리말 주소는 영문을 한글로 변환한 것임.
			System.out.println("확인하고 다시 실행하세요.");
		}
	}
}
