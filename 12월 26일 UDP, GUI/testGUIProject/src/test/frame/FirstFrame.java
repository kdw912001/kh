package test.frame;

import javax.swing.*;
import java.awt.*;

//������ â�� ������ ù��° ���
//����� Ŭ������ JFrame �� ��ӹ޴� ���
public class FirstFrame extends JFrame {
	
	public FirstFrame() {
		this.setTitle("ù��° gui ���ø����̼�");
		this.setLocation(100, 100);
		this.setSize(600, 350);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		//��� â�� ������Ʈ ������ ��ġ��
		//������, �� �������� ����ؾ� ��
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new FirstFrame();
	}

}
