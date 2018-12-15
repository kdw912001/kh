package member.model.dao;

import java.util.Scanner;

import member.model.dto.Member;

public class MemberManager {
	
	public MemberManager() {}
	public static final int SIZE = 10; //�ִ� 10��
	public static int memberCount; //���� ��� �� 5��
	Member m = new Member();
	public Member[] m1=new Member[10]; 
	/*for(int i=0; i<m1.length;i++) {
		m1[i]=new Member()
	}
	m1[0]=new Member("���̵�1","�̸�1","�н�����1","�̸���1",'m',18);
		*/
	private Scanner sc = new Scanner(System.in);
	{
		m1[0]=new Member("���̵�2","�̸�1","�н�����1","�̸���1",'m',18);
		m1[1]=new Member("���̵�1","�̸�2","�н�����2","�̸���2",'m',20);
		m1[2]=new Member("����̵�3","�̸�3","�н�����3","�̸���3",'f',50);
		m1[3]=new Member("���̵�4","�̸�4","�н�����4","�̸���4",'m',40);
		m1[4]=new Member("���̵�5","�̸�5","�н�����5","�̸���5",'m',60);
		memberCount=5;
	}
	public void memberInput() {
		System.out.println();

		System.out.print("���̵� �Է� : ");
		m.setId(sc.next());
		System.out.print("�̸� �Է� : ");
		m.setName(sc.next());
		System.out.print("�н����� �Է� : ");
		m.setPassword(sc.next());
		System.out.print("�̸��� �ּ� �Է�  : ");
		m.setEmail(sc.next());
		System.out.print("���� �Է�[��/��] : ");
		m.setGender(sc.next().charAt(0));
		System.out.print("���� �Է� : ");
		m.setAge(sc.nextInt());
		System.out.println(memberCount);
		
		System.out.println(memberCount);
		m1[memberCount]=new Member(m.getId(),m.getName(),m.getPassword(),
				m.getEamil(),m.getGender(),m.getAge());
		memberCount++;
	}

	public void deleteMember() {
		// TODO Auto-generated method stub
		
		System.out.print("������ ���̵� �Է� : ");
		int index = searchMemberId(sc.next());
		m1[index]=null;
		if(index!=-1) {
			for(int i=index;i<m1.length-1;i++) {
				m1[i]=m1[i+1];
			}
			memberCount--;
		}
		else
			System.out.println("�ش� ���̵�� ȸ�������� �����ϴ�.");
	
	}

	public void printAllMember() {
		for(int i=0; i<memberCount;i++) {
			System.out.println(m1[i].memberInfo()+"  ");
		}
		
	}
	public int searchMemberId(String Id) {
		//for �迭���̸�ŭ �̸��� ������ �迭�ε��� ����
		//�ƴϸ� -1����
		for(int i=0; i<memberCount;i++) {
			if(m1[i].getId().equals(Id)) {
				return i;
			}
		}
		return -1;
	}
	public int searchMemberName(String name) {
		for(int i=0; i<memberCount;i++){
			if(m1[i].getName().equals(name))
				return i;
		}
		return -1;
	}
	public int searchMemberEmail(String email) {
		for(int i=0; i<memberCount;i++) {
			if(m1[i].getEamil().equals(email))
				return i;
		}
		return -1;
	}
	
