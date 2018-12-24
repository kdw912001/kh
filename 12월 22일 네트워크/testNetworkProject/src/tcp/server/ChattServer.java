package tcp.server;

import java.net.*;
import java.io.*;

public class ChattServer {

	public static void main(String[] args) {
		// 서버용 프로그램
		chattServerStart();		
	}
	
	private static void chattServerStart() {
		int port = 9000;
		String serverIP = null;
		ServerSocket server = null;

		try {
			server = new ServerSocket(port);
			serverIP = server.getInetAddress().getHostAddress();

			while (true) { // 계속 대기상태로 만듦
				System.out.println("접속 대기 상태...");
				clientAccess(server);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void clientAccess(ServerSocket server) {
		String serverIP = server.getInetAddress().getHostAddress();
		try {
			Socket client = server.accept();
			String clientIP = client.getInetAddress().getHostAddress();
			System.out.println(clientIP + " : connected...");

			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter pw = new PrintWriter(client.getOutputStream());

			try {
				String recieveMessage;
				while (!(recieveMessage = br.readLine()).equals("quit")) {
					System.out.println(clientIP + " : " + recieveMessage);
					pw.println(serverIP + " : recieve success...");
					pw.flush();
				}
				// quit 전송으로 정상적인 종료시
				pw.print(serverIP + " : disconnected...");
				pw.flush();
				System.out.println(clientIP + " : quited....");
				br.close();
				pw.close();
				client.close();

			} catch (SocketException e) {
				// quit 전송하지 않고 비정상적으로 종료한 경우
				System.out.println(clientIP + " : 비정상적으로 종료하였음...");
				pw.print(serverIP + " : disconnected...");
				br.close();
				pw.close();
				client.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
