package notepad.frame;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class NotePadFrame extends JFrame{
	//Field
	private JMenuBar menuBar;
	private JTextArea textPane;
	
	public NotePadFrame(){
		super("�� �޸���");
		this.setBounds(new Rectangle(50, 50, 800, 500));
		
		//�޴��ٸ� ������ ��ܿ� �߰���
		this.setJMenuBar(new MyNotePadMenu(this).getMenuBar());
		
		//���� �Է¿��� �߰�
		textPane = new JTextArea();	
		textPane.addKeyListener(new KeyHandler());
		JScrollPane scrollPane = new JScrollPane(textPane);
		this.add(scrollPane, BorderLayout.CENTER);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	public JTextArea getTextPane() {
		return textPane;
	}

	public void setTextPane(JTextArea textPane) {
		this.textPane = textPane;
	}	
	
	//Ŭ���� �ȿ��� �ۼ��ϴ� Ŭ���� : ����(Inner) Ŭ������� ��
	//���� Ŭ������ �ܺ�(Outer) Ŭ������ ��� ������ ��
	//�׷��Ƿ�, �ʵ峪 �޼ҵ� ó�� ���������� ��� ��밡����
	//���� Ŭ������ ����� ������ ����Ǽ� static ��� ������
	
	//�����ϵǸ� �ܺ�Ŭ������$����Ŭ������.class 
	private class KeyHandler extends KeyAdapter /*implements KeyListener*/{
		public KeyHandler(){}
		
		/*@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			//textPane.setText("keyPressed..." + e.getKeyChar() + "\n");
			textPane.setText(textPane.getText() + e.getKeyChar());
		}*/

		
		/*@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			//textPane.setText("keyReleased..." + e.getKeyChar() + "\n");
			textPane.setText(textPane.getText() + e.getKeyChar());
		}*/

		@Override
		public void keyTyped(KeyEvent e) {
			// Ű������ Ű������ �����ϴ� �޼ҵ���
			String value = textPane.getText();
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				value += e.getKeyChar();
				textPane.setText(value);
			}
		}
	}
}











