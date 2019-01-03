package gui.tcp.client;

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
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUITCPClient extends JFrame{
	//Field
	private Socket client;
	
	private JTextArea tarea;
	private JTextField textf;
	private JTextField ipTextf;
	private JButton connectBtn, sendBtn, exitBtn;
	
	private PrintWriter output;
	private BufferedReader input;
	
	public GUITCPClient(){
		super("TCP 통신 클라이언트");
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		int width = (int)screenSize.getWidth();
		int height = (int)screenSize.getHeight();
		this.setBounds(0, 0, width - 600, height - 50);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		Font textFont = new Font("돋움체", Font.PLAIN, 14);
		
		tarea = new JTextArea();
		tarea.setSize(580, height - 300);
		tarea.setFont(textFont);
		JScrollPane scrollPan = new JScrollPane(tarea);
		
		exitBtn = new JButton("클라이언트 종료");
		exitBtn.addActionListener(new ExitHandler());
		
		connectBtn = new JButton("서버와 연결");
		connectBtn.addActionListener(new ConnectHandler());
		
		ipTextf = new JTextField("192.168.30.28", 20);
		ipTextf.setFont(textFont);
		
		JPanel northPan = new JPanel();
		northPan.add(new JLabel("연결할 서버 IP : "));
		northPan.add(ipTextf);
		northPan.add(connectBtn);
		northPan.add(exitBtn);
		
		JLabel label = new JLabel("전송할 메세지 : ");
		textf = new JTextField(40);
		textf.setFont(textFont);
		sendBtn = new JButton("전송하기");
		sendBtn.addActionListener(new SendHandler());
		
		JPanel southPan = new JPanel();
		southPan.add(label);
		southPan.add(textf);
		southPan.add(sendBtn);
		
		this.add(scrollPan, BorderLayout.CENTER);
		this.add(northPan, BorderLayout.NORTH);
		this.add(southPan, BorderLayout.SOUTH);
		
		this.setVisible(true);
		
		tarea.append("서버와 연결 대기 상태입니다...");
	}
	
	//메세지 전송 처리용 이벤트핸들러 클래스임.
	private class SendHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			sendMessage();
			recieveMessage();
		}
		
	}
	
	//서버와 연결 처리할 이벤트핸들러임
	private class ConnectHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int port = 9000;
			String serverIP = ipTextf.getText().trim();
			
			try {
				client = new Socket(serverIP, port);
				tarea.append(serverIP + " : 서버와 연결되었습니다..\n");
				
				input = new BufferedReader(
						new InputStreamReader(
							client.getInputStream()));
				output = new PrintWriter(client.getOutputStream());
				
			} catch (UnknownHostException ex) {
				System.out.println("연결할 서버의 ip 또는 port 확인 필요함...");
				ex.printStackTrace();
			}catch(IOException ex){
				ex.printStackTrace();
			}
			
		}
		
	}
	
	//내부클래스로 액션이벤트핸들러 클래스 작성함
	private class ExitHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			int result = JOptionPane.showOptionDialog(getParent(), 
					"클라이언트를 종료하시겟습니까?", "종료확인", 
					JOptionPane.YES_OPTION, 
					JOptionPane.QUESTION_MESSAGE, null, 
					new String[]{"종료", "취소"}, "종료");
			if(result == 0){
				try {
					input.close();
					output.close();
					client.close();
				} catch (IOException e) {
					e.printStackTrace();
				}finally{
					System.exit(0);
				}
			}			
		}		
	}	
	
	//textf 에서 입력된 메세지를 서버로 전송하는 메소드
	public void sendMessage(){
		String message = textf.getText().trim();
		
		output.println(message);
		output.flush();
		tarea.append("전송 : " + message + "\n");
		
		if(message.equals("quit")){
			tarea.append("disConnected...... \n");
			
			try {
				input.close();
				output.close();
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//서버가 보낸 메세지 받아서 tarea에 출력
	public void recieveMessage(){
		try {
			tarea.append("수신 : " + 
					input.readLine() + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//gui tcp client test
		new GUITCPClient();
	}

}
