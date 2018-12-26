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
		
		this.setTitle("TCP ��� ����");
		//������ â ũ�⸦ ����� ȭ�� ũ��� ����
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		int width = (int)screenSize.getWidth();
		int height = (int)screenSize.getHeight();
		this.setBounds((width - 600), 0, 600, height - 50);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		Font textFont = new Font("����ü", Font.BOLD, 14);
		
		tarea = new JTextArea();
		tarea.setSize(580, height - 200);
		tarea.setFont(textFont);
		JScrollPane scrollPan = new JScrollPane(tarea);
		
		exitBtn = new JButton("���� ����");
		exitBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// ���� ���� ��ư ������ ���� ó�� ����
				int result = JOptionPane.showOptionDialog(
						getParent(), 
						"���� �����Ͻðڽ��ϱ�?", 
						"����Ȯ��", 
						JOptionPane.YES_OPTION,
						JOptionPane.QUESTION_MESSAGE, 
						null, 
						new String[]{"����", "���"}, 
						"����");
				if(result == 0)
					System.exit(0);
			}
			
		});
		
		JPanel southPan = new JPanel();
		southPan.add(exitBtn);
		
		this.add(scrollPan, BorderLayout.CENTER);
		this.add(southPan, BorderLayout.SOUTH);
		
		this.setVisible(true);
		
		tarea.append("���� ��� �����Դϴ�...\n");
		bindClient();
	}
	
	//���� ��� ���¿��� Ŭ���̾�Ʈ ���� ��û��
	//Ŭ���̾�Ʈ ���� �����ϴ� �޼ҵ�
	public void bindClient(){
		try {
			client = server.accept();
			String clientIP = client.getInetAddress().getHostAddress();
			tarea.append(clientIP + " : Ŭ���̾�Ʈ�� ����Ǿ����ϴ�...\n");
			
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
			System.out.println("Ŭ���̾�Ʈ ���� ����....");
			e.printStackTrace();
		}finally{
			tarea.append("Ŭ���̾�Ʈ�� ������ �����Ͽ����ϴ�..\n");
			try {
				input.close();
				output.close();
				client.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}
	
	//�޼��� �޾Ƽ� tarea�� ����ϴ� �޼ҵ�
	public boolean receiveMessage(){
		boolean quitFlag = false;
		
		try {
			String message = input.readLine();
			tarea.append(message + "\n");
			
			if(message.equals("quit"))
				quitFlag = true;
			
		} catch (IOException e) {
			System.out.println("�޼��� �б� ����...");
			e.printStackTrace();
		}
		
		return quitFlag;
	}
	
	//Ŭ���̾�Ʈ������ �޼��� ������ �޼ҵ�
	public void sendMessage(){
		output.println("������ �޼��� �޾���...");
		output.flush();
	}
	
	
	public static void main(String[] args) {
		// gui ���� tcp server
		ServerSocket server = null;
		
		try {
			server = new ServerSocket(9000);
		} catch (IOException e) {
			System.out.println("���� ������ �����Ͽ����ϴ�.");
			e.printStackTrace();
		}
		
		new GUITCPServer(server);
	}

}






