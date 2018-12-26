package test.iphost;

import java.util.*;
import java.net.*;

public class TestInetAddress4 {

	public static void searchIP() {
		// 키보드로 호스트 명을 입력받아
		// 해당 호스트가 가진 ip주소 모두 출력
		// 모두 출력 처리 반복실행함 "none"입력시 종료되게 함
		Scanner sc = new Scanner(System.in);
		String domain = null;
		System.out.print("조회할 호스트명 입력 : ");
		while (!(domain = sc.next()).equals("none")) {
			try {
				InetAddress[] inet = InetAddress.getAllByName(domain);
				System.out.println(domain+"의 웹 서버 갯수 : "+inet.length);
				for(InetAddress i : inet) {
					System.out.println(i.getHostAddress());
				}
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			System.out.print("조회할 호스트명 입력 : ");
		}
	}

	public static void main(String[] args) {
		searchIP();

	}

}
