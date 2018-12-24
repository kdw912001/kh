package test.tcp;

import java.net.*;
import java.io.*;

public class TCPClient {
	
	public static void clientStart() {
		//1. ������ ���� ��Ʈ��ȣ��
		//������ ip�ּҰ� �ʿ���
		int port = 7777;
		
		BufferedReader br = null;
		PrintWriter pw = null;
		Socket socket = null;
		
		try {
			String serverIP = InetAddress.getLocalHost().getHostAddress();
			//String serverIP = "192.168.30.28";
			
			//2. Ŭ���̾�Ʈ �ڽ��� ���� ��ü ������
			socket = new Socket(serverIP, port);
			//��ü ������ ���ÿ� ������ �����.
			//������ ���� ���н� null ���ϵ�.
			
			if(socket != null) {
				//������ ������ �Ǿ��ٸ�
				
				//3. ������ Ŭ���̾�Ʈ ���� ��Ʈ�� ������
				br = new BufferedReader(
						new InputStreamReader(
							socket.getInputStream()));
				pw = new PrintWriter(
						socket.getOutputStream());
			
				//4. �޼��� �ְ� �ޱ�
				//������ ���� ������
				pw.println("�ȳ��ϼ���....");
				pw.flush();
				
				//�� �ޱ�
				String recieveMsg = br.readLine();
				System.out.println("������ ���� �� : "
						+ recieveMsg);
				
			}
			
		}catch(IOException e) {
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

	public static void main(String[] args) {
		// TCP Client �� ���α׷�
		clientStart();
	}

}


