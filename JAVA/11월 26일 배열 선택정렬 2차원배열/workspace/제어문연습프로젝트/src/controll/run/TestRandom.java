package controll.run;

import java.util.Scanner;

public class TestRandom {
	public void findMaxValue() {
		//1~6 ������ ������ ������ �߻���Ŵ
				//Ű����� ���� �ϳ� �Է¹���
				//�Է°��� ������ ���ؼ�
				//�Է°��� ũ��"ũ��" ���
				//�Է°��� ������ "����" ���
				//�Է°��� ������ "�۴�" ���
		int rnum = (int)(Math.random()*6)+1;
		//int rnum = new Random().nextInt(6) +1;
		Scanner sc = new Scanner(System.in);
		System.out.print("�ֻ��� ���� : ");
		int num = sc.nextInt();
		System.out.println("1~6������ ������ : " + rnum);
		System.out.println("�Է��� �ֻ��� �� : "+num);
		if(num>rnum)
			System.out.println("ũ��");
		else if(num==rnum)
			System.out.println("����");
		else
			System.out.println("�۴�");
		
	}

	public static void main(String[] args) {
		
		// ���� �׽�Ʈ
		TestRandom test = new TestRandom();
		test.findMaxValue();

	}

}
