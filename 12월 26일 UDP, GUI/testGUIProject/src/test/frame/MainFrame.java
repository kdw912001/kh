package test.frame;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
	public MainFrame() {
		super("두번째 프레임 애플리케이션");
		this.setBounds(0, 0, 400, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setVisible(true);
	}
}
