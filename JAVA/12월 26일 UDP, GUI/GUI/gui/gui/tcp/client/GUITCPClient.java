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
		super("TCP ��� Ŭ���̾�Ʈ");
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		int width = (int)screenSize.getWidth();
		int height = (int)screenSize.getHeight();
		this.setBounds(0, 0, width - 600, height - 50);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		Font textFont = new Font("����ü", Font.PLAIN, 14);
		
		tarea = new JTextArea();
		tarea.setSize(580, height - 300);
		tarea.setFont(textFont);
		JScrollPane scrollPan = new JScrollPane(tarea);
		
		exitBtn = new JButton("Ŭ���̾�Ʈ ����");
		exitBtn.addActionListener(new ExitHandler());
		
		connectBtn = new JButton("������ ����");
		connectBtn.addActionListener(new ConnectHandler());
		
		ipTextf = new JTextField("192.168.30.28", 20);
		ipTextf.setFont(textFont);
		
		JPanel northPan = new JPanel();
		northPan.add(new JLabel("������ ���� IP : "));
		northPan.add(ipTextf);
		northPan.add(connectBtn);
		northPan.add(exitBtn);
		
		JLabel label = new JLabel("������ �޼��� : ");
		textf = new JTextField(40);
		textf.setFont(textFont);
		sendBtn = new JButton("�����ϱ�");
		sendBtn.addActionListener(new SendHandler());
		
		JPanel southPan = new JPanel();
		southPan.add(label);
		southPan.add(textf);
		southPan.add(sendBtn);
		
		this.add(scrollPan, BorderLayout.CENTER);
		this.add(northPan, BorderLayout.NORTH);
		this.add(southPan, BorderLayout.SOUTH);
		
		this.setVisible(true);
		
		tarea.append("������ ���� ��� �����Դϴ�...");
	}
	
	//�޼��� ���� ó���� �̺�Ʈ�ڵ鷯 Ŭ������.
	private class SendHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			sendMessage();
			recieveMessage();
		}
		
	}
	
	//������ ���� ó���� �̺�Ʈ�ڵ鷯��
	private class ConnectHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int port = 9000;
			String serverIP = ipTextf.getText().trim();
			
			try {
				client = new Socket(serverIP, port);
				tarea.append(serverIP + " : ������ ����Ǿ����ϴ�..\n");
				
				input = new BufferedReader(
						new InputStreamReader(
							client.getInputStream()));
				output = new PrintWriter(client.getOutputStream());
				
			} catch (UnknownHostException ex) {
				System.out.println("������ ������ ip �Ǵ� port Ȯ�� �ʿ���...");
				ex.printStackTrace();
			}catch(IOException ex){
				ex.printStackTrace();
			}
			
		}
		
	}
	
	//����Ŭ������ �׼��̺�Ʈ�ڵ鷯 Ŭ���� �ۼ���
	private class ExitHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			int result = JOptionPane.showOptionDialog(getParent(), 
					"Ŭ���̾�Ʈ�� �����Ͻðٽ��ϱ�?", "����Ȯ��", 
					JOptionPane.YES_OPTION, 
					JOptionPane.QUESTION_MESSAGE, null, 
					new String[]{"����", "���"}, "����");
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
	
	//textf ���� �Էµ� �޼����� ������ �����ϴ� �޼ҵ�
	public void sendMessage(){
		String message = textf.getText().trim();
		
		output.println(message);
		output.flush();
		tarea.append("���� : " + message + "\n");
		
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
	
	//������ ���� �޼��� �޾Ƽ� tarea�� ���
	public void recieveMessage(){
		try {
			tarea.append("���� : " + 
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
