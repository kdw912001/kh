package net.silsub2;
import java.util.*;
import java.net.*;
public class Test1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			InetAddress[] inet = InetAddress.getAllByName(sc.next());
			for(InetAddress i : inet) {
				System.out.println(i.getHostAddress());
			}
		} catch (UnknownHostException e) {
			System.out.println("도메인 명을 잘못 입력하셨습니다.");
		}
		

	}

}
