package silsub.sample;
import java.util.Scanner;

public class Munjae {
	private Scanner sc = new Scanner(System.in);
	
	public void test1() {
		System.out.print("���� ���� �Է� : ");
		int kor = sc.nextInt();
		System.out.print("���� ���� �Է� : ");
		int eng = sc.nextInt();
		System.out.print("���� ���� �Է� : ");
		int math = sc.nextInt();
		int sum = kor+eng+math;
		double avg = (int)((sum/3)*100)/100.0;
		if(kor>=40&&eng>=40&&math>=40&&avg>=60) 
			System.out.println("�հ�");
		else
			System.out.println("���հ�");
			
	}
	public void test2() {
		System.out.print("*** �ʱ� �޴� ***\r\n" + 
				"		1. �Է�\r\n" + 
				"		2. ����\r\n" + 
				"		3. ��ȸ\r\n" + 
				"		4. ����\r\n" + 
				"		7. ����\r\n" + 
				"		�޴���ȣ �Է� :");
		int no = sc.nextInt();
		
		switch(no) {
		case 1: System.out.println("�Է¸޴��� ���õǾ����ϴ�."); break;
		case 2: System.out.println("�����޴��� ���õǾ����ϴ�.");break;
		case 3: System.out.println("��ȸ�޴��� ���õǾ����ϴ�.");break;
		case 4: System.out.println("�����޴��� ���õǾ����ϴ�.");break;
		case 7: System.out.println("���α׷��� ����Ǿ����ϴ�.");break;
		default : System.out.println("��ȣ�� �߸� �ԷµǾ����ϴ�.");
		           System.out.println("�ٽ� �Է��Ͻʽÿ�.");
		           test2();
		           break;
		}
	}
	
	public void test3() {
		System.out.print("���� �ϳ� �Է� : ");
		int num = sc.nextInt();
		if(num>0)
			System.out.println("�����");
		else
			System.out.println("������");
	}
	
	public void test4() {
		System.out.print("���� �ϳ� �Է�: ");
		int num = sc.nextInt();
		String str = "";
		if(num>0) {
			if(num%2==0) {
				str = "¦����";
			}
			else
				str = "Ȧ����";
		}
		System.out.println(str);
	}
	
	public void inputTest() {
		String name = sc.nextLine(); // ���� �Է� ����
		int age = sc.nextInt();
		double height = (int)(sc.nextDouble()*10)/10.0;
		if(name!=null && name.length()>0 && age>0 && height>0) {
			System.out.println("�̸� : "+name);
			System.out.println("���� : "+age);
			System.out.println("Ű : "+height);
			System.out.println("Ȯ�� : "+name+"�� ���̴� "+age+"���̰�,"+"Ű�� "+height+" cm �̴�.");
		}
	}
	
	public void test6() {
		System.out.print("ù��° ���� : ");
		int num1 = sc.nextInt();
		System.out.print("�ι�° ���� : ");
		int num2 = sc.nextInt();
		if(num1>0 && num2>0) {
			System.out.println(num1+" + "+num2+" = "+(num1+num2));
			System.out.println(num1+" - "+num2+" = "+(num1-num2));
			System.out.println(num1+" * "+num2+" = "+(num1*num2));
			System.out.println(num1+" / "+num2+" = "+(num1/num2));
			System.out.println(num1+" % "+num2+" = "+(num1%num2));
		}
	}
	
	public void test7() {
		System.out.print("���� �Է� : ");
		int score = sc.nextInt(); 
		char grade = ' ';
		if(score>=0) {
			if(score>=90)
				grade = 'A';
			else if(score>=80)
				grade = 'B';
			else if(score>=70)
				grade = 'C';
			else if(score>=60)
				grade = 'D';
			else
				grade = 'F';
		}	
		System.out.println("���� : "+score);
		System.out.println("���� : "+grade);
	}
}
