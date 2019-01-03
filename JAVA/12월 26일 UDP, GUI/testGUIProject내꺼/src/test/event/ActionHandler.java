package test.event;

import java.awt.event.*;
import javax.swing.*;

//이벤트 동작처리를 담당할 이벤트핸들러 클래스는
//반드시 해당 이벤트에 대한 인터페이스나 어댑터 클래스를 상속받아야 함.

public class ActionHandler implements ActionListener{
	//Field
	private MainFrame parent;
	
	public ActionHandler(MainFrame parent) {
		this.parent=parent;//MainFrame에 있는 new ActionHandler(this)
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// MainFrame의 btn1이 클릭되었을 때의 동작처리
		JOptionPane.showMessageDialog(parent, e.getActionCommand()+" 버튼 클릭하였음.", "버튼클릭", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
}
