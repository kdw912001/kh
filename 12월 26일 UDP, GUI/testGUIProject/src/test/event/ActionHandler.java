package test.event;

import java.awt.event.*;
import javax.swing.*;

//�̺�Ʈ ����ó���� ����� �̺�Ʈ�ڵ鷯 Ŭ������
//�ݵ�� �ش� �̺�Ʈ�� ���� �������̽��� ���
//Ŭ������ ��ӹ޾ƾ� ��
public class ActionHandler 
	implements ActionListener {
	//Field
	private MainFrame parent;
	
	public ActionHandler(MainFrame parent) {
		this.parent = parent;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// MainFrame�� btn1�� Ŭ���Ǿ��� ���� ����ó��
		JOptionPane.showMessageDialog(
				parent, 
				e.getActionCommand() + " ��ư Ŭ���Ͽ���.", 
				"��ưŬ��", 
				JOptionPane.INFORMATION_MESSAGE);
		
	}

}
