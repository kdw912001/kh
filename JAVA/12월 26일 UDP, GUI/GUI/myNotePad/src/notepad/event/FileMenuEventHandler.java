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
		//파일 메뉴에서 메뉴 아이템을 선택했을 때의 내용을 처리할 메소드
		JMenuItem fileMenuItem = (JMenuItem)event.getSource();
		
		if(fileMenuItem.getText().equals(myMenu.getFileNew().getText()))
			//JOptionPane.showMessageDialog(mainFrame, "fileNew 선택");
			fileNewAction();
		
		if(fileMenuItem.getText().equals(myMenu.getFileExit().getText()))  
			fileExitAction();
		
		if(fileMenuItem.getText().equals(myMenu.getFileOpen().getText()))
			fileOpenAction();
		
	}
	
	public void fileOpenAction() {
		// 열기 메뉴아이템이 선택되었다면
		
	}

	public void fileNewAction() {
		// 새로 만들기 메뉴아이템이 선택되었다면
		
	}

	public void fileExitAction() {
		// 끝내기 메뉴아이템이 선택되었다면
		int result = JOptionPane.showConfirmDialog(mainFrame, "메모장 프로그램을 종료하시겠습니까?");
		// 대화상자에서 선택한 버튼 값을 리턴 받음

		if (result == JOptionPane.OK_OPTION) { // ok 버튼 클릭시
			System.exit(0); // 프로그램 종료함
			mainFrame.dispose(); // 프레임 창 닫음
		}

	}

}






