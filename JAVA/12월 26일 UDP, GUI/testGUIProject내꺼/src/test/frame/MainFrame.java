package test.frame;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{//많이 사용하는 방식 
	public MainFrame() {
		super("두번째 프레임 애플리케이션");
		this.setBounds(0,0,400,300);//위치와 크기를 한번에 지정
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//닫히게 해라 DIPOSE는 메모리에서도 아예 종료
		
		this.setVisible(true);
	}
	
}
