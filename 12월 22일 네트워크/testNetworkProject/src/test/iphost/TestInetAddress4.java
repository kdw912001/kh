package test.iphost;

import java.net.*;
import java.util.*;

public class TestInetAddress4 {

	public static void searchIP() {
		//키보드로 호스트명을 입력받아
		//해당 호스트가 가진 ip 주소 
		//모두 출력 처리 반복실행함
		//"none" 입력시 종료되게 함
		do{
			System.out.print("호스트명 (종료: none) : ");
			String host = new Scanner(System.in).next();
			
			if(host.equals("none") != true){
				InetAddress[] ips = null;
				try {
					ips = InetAddress.getAllByName(host);
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(host + "가 가진 ip는 " + 
						ips.length + "개 입니다.");
				for(InetAddress ip : ips)
					System.out.println(ip.getHostAddress());
				
			}else		break;
		}while(true);
	}
	
	public static void main(String[] args) {
		searchIP();
	}

}
