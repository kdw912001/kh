package notepad.frame;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class NotePadFrame extends JFrame{
	//Field
	private JMenuBar menuBar;
	private JTextArea textPane;
	
	public NotePadFrame(){
		super("내 메모장");
		this.setBounds(new Rectangle(50, 50, 800, 500));
		
		//메뉴바를 프레임 상단에 추가함
		this.setJMenuBar(new MyNotePadMenu(this).getMenuBar());
		
		//글자 입력영역 추가
		textPane = new JTextArea();	
		textPane.addKeyListener(new KeyHandler());
		JScrollPane scrollPane = new JScrollPane(textPane);
		this.add(scrollPane, BorderLayout.CENTER);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	public JTextArea getTextPane() {
		return textPane;
	}

	public void setTextPane(JTextArea textPane) {
		this.textPane = textPane;
	}	
	
	//클래스 안에서 작성하는 클래스 : 내부(Inner) 클래스라고 함
	//내부 클래스는 외부(Outer) 클래스의 멤버 개념이 됨
	//그러므로, 필드나 메소드 처럼 접근제한자 모두 사용가능함
	//내부 클래스는 멤버의 개념이 적용되서 static 사용 가능함
	
	//컴파일되면 외부클래스명$내부클래스명.class 
	private class KeyHandler extends KeyAdapter /*implements KeyListener*/{
		public KeyHandler(){}
		
		/*@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			//textPane.setText("keyPressed..." + e.getKeyChar() + "\n");
			textPane.setText(textPane.getText() + e.getKeyChar());
		}*/

		
		/*@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			//textPane.setText("keyReleased..." + e.getKeyChar() + "\n");
			textPane.setText(textPane.getText() + e.getKeyChar());
		}*/

		@Override
		public void keyTyped(KeyEvent e) {
			// 키보드의 키누를때 반응하는 메소드임
			String value = textPane.getText();
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				value += e.getKeyChar();
				textPane.setText(value);
			}
		}
	}
}











