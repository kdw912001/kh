package notepad.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import notepad.frame.MyNotePadMenu;

public class EditMenuEventHandler implements ActionListener {
	// Field
	private JFrame mainFrame;
	MyNotePadMenu myMenu;

	public EditMenuEventHandler(MyNotePadMenu menu, JFrame mainFrame){
			this.mainFrame = mainFrame;
			this.myMenu = menu;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// ���� �޴������� ���ý� 

	}

}
