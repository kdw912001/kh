package controll.run;

import java.util.Scanner;

public class TestRandom {
	public void findMaxValue() {
		//1~6 사이의 임의의 난수를 발생시킴
				//키보드로 정수 하나 입력받음
				//입력값과 난수를 비교해서
				//입력값이 크면"크다" 출력
				//입력값이 같으면 "같다" 출력
				//입력값이 작으면 "작다" 출력
		int rnum = (int)(Math.random()*6)+1;
		//int rnum = new Random().nextInt(6) +1;
		Scanner sc = new Scanner(System.in);
		System.out.print("주사위 값은 : ");
		int num = sc.nextInt();
		System.out.println("1~6사이의 랜덤값 : " + rnum);
		System.out.println("입력한 주사위 값 : "+num);
		if(num>rnum)
			System.out.println("크다");
		else if(num==rnum)
			System.out.println("같다");
		else
			System.out.println("작다");
		
	}

	public static void main(String[] args) {
		
		// 랜덤 테스트
		TestRandom test = new TestRandom();
		test.findMaxValue();

	}

}
