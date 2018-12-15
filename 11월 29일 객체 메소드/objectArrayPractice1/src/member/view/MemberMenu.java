package member.view;

import java.util.Scanner;

import member.model.dao.MemberManager;


public class MemberMenu {
	private Scanner sc = new Scanner(System.in);
	
	MemberManager mManager=new MemberManager();
		
	int no;
	public MemberMenu() {}
	
	
	public void mainMenu() {
	
		do {
			System.out.println("�ִ� ��� ������ ȸ�� ���� "+MemberManager.SIZE+"�� �Դϴ�.");
			System.out.println("���� ��ϵ� ȸ������ "+MemberManager.memberCount+"�� �Դϴ�.");
			System.out.print("***** ȸ�� ���� ���α׷� *****\r\n" + 
					"\r\n" + 
					"	1. �� ȸ�� ���		��ü�迭���\r\n" + 
					"	2. ȸ�� ��ȸ		equals ���\r\n" + 
					"	3. ȸ�� ���� ����	setter���\r\n" + 
					"	4. ȸ�� ���� ����	compareto ���\r\n" + 
					"	5. ȸ�� ����		\r\n" + 
					"	6. ��� ���\r\n" + 
					"	9. ������\r\n" + 
					"	�޴� ���� : ");
			no=sc.nextInt();
			switch(no) {
			case 1: mManager.memberInput(); break;
			case 2: searchMenu(); break;
			case 3: modifyMenu(); break;
			case 4: sortMenu(); break;
			case 5: mManager.deleteMember(); break;
			case 6: mManager.printAllMember(); break;
			case 9: System.out.print("������ �����ðڽ��ϱ�? (y/n): ");
					if(sc.next().toUpperCase().charAt(0) == 'Y')
						return;
					
			default: System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
		}while(true);
	}
	public void searchMenu() {
		int index=-1;
		do {
			System.out.print("***** ȸ�� ���� �˻� �޴� *****\r\n" + 
					"	\r\n" + 
					"	1. ���̵�� �˻�\r\n" + 
					"	2. �̸����� �˻�\r\n" + 
					"	3. �̸��Ϸ� �˻�\r\n" + 
					"	9. ���� �޴��� ����\r\n" + 
					"	�޴� ���� : ");
			no=sc.nextInt();
			switch(no) {
			case 1: 
				System.out.print("�˻��� ���̵� �Է� : ");
				String id = sc.next(); 
				index = mManager.searchMemberId(id);
				break;
			case 2: 
				System.out.print("�˻��� �̸� �Է� : ");
				String name = sc.next();
				index = mManager.searchMemberName(name);
				break;
			case 3: 
				System.out.print("�˻��� �̸��� �Է� : ");
				String email = sc.next();
				index = mManager.searchMemberEmail(email);
				break;
			case 9: System.out.println("���� �޴��� ȭ�� �̵��մϴ�."); return;
			default: System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
			System.out.println(index);
			if(index>-1) {
				System.out.println(index+"��° �迭�� �����ϴ� ȸ������ �Դϴ�.");
				mManager.printMember(index);
			}
			else if(index==-1)
				System.out.println("ȸ�������� �������� �ʽ��ϴ�.");
			
		}while(true);
	}
	public void sortMenu() {
		do {
			System.out.print("***** ȸ�� ���� ���� ��� �޴� *****\r\n" + 
					"	\r\n" + 
					"	1. ���̵� �������� ���� ���\r\n" + 
					"	2. ���̵� �������� ���� ���\r\n" + 
					"	3. ���� �������� ���� ���\r\n" + 
					"	4. ���� �������� ���� ���\r\n" + 
					"	5. ���� �������� ���� ���(������)\r\n" + 
					"	9. ���� �޴��� ����\r\n" + 
					"	�޴� ���� :");
			no = sc.nextInt();
			switch(no) {
			case 1: mManager.sortIDAsc(); break;
			case 2: mManager.sortIDDes(); break;
			case 3: mManager.sorAgeAsc(); break;
			case 4: mManager.sortAgeDes(); break;
			case 5: mManager.sortGenderDes(); break;
			case 9: System.out.println("���� �޴��� ȭ�� �̵��մϴ�."); return;
			default : System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
		}while(true);
	}
	public void modifyMenu() {
		do {
			System.out.print("***** ȸ�� ���� ���� �޴� *****\r\n" + 
					"\r\n" + 
					"	1. ��ȣ ����\r\n" + 
					"	2. �̸��� ����\r\n" + 
					"	3. ���� ����\r\n" + 
					"	9. ���� �޴��� ����\r\n" + 
					"	�޴� ���� : ");
			no=sc.nextInt();
			int index;
			String name;
			switch(no) {
			case 1: System.out.print("������ ���̵� : "); 				
					name = sc.next();
					index = mManager.searchMemberId(name);
					mManager.printMember(index);
					if(index!=-1) {
						System.out.print("������ ��ȣ : ");			
						mManager.m1[index].setPassword(sc.next());
						System.out.println("ȸ���� ������ ����Ǿ����ϴ�.");
						System.out.println(mManager.m1[index].memberInfo());
					}
					else 
						System.out.println("�ش� ������ �����ϴ�.");
					break;
			case 2: System.out.print("������ ���̵� : ");
					name = sc.next();
					index = mManager.searchMemberId(name);
					if(index!=-1) {
						System.out.print("������ �̸����ּ� : ");
						mManager.m1[index].setEmail(sc.next());
						System.out.println("ȸ�� ������ ����Ǿ����ϴ�.");
						System.out.println(mManager.m1[index].memberInfo());
					}
					break;
			case 3: System.out.print("������ ���̵� : ");
					name = sc.next();
					index = mManager.searchMemberId(name);
					if(index!=-1) {
						System.out.print("������ ���� : ");
						mManager.m1[index].setAge(sc.nextInt());
						System.out.println("ȸ�� ������ ����Ǿ����ϴ�.");
						System.out.println(mManager.m1[index].memberInfo());
					}
					break;
			case 9: System.out.println("���� �޴��� ȭ�� �̵��մϴ�.");return;
			default : System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
		}while(true);
	}
	
}
