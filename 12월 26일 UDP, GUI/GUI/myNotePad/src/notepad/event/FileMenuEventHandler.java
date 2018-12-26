package notepad.event;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import notepad.frame.MyNotePadMenu;

public class FileMenuEventHandler implements ActionListener{
	//Field
	private JFrame mainFrame;
	MyNotePadMenu myMenu;
	
	public FileMenuEventHandler(MyNotePadMenu menu, JFrame mainFrame){
		this.mainFrame = mainFrame;
		this.myMenu = menu;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		//���� �޴����� �޴� �������� �������� ���� ������ ó���� �޼ҵ�
		JMenuItem fileMenuItem = (JMenuItem)event.getSource();
		
		if(fileMenuItem.getText().equals(myMenu.getFileNew().getText()))
			//JOptionPane.showMessageDialog(mainFrame, "fileNew ����");
			fileNewAction();
		
		if(fileMenuItem.getText().equals(myMenu.getFileExit().getText()))  
			fileExitAction();
		
		if(fileMenuItem.getText().equals(myMenu.getFileOpen().getText()))
			fileOpenAction();
		
	}
	
	public void fileOpenAction() {
		// ���� �޴��������� ���õǾ��ٸ�
		
	}

	public void fileNewAction() {
		// ���� ����� �޴��������� ���õǾ��ٸ�
		
	}

	public void fileExitAction() {
		// ������ �޴��������� ���õǾ��ٸ�
		int result = JOptionPane.showConfirmDialog(mainFrame, "�޸��� ���α׷��� �����Ͻðڽ��ϱ�?");
		// ��ȭ���ڿ��� ������ ��ư ���� ���� ����

		if (result == JOptionPane.OK_OPTION) { // ok ��ư Ŭ����
			System.exit(0); // ���α׷� ������
			mainFrame.dispose(); // ������ â ����
		}

	}

}






