package test.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class MainFrame 
	extends JFrame 
	implements ActionListener {
	//Field
	private JButton btn1, btn2, btn3, btn4, btn5;
	
	//Constructor
	public MainFrame() {
		super("�̺�Ʈ ó�� �׽�Ʈ");
		this.setBounds(100, 100, 800, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		btn1 = new JButton("������ �̺�Ʈ�ڵ鷯 ����");
		//������Ʈ�� �̺�Ʈ ������
		//������Ʈ���۷���.add�̺�ƮListener(�̺�Ʈ�ڵ鷯);
		//�ش� �̺�Ʈ ������ �߻����� ��
		//����ó���� ����� Ŭ������ �̺�Ʈ�ڵ鷯�ϰ� ��
		btn1.addActionListener(new ActionHandler(this));
		
		btn2 = new JButton("����Ŭ������ �̺�Ʈó��");
		btn2.addActionListener(new InActionHandler());
		
		btn3 = new JButton("�������� �̺�Ʈ�ڵ鷯�� ��.");
		btn3.addActionListener(this);
		
		btn4 = new JButton("�͸�Ŭ������ �̺�Ʈó��");
		btn4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// btn4 Ŭ������ ���� ����ó��
				JOptionPane.showMessageDialog(getParent(), 
						e.getActionCommand() + " ��ư ������.");
				
			}
			
		});
		
		btn5 = new JButton("java.beans.EventHandle Ŭ���� ���");
		btn5.addActionListener(
				(ActionListener)java.beans.EventHandler.create(ActionListener.class, this, "showDlg"));
		
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);
		this.add(btn5);
		
		this.setVisible(true);
	}
	
	//����(Inner | Nested) Ŭ������ 
	//�̺�Ʈ�ڵ鷯 Ŭ���� �ۼ�
	//����Ŭ������ Ŭ������ ����� ��
	//4���� ���������ڿ� static �� ��밡��
	private class InActionHandler 
		implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// btn2�� Ŭ������ ���� ����ó��
			JOptionPane.showMessageDialog(getParent(), 
					e.getActionCommand() + " ��ư Ŭ����.");
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// btn3�� Ŭ������ ���� ����ó��
		JOptionPane.showMessageDialog(this, 
				e.getActionCommand() + " ��ư Ŭ����.");
	}
	
	//EventHandler �� ���� ����� �޼ҵ�
	public void showDlg() {
		JOptionPane.showMessageDialog(
			this, 
			btn5.getText() + " ��ư Ŭ���Ͽ���.");
	}
}







