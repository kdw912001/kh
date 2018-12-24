package tcp.server;

import java.net.*;
import java.io.*;

public class ChattServer {

	public static void main(String[] args) {
		// ������ ���α׷�
		chattServerStart();		
	}
	
	private static void chattServerStart() {
		int port = 9000;
		String serverIP = null;
		ServerSocket server = null;

		try {
			server = new ServerSocket(port);
			serverIP = server.getInetAddress().getHostAddress();

			while (true) { // ��� �����·� ����
				System.out.println("���� ��� ����...");
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
				// quit �������� �������� �����
				pw.print(serverIP + " : disconnected...");
				pw.flush();
				System.out.println(clientIP + " : quited....");
				br.close();
				pw.close();
				client.close();

			} catch (SocketException e) {
				// quit �������� �ʰ� ������������ ������ ���
				System.out.println(clientIP + " : ������������ �����Ͽ���...");
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
