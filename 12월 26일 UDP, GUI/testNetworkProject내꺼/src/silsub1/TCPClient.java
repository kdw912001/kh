package silsub1;

import java.io.*;
import java.net.*;
import java.util.*;

public class TCPClient {
	public static void main(String[] args) {
		clientStart();
	}
	
	public static void clientStart() {
		//1.서버가 정한 포트번호와 서버의ip주소가 필요함
		int port = 7779; //서버 측과 동일
		BufferedReader br = null;
		PrintWriter pw = null;
		Socket socket = null;
		Scanner sc =  new Scanner(System.in);
		try {
			String serverIP = InetAddress.getLocalHost().getHostAddress();
			//String serverIP 입력
			
			//2. 클라이언트 자신의 소켓 객체 생성
			socket = new Socket(serverIP, port);
			
			//객체 생성과 동시에 서버 연결됨
			//서버 연결 실패 시 null 리턴됨.
			if(socket!=null) {//서버와 연결이 되었따면
				//3.서버와 클라이언트 간의 스트림 생성
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				pw = new PrintWriter(socket.getOutputStream());
				//4. 메세지 주고 받기
				String line = null;
				while(true) {
					System.out.print("메세지 입력 : ");
					line=sc.nextLine();
					pw.println(line);
					pw.flush();

					if(line.equals("quit")) break;
					
					//답 받기
					String recieveMsg = br.readLine();
					System.out.println("서버가 보낸 답 : "+recieveMsg);
				}
				
			}			
			
		} catch (IOException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pw.close();
				br.close();
				socket.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	
}
