package test.iphost;

import java.net.*;
import java.util.*;

public class TestInetAddress3 {

	public static void searchIP() {
		Scanner sc = new Scanner(System.in);
		String hostName = "";
		
		try {
			System.out.print("조회할 호스트명 : ");
			hostName = sc.next();
			
			InetAddress[] inets = 
				InetAddress.getAllByName(hostName);
			
			System.out.println("조회한 호스트의 서버 갯수 : "
					+ inets.length);
			
			for(int i = 0; i < inets.length; i++)
				System.out.println(inets[i].toString());
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// 키보드로 도메인명을 입력받아
		// 해당 호스트 서버의 모든 ip 주소 조회
		// 조회된 ip 주소와 호스트명 출력 처리
		searchIP();
	}

}
