package test.frame;

import javax.swing.*;
import java.awt.*;

public class ThirdFrame {

	public static void main(String[] args) {
		// 상속을 받지 않고 직접 JFrame 객체 생성
		JFrame mainFrame = new JFrame("세번째 프레임 애플리케이션");
		//생성자 생성할 때 title명
		mainFrame.setBounds(new Rectangle(0,0,400,300));//Rectangle에 별도로 설정 가능
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//상수필드라서 JFrame.
		
		mainFrame.setVisible(true);
	}

}
