package test.layout;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutSample extends JFrame {
	//Field
	private JButton okBtn, cancleBtn, backBtn;
	
	public FlowLayoutSample() {
		super("FlowLayout Test");
		this.setBounds(100, 100, 400, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setLayout(new FlowLayout());
		//컴포넌트들을 가운데 정렬하면서 추가함
		//컴포넌트의 기본 크기를 유지함
		//기본 정렬방향은 왼쪽에서 오른쪽으로 추가됨.
		//한줄을 초과하면 자동 두번째 줄에 배치됨.
		
		okBtn = new JButton("확인");
		cancleBtn = new JButton("취소");
		backBtn = new JButton("뒤로");
		
		this.add(okBtn);
		this.add(cancleBtn);
		this.add(backBtn);		
		
		this.setVisible(true);
	}
}






