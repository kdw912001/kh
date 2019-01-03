package test.iphost;

import java.net.*;
import java.util.*;

public class TestInetAddress3 {

	public static void searchIP() {
		Scanner sc = new Scanner(System.in);
		System.out.print("조회할 호스트명 : ");
		String domain = sc.next();
		try {
			InetAddress[] inet = InetAddress.getAllByName(domain);
			System.out.println("조회한 호스트의 서버 갯수 : "+inet.length);
			for(InetAddress inet1 : inet) {
				System.out.println(inet1);//toString()오버라이딩
			}
		} catch (UnknownHostException e) {
			System.out.println("도메인 명이 틀렸습니다.");
		}
	}
	
	public static void main(String[] args) {
		// 키보드로 도메인명을 입력받아
		// 해당 호스트 서버의 모든 IP주소 조회
		// 조회된 ip주소와 호스트명 출력 처리
		
		searchIP();
	}

}
