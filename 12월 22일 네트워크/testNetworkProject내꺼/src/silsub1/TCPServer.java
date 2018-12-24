package silsub1;

import java.io.*;
import java.net.*;

public class TCPServer {

	public static void serverStart() {
		// 1.포트 번호 정하기
		int port = 7779;
		ServerSocket server = null;
		BufferedReader br = null;
		PrintWriter pw = null;

		try {
			// 2. 서버용 소켓 객체 만들기
			server = new ServerSocket(port);

			// 3. 클라이언트로부터 연결 요청 기다림

			while (true) {
				System.out.println("클라이언트 요청을 기다리고 있습니다.");
				// 4. 연결 요청한 클라이언트의 요청을 수락함
				// 해당 클라이언트의 정보를 저장한 소켓 객체
				Socket client = server.accept();
				System.out.println(client.getInetAddress().getHostName() + "가 연결 요청합니다.");

				// 5.해당 클라이언트의 입출력 스트림 생성함
				// 네트워크 입출력은 기본이 바이트스트림
				InputStream is = client.getInputStream();
				OutputStream os = client.getOutputStream();

				// 성능 또는 사용 개선을 위해 보조스트림을 추가로 연결
				// 바이트 스트림을 문자스트림으로 바꿀 수 있음
				br = new BufferedReader(new InputStreamReader(is));
				pw = new PrintWriter(os);
				// 6. 메세지를 주고 받음.
				// 클라이언트가 보낸 메세지 읽어서 출력
				String message = null;
				while (!(message = br.readLine()).equals("quit")) {
					System.out.println("받은 메세지 : " + message);
					// 서버가 답을 보냄
					pw.println("서버가 메세지 잘 받았음...");
					pw.flush();
				}

				// 7.스트림 반납
				pw.close();
				br.close();
				client.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				server.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}
	public static void main(String[] args) {
		serverStart();
	}
}
