package loop.sample;

import java.util.Scanner;

public class DoWhileSample {

	//ȭ�鿡 �޴��� ����ϰ�
	//�޴���ȣ�� �Է¹޾� 
	//��ȣ�� ���� ����� �۵��ǰ� ó��
	//��ȣ�� 7�̸� �ݺ� �����
	public void testDoWhile1() {
		Scanner sc = new Scanner(System.in);
		int menuNo;
		
		do {
			System.out.println("*** �ֹ��޴� ***");
			System.out.println();
			System.out.println("1. �߰�");
			System.out.println("2. ����");
			System.out.println("3. ��ȸ");
			System.out.println("4. ����");
			System.out.println("5. ���");
			System.out.println("7. ����");
			System.out.print("��ȣ ���� : ");
			menuNo = sc.nextInt();
			
			switch(menuNo) {
			case 1:	System.out.println("�߰��Ǿ����ϴ�.");
					break;
			case 2:	System.out.println("�����Ǿ����ϴ�.");
					break;
			case 3:	System.out.println("��ȸ�Ǿ����ϴ�.");
					break;
			case 4:	System.out.println("�����Ǿ����ϴ�.");
					break;
			case 5:	System.out.println("��µǾ����ϴ�.");
					break;
			case 7:	System.out.println("�����մϴ�.");
					break;
			default:	System.out.println("�߸� �Է��Ͽ����ϴ�.");
					System.out.println("�ٽ� �Է��Ͻʽÿ�.");
			}
		}while(menuNo != 7);
	}
	
	//�ݺ��� �ǽ����� 3
	public void testDoWhile2() {
		Scanner sc = new Scanner(System.in);
		
		int menuNo, account = 0, price = 0;
		int totalPrice = 0;
		String orderItem = "", orderList = "";
		
		do {
			System.out.println("*** �޴��� �����ϼ��� ***");
			System.out.println();
			System.out.println("�ܹ��� ***************");
			System.out.println("1. �Ұ�����	3500��");
			System.out.println("2. ġŲ����	    3200��");
			System.out.println("�߰� ****************");
			System.out.println("3. ����Ƣ��	    1000��");
			System.out.println("4. ġ�ƽ	    400��");
			System.out.println("5. ������		2000��");
			System.out.println("����� ***************");
			System.out.println("6. �ݶ�		700��");
			System.out.println("7. ���̵�		1200��");
			System.out.println("8. Ŀ��		1000��");
			System.out.println("********************");
			System.out.print("�޴� ���� : ");
			menuNo = sc.nextInt();

			switch (menuNo) {
			case 1:
				orderItem = "�Ұ�����";
				price = 3500;
				break;
			case 2:
				orderItem = "ġŲ����";
				price = 3200;
				break;
			case 3:
				orderItem = "����Ƣ��";
				price = 1000;
				break;
			case 4:
				orderItem = "ġ�ƽ";
				price = 400;
				break;
			case 5:
				orderItem = "������";
				price = 2000;
				break;
			case 6:
				orderItem = "�ݶ�";
				price = 700;
				break;
			case 7:
				orderItem = "���̵�";
				price = 1200;
				break;
			case 8:
				orderItem = "Ŀ��";
				price = 1000;
				break;			
			} // switch closed
			
			System.out.println(orderItem + 
					"�� �����ϼ̽��ϴ�.");
			System.out.print("������ ? ");
			account = sc.nextInt();
			System.out.println(account + 
					"�� �ֹ��ϼ̽��ϴ�.");

			// ** ���� ������ ��� ����Ǿ� ���� **
			int total = price * account; // ��� ó����
			orderList += orderItem + " : " + 
					account + "�� - " + total 
					+ "�� \n";
			totalPrice += total; // �ֹ��� ���� �ջ� ó��

			System.out.print("�߰� �ֹ��Ͻðڽ��ϱ�?(y/n) : "); 
			// y �Է½� �޴�ȭ�� �ݺ������			
		} while (sc.next().toUpperCase().charAt(0) == 'Y');

		System.out.println("* �ֹ��Ͻ� ������ ������ �����ϴ�. *");
		System.out.println("-----------------------------------------------");
		System.out.print(orderList);
		System.out.println("------------------------------------------------");
		System.out.println("�� ���� : " + totalPrice + "��");
	}
	
	//���� �ϳ� �Է¹޾�, �����ڵ� ���
	//�ݺ� ������
	//'0' ���� �ԷµǸ�, �ݺ� ����
	public void testDoWhile3() {
		Scanner sc = new Scanner(System.in);
		char ch;
		
		do {
			System.out.print("���� �ϳ� �Է� : ");
			ch = sc.next().charAt(0);
			
			System.out.println(ch + 
					" is unicode " + (int)ch);
		}while(ch != '0');
	}
	
	//���ڿ� �Է¹ް�, ��ȣ���� �ϳ� �Է¹޾�
	//���ڿ��� ���� ���̻��̿� ��ȣ���ڸ�
	//�����־� ��µǰ� do~while ���
	//��> apple, - => a-p-p-l-e
	public void testDoWhile4() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���ڿ� �Է� : ");
		String str = sc.next();
		System.out.print("��ȣ���� : ");
		char symbol = sc.next().charAt(0);
		
		int index = 0;
		do {
			if(index < str.length() - 1)
				System.out.print(str.charAt(index) 
					+ "" + symbol);
			else
				System.out.print(str.charAt(index));
			
			index++;
		}while(index < str.length());
		
		System.out.println();
	}
	
	public void testDoWhile4for() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���ڿ� �Է� : ");
		String str = sc.next();
		System.out.print("��ȣ���� : ");
		char symbol = sc.next().charAt(0);
		
		/*int index = 0;
		do {
			if(index < str.length() - 1)
				System.out.print(str.charAt(index) 
					+ "" + symbol);
			else
				System.out.print(str.charAt(index));
			
			index++;
		}while(index < str.length());*/
		
		for(int index = 0; index < str.length(); index++) {
			if(index < str.length() - 1)
				System.out.print(str.charAt(index) 
					+ "" + symbol);
			else
				System.out.print(str.charAt(index));
		}
		
		System.out.println();
	}
	
	public void testDoWhile4while() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���ڿ� �Է� : ");
		String str = sc.next();
		System.out.print("��ȣ���� : ");
		char symbol = sc.next().charAt(0);
		
		/*int index = 0;
		do {
			if(index < str.length() - 1)
				System.out.print(str.charAt(index) 
					+ "" + symbol);
			else
				System.out.print(str.charAt(index));
			
			index++;
		}while(index < str.length());*/
		
		int index = 0;
		while(index < str.length()) {
			if(index < str.length() - 1)
				System.out.print(str.charAt(index) 
					+ "" + symbol);
			else
				System.out.print(str.charAt(index));
			
			index++;
		}
		
		System.out.println();
	}
}