	public void printMember(int index) {
		//index�� ȸ������ ���
		System.out.println(m1[index].memberInfo());
	}
	public void sortIDAsc() {
		/*String ar[] = new String[memberCount];
		for(int i=0; i<ar.length;i++) {
			ar[i]=m1[i].getId();
			
		}
		for(int i=0; i<ar.length-1;i++) {
			for(int j=i;j<ar.length;j++) {
				if(ar[i].compareTo(ar[j])>0) {
					String tmp=ar[i];
					ar[i]=ar[j];
					ar[j]=tmp;
				}
			}
		}
		for(int i=0; i<ar.length; i++) {
			System.out.print(ar[i]+"  ");
		}
		System.out.println();*/
		for(int i=0; i<memberCount-1;i++) {
			for(int j=i;j<memberCount;j++) {
				if(m1[i].getId().compareTo(m1[j].getId())>0) {
					m=m1[i];
					m1[i]=m1[j];
					m1[j]=m;
				}
			}
		}
		for(int i=0; i<memberCount;i++) {
			System.out.println(m1[i].memberInfo());
		}
	}
	public void sortIDDes() {
		/*String ar[]=new String[memberCount];
		for(int i=0; i<ar.length;i++) {
			ar[i]=m1[i].getId();
			
		}
		for(int i=0; i<ar.length-1;i++) {
			for(int j=i; j<ar.length;j++) {
				if(ar[i].compareTo(ar[j])<0) {
					String tmp=ar[i];
					ar[i]=ar[j];
					ar[j]=tmp;
				}
			}
		}
		for(int i=0; i<ar.length;i++) {
			System.out.print(ar[i]+"  ");
		}
		System.out.println();*/
		for(int i=0; i<memberCount-1;i++) {
			for(int j=i; j<memberCount;j++) {
				if(m1[i].getId().compareTo(m1[j].getId())<0) {
					m=m1[i];
					m1[i]=m1[j];
					m1[j]=m;
				}
			}
		}
		for(int i=0; i<memberCount;i++) {
			System.out.println(m1[i].memberInfo());
		}
	}
	public void sorAgeAsc() {
		/*int []ar=new int[memberCount];
		for(int i=0; i<ar.length;i++) {
			ar[i]=m1[i].getAge();
			
		}
		for(int i=0; i<ar.length-1;i++) {
			for(int j=i; j<ar.length;j++) {
				if(Integer.compare(ar[i], ar[j])>0) {
					int tmp=ar[i];
					ar[i]=ar[j];
					ar[j]=tmp;
				}
			}
		}
		for(int i=0; i<ar.length;i++) {
			System.out.print("���� �� : "+ar[i] + "  ");
		}*/
		
		for(int i=0; i<memberCount-1;i++) {
			for(int j=i; j<memberCount;j++) {
				if(Integer.compare(m1[i].getAge(),m1[j].getAge())>0) {
					m=m1[i];
					m1[i]=m1[j];
					m1[j]=m;
				}
			}
		}
		for(int i=0;i<memberCount;i++) {
			System.out.println(m1[i].memberInfo());
		}
		
	}
	public void sortAgeDes() {
		/*int []ar=new int[memberCount];
		for(int i=0; i<ar.length;i++) {
			ar[i]=m1[i].getAge();
			
		}
		for(int i=0; i<ar.length-1;i++) {
			for(int j=i; j<ar.length;j++) {
				if(Integer.compare(ar[i], ar[j])<0) {
					int tmp=ar[i];
					ar[i]=ar[j];
					ar[j]=tmp;
				}
			}
		}
		for(int i=0; i<ar.length;i++) {
			System.out.print("���� �� : "+ar[i] + "  ");
		}*/
		
		for(int i=0; i<memberCount-1;i++) {
			for(int j=i; j<memberCount;j++) {
				if(Integer.compare(m1[i].getAge(), m1[j].getAge())<0) {
					m=m1[i];
					m1[i]=m1[j];
					m1[j]=m;
				}
			}
		}
		for(int i=0; i<memberCount;i++) {
			System.out.println(m1[i].memberInfo());
		}
	}
	public void sortGenderDes() {
		/*char[] ar=new char[memberCount];
		for(int i=0; i<ar.length;i++) {
			ar[i]=m1[i].getGender();
			
		}
		for(int i=0; i<ar.length-1;i++) {
			for(int j=i; j<ar.length;j++) {
				if(Character.compare(ar[i], ar[j])<0) {
					char tmp=ar[i];
					ar[i]=ar[j];
					ar[j]=tmp;
				}
			}
		}
		for(int i=0; i<ar.length;i++) {
			System.out.print("���� �� : "+ar[i]+"  ");
		}*/
		for(int i=0; i<memberCount-1;i++) {
			for(int j=i;j<memberCount;j++) {
				if(Character.compare(m1[i].getGender(), m1[j].getGender())<0) {
					m=m1[i];
					m1[i]=m1[j];
					m1[j]=m;
				}
			}
		}
		for(int i=0; i<memberCount;i++) {
			System.out.println(m1[i].memberInfo());
		}
	}
	
}
