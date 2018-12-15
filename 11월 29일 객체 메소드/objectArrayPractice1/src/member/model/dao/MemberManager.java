package member.model.dao;

import java.util.Scanner;

import member.model.dto.Member;

public class MemberManager {
	
	public MemberManager() {}
	public static final int SIZE = 10; //최대 10명
	public static int memberCount; //현재 등록 수 5명
	Member m = new Member();
	public Member[] m1=new Member[10]; 
	/*for(int i=0; i<m1.length;i++) {
		m1[i]=new Member()
	}
	m1[0]=new Member("아이디1","이름1","패스워드1","이메일1",'m',18);
		*/
	private Scanner sc = new Scanner(System.in);
	{
		m1[0]=new Member("아이디2","이름1","패스워드1","이메일1",'m',18);
		m1[1]=new Member("아이디1","이름2","패스워드2","이메일2",'m',20);
		m1[2]=new Member("김아이디3","이름3","패스워드3","이메일3",'f',50);
		m1[3]=new Member("아이디4","이름4","패스워드4","이메일4",'m',40);
		m1[4]=new Member("아이디5","이름5","패스워드5","이메일5",'m',60);
		memberCount=5;
	}
	public void memberInput() {
		System.out.println();

		System.out.print("아이디 입력 : ");
		m.setId(sc.next());
		System.out.print("이름 입력 : ");
		m.setName(sc.next());
		System.out.print("패스워드 입력 : ");
		m.setPassword(sc.next());
		System.out.print("이메일 주소 입력  : ");
		m.setEmail(sc.next());
		System.out.print("성별 입력[남/여] : ");
		m.setGender(sc.next().charAt(0));
		System.out.print("나이 입력 : ");
		m.setAge(sc.nextInt());
		System.out.println(memberCount);
		
		System.out.println(memberCount);
		m1[memberCount]=new Member(m.getId(),m.getName(),m.getPassword(),
				m.getEamil(),m.getGender(),m.getAge());
		memberCount++;
	}

	public void deleteMember() {
		// TODO Auto-generated method stub
		
		System.out.print("삭제할 아이디를 입력 : ");
		int index = searchMemberId(sc.next());
		m1[index]=null;
		if(index!=-1) {
			for(int i=index;i<m1.length-1;i++) {
				m1[i]=m1[i+1];
			}
			memberCount--;
		}
		else
			System.out.println("해당 아이디는 회원정보에 없습니다.");
	
	}

	public void printAllMember() {
		for(int i=0; i<memberCount;i++) {
			System.out.println(m1[i].memberInfo()+"  ");
		}
		
	}
	public int searchMemberId(String Id) {
		//for 배열길이만큼 이름이 같으면 배열인덱스 리턴
		//아니면 -1리턴
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
		//index의 회원정보 출력
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
			System.out.print("정렬 후 : "+ar[i] + "  ");
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
			System.out.print("정렬 후 : "+ar[i] + "  ");
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
			System.out.print("정렬 후 : "+ar[i]+"  ");
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
