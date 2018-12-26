package test.frame;

import javax.swing.*;
import java.awt.*;

//윈도우 창을 구성할 첫번째 방법
//실행용 클래스가 JFrame 을 상속받는 경우
public class FirstFrame extends JFrame {
	
	public FirstFrame() {
		this.setTitle("첫번째 gui 애플리케이션");
		this.setLocation(100, 100);
		this.setSize(600, 350);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		//모든 창의 컴포넌트 구성과 배치가
		//끝나면, 맨 마지막에 사용해야 함
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new FirstFrame();
	}

}
