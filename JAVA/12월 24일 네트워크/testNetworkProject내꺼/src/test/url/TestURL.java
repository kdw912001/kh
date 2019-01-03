package test.url;

import java.net.*;

public class TestURL {

	public static void main(String[] args) {
		// java.net.URL class test
		// URL 객체는 url 정보를 가지고 있음
		String urlStr = "https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html";
		
		try {
			URL url = new URL(urlStr);
			System.out.println("프로토콜 : "+url.getProtocol());//https
			System.out.println("호스트명 : "+url.getHost());
			System.out.println("경로정보 : "+url.getPath());//호스트명 뒷 부분
			System.out.println("연결된 파일 : "+url.getFile());//경로정보가 포함 됨
			System.out.println("포트번호 : "+url.getPort());
			//보통 사이트에서 포트번호 조회 못하게 막아놨기 때문에 -1(접속실패)이 출력됨
			System.out.println("쿼리스트링 : "+url.getQuery());//없으니 null
			System.out.println("참조이름 : "+url.getRef());//url에 #기호가 있는 것, 없으면 null
			
			String host = url.getHost();
			InetAddress[] ipes = InetAddress.getAllByName(host);
			for(InetAddress inet : ipes)
				System.out.println(inet.toString());
			
			
		} catch (MalformedURLException | UnknownHostException e) {//URL에 오타가 있을 때 나는 예외
			//같은 상속레벨(형제지간) 이면 비트OR연산자(|)를 이용
			System.out.println("잘못된 url입니다.");
		}
	}
}
