package test.frame;

import javax.swing.*;
import java.awt.*;

public class ThirdFrame {

	public static void main(String[] args) {
		// ����� ���� �ʰ� ���� JFrame ��ü ����
		JFrame mainFrame = 
				new JFrame("����° ������ ���ø����̼�");
		mainFrame.setBounds(
				new Rectangle(0, 0, 400, 300));
		mainFrame.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
		
		
		mainFrame.setVisible(true);
	}

}






