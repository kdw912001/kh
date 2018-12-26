package test.layout;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutSample extends JFrame {
	//Field
	private JButton okBtn, cancleBtn, backBtn;
	
	public FlowLayoutSample() {
		super("FlowLayout Test");
		this.setBounds(100, 100, 400, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setLayout(new FlowLayout());
		//������Ʈ���� ��� �����ϸ鼭 �߰���
		//������Ʈ�� �⺻ ũ�⸦ ������
		//�⺻ ���Ĺ����� ���ʿ��� ���������� �߰���.
		//������ �ʰ��ϸ� �ڵ� �ι�° �ٿ� ��ġ��.
		
		okBtn = new JButton("Ȯ��");
		cancleBtn = new JButton("���");
		backBtn = new JButton("�ڷ�");
		
		this.add(okBtn);
		this.add(cancleBtn);
		this.add(backBtn);		
		
		this.setVisible(true);
	}
}






