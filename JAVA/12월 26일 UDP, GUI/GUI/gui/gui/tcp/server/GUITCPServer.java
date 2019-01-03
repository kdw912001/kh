package gui.tcp.server;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GUITCPServer extends JFrame{
	//Field
	private ServerSocket server;
	private Socket client;
	private JTextArea tarea;
	private JButton exitBtn;
	
	private PrintWriter output;
	private BufferedReader input;
	
	public GUITCPServer(ServerSocket server){
		this.server = server;
		
		this.setTitle("TCP 통신 서버");
		//프레임 창 크기를 모니터 화면 크기로 맞춤
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		int width = (int)screenSize.getWidth();
		int height = (int)screenSize.getHeight();
		this.setBounds((width - 600), 0, 600, height - 50);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		Font textFont = new Font("돋움체", Font.BOLD, 14);
		
		tarea = new JTextArea();
		tarea.setSize(580, height - 200);
		tarea.setFont(textFont);
		JScrollPane scrollPan = new JScrollPane(tarea);
		
		exitBtn = new JButton("서버 종료");
		exitBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// 서버 종료 버튼 눌렀을 때의 처리 내용
				int result = JOptionPane.showOptionDialog(
						getParent(), 
						"서버 종료하시겠습니까?", 
						"종료확인", 
						JOptionPane.YES_OPTION,
						JOptionPane.QUESTION_MESSAGE, 
						null, 
						new String[]{"종료", "취소"}, 
						"종료");
				if(result == 0)
					System.exit(0);
			}
			
		});
		
		JPanel southPan = new JPanel();
		southPan.add(exitBtn);
		
		this.add(scrollPan, BorderLayout.CENTER);
		this.add(southPan, BorderLayout.SOUTH);
		
		this.setVisible(true);
		
		tarea.append("접속 대기 상태입니다...\n");
		bindClient();
	}
	
	//서버 대기 상태에서 클라이언트 접속 요청시
	//클라이언트 소켓 생성하는 메소드
	public void bindClient(){
		try {
			client = server.accept();
			String clientIP = client.getInetAddress().getHostAddress();
			tarea.append(clientIP + " : 클라이언트와 연결되었습니다...\n");
			
			output = new PrintWriter(client.getOutputStream());
			input = new BufferedReader(
					new InputStreamReader(
							client.getInputStream()));
			
			while(true){
				boolean returnValue = receiveMessage();
				if(returnValue == true)
					break;
				sendMessage();
			}
			
		} catch (IOException e) {
			System.out.println("클라이언트 연결 실패....");
			e.printStackTrace();
		}finally{
			tarea.append("클라이언트가 연결을 종료하였습니다..\n");
			try {
				input.close();
				output.close();
				client.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}
	
	//메세지 받아서 tarea에 기록하는 메소드
	public boolean receiveMessage(){
		boolean quitFlag = false;
		
		try {
			String message = input.readLine();
			tarea.append(message + "\n");
			
			if(message.equals("quit"))
				quitFlag = true;
			
		} catch (IOException e) {
			System.out.println("메세지 읽기 실패...");
			e.printStackTrace();
		}
		
		return quitFlag;
	}
	
	//클라이언트쪽으로 메세지 보내는 메소드
	public void sendMessage(){
		output.println("서버가 메세지 받았음...");
		output.flush();
	}
	
	
	public static void main(String[] args) {
		// gui 적용 tcp server
		ServerSocket server = null;
		
		try {
			server = new ServerSocket(9000);
		} catch (IOException e) {
			System.out.println("서버 구동이 실패하였습니다.");
			e.printStackTrace();
		}
		
		new GUITCPServer(server);
	}

}






