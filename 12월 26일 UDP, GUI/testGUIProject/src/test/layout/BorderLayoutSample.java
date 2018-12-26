package test.layout;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutSample extends JFrame {
	//Field
	private JButton eastBtn, westBtn, 
		southBtn, northBtn, centerBtn;	
	
	public BorderLayoutSample() {
		super("BorderLayout Test");
		this.setBounds(
				new Rectangle(0, 0, 400, 400));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		//������Ʈ�� ���� ��ġ��� ����
		//�������� �⺻ ���̾ƿ���
		//BorderLayout ��.
		//this.setLayout(new BorderLayout());
		//�������̾ƿ��� �� ��������
		//������Ʈ �Ѱ����� ��ġ�� �� ����.
		//������Ʈ�� ũ�⵵ ������ �� ����
		//������ ũ�⿡ ������.		
		
		//������Ʈ ��ü ����
		eastBtn = new JButton("���ʹ�ư");
		westBtn = new JButton("���ʹ�ư");
		southBtn = new JButton("���ʹ�ư");
		northBtn = new JButton("���ʹ�ư");
		centerBtn = new JButton("�����ư");
		
		//������ ��ġ��Ŀ� ����
		//�� ������ ������Ʈ ��ġ��.
		this.add(eastBtn, BorderLayout.EAST);
		this.add(westBtn, BorderLayout.WEST);
		this.add(southBtn, BorderLayout.SOUTH);
		this.add(northBtn, BorderLayout.NORTH);
		this.add(centerBtn, BorderLayout.CENTER);		
		
		this.setVisible(true);
	}

}
