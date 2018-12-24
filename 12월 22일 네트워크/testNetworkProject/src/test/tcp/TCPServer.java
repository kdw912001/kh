package test.tcp;

import java.net.*;
import java.io.*;

public class TCPServer {
	public static void serverStart() {
		//1. port ��ȣ ���ϱ�
		int port = 7777;
		ServerSocket server = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			//2. ������ ���� ��ü �����
			server = new ServerSocket(port);
		
			//3. Ŭ���̾�Ʈ�� ���� ���� ��û�� ��ٸ�.
			while(true) {
				System.out.println("Ŭ���̾�Ʈ ��û�� ��ٸ��� �ֽ��ϴ�....");
				
				//4. ���� ��û�� Ŭ���̾�Ʈ�� ��û�� ������
				//�ش� Ŭ���̾�Ʈ�� ������ ������ ���� ��ü ������
				Socket client = server.accept();
				
				System.out.println(client.getInetAddress().getHostAddress()
						+ "�� ���� ��û��...");
				
				//5. �ش� Ŭ���̾�Ʈ�� ����� ��Ʈ�� ������
				InputStream is = client.getInputStream();
				OutputStream os = client.getOutputStream();
				
				//���� �Ǵ� ��� ������ ����
				//������Ʈ���� �߰��� ������ ���� ����
				//����Ʈ��Ʈ���� ���ڽ�Ʈ������ �ٲ� ���� ����
				br = new BufferedReader(
						new InputStreamReader(is));
				pw = new PrintWriter(os);
				
				//6. �޼����� �ְ� ����
				//Ŭ���̾�Ʈ�� ���� �޼��� �о ���
				String message = br.readLine();
				System.out.println("���� �޼��� : "
						+ message);
				//������ ���� ����
				pw.println("������ �޼��� �� �޾���...");
				pw.flush();
				
				//7. ��Ʈ�� �ݳ���
				pw.close();
				br.close();
				client.close();
			}  //while
			
		}catch(IOException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {				
				server.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// TCP Server �� ���α׷�
		serverStart();

	}

}
