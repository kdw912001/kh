package test.frame;

import javax.swing.*;
import java.awt.*;//보통 스윙을 쓰지만 awt도 쓰기 때문에 같이 import

//윈동우 창을 구성할 첫번째 방법
//실행용 클래스가 JFrame을 상속받는 경우

public class FirstFrame extends JFrame{
	//상속 받으면 JFrame클래스의 메소드 사용할 수 있음
	public FirstFrame() {
		this.setTitle("첫번째 gui 애플리케이션");//타이틀 바에 보여질 프로그램 이름
		this.setLocation(100, 100);//윈도우창 왼쪽 위 코너 기준 좌표
		this.setSize(600, 350);//창의 가로 세로 픽셀(해상도 기준)
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//창 닫기를 눌렀을 때 하는 행동
		
		
		//모든 창의 컴포넌트 구성과 배치가 끝나면, 맨 마지막에 사용해야 함
		this.setVisible(true);//창을 보이게 함 true면 보이고 false면 안 보임
	}
	
	public static void main(String[] args) {
		new FirstFrame();

	}

}
