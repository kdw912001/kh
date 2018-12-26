package test.layout;

import javax.swing.*;
import java.awt.*;

public class GridLayoutSample extends JFrame {
	
	public GridLayoutSample() {
		super("GridLayout Test");
		this.setBounds(100, 100, 400, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setLayout(new GridLayout(4, 2));
		
		//컴포넌트 객체 생성하고 배치 처리
		for(int k = 1; k < 9; k++) {
			this.add(new JButton(String.valueOf(k)));
		}
		
		this.setVisible(true);
	}

}





