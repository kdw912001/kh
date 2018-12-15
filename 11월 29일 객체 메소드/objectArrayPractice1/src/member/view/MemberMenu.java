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
			System.out.println("최대 등록 가능한 회원 수는 "+MemberManager.SIZE+"명 입니다.");
			System.out.println("현재 등록된 회원수는 "+MemberManager.memberCount+"명 입니다.");
			System.out.print("***** 회원 관리 프로그램 *****\r\n" + 
					"\r\n" + 
					"	1. 새 회원 등록		객체배열사용\r\n" + 
					"	2. 회원 조회		equals 사용\r\n" + 
					"	3. 회원 정보 수정	setter사용\r\n" + 
					"	4. 회원 정보 정렬	compareto 사용\r\n" + 
					"	5. 회원 삭제		\r\n" + 
					"	6. 모두 출력\r\n" + 
					"	9. 끝내기\r\n" + 
					"	메뉴 선택 : ");
			no=sc.nextInt();
			switch(no) {
			case 1: mManager.memberInput(); break;
			case 2: searchMenu(); break;
			case 3: modifyMenu(); break;
			case 4: sortMenu(); break;
			case 5: mManager.deleteMember(); break;
			case 6: mManager.printAllMember(); break;
			case 9: System.out.print("정말로 끝내시겠습니까? (y/n): ");
					if(sc.next().toUpperCase().charAt(0) == 'Y')
						return;
					
			default: System.out.println("잘못 입력하셨습니다.");
			}
		}while(true);
	}
	public void searchMenu() {
		int index=-1;
		do {
			System.out.print("***** 회원 정보 검색 메뉴 *****\r\n" + 
					"	\r\n" + 
					"	1. 아이디로 검색\r\n" + 
					"	2. 이름으로 검색\r\n" + 
					"	3. 이메일로 검색\r\n" + 
					"	9. 이전 메뉴로 가기\r\n" + 
					"	메뉴 선택 : ");
			no=sc.nextInt();
			switch(no) {
			case 1: 
				System.out.print("검색할 아이디 입력 : ");
				String id = sc.next(); 
				index = mManager.searchMemberId(id);
				break;
			case 2: 
				System.out.print("검색할 이름 입력 : ");
				String name = sc.next();
				index = mManager.searchMemberName(name);
				break;
			case 3: 
				System.out.print("검색할 이메일 입력 : ");
				String email = sc.next();
				index = mManager.searchMemberEmail(email);
				break;
			case 9: System.out.println("메인 메뉴로 화면 이동합니다."); return;
			default: System.out.println("잘못 입력하셨습니다.");
			}
			System.out.println(index);
			if(index>-1) {
				System.out.println(index+"번째 배열에 존재하는 회원정보 입니다.");
				mManager.printMember(index);
			}
			else if(index==-1)
				System.out.println("회원정보가 존재하지 않습니다.");
			
		}while(true);
	}
	public void sortMenu() {
		do {
			System.out.print("***** 회원 정보 정렬 출력 메뉴 *****\r\n" + 
					"	\r\n" + 
					"	1. 아이디 오름차순 정렬 출력\r\n" + 
					"	2. 아이디 내림차순 정렬 출력\r\n" + 
					"	3. 나이 오름차순 정렬 출력\r\n" + 
					"	4. 나이 내림차순 정렬 출력\r\n" + 
					"	5. 성별 내림차순 정렬 출력(남여순)\r\n" + 
					"	9. 이전 메뉴로 가기\r\n" + 
					"	메뉴 선택 :");
			no = sc.nextInt();
			switch(no) {
			case 1: mManager.sortIDAsc(); break;
			case 2: mManager.sortIDDes(); break;
			case 3: mManager.sorAgeAsc(); break;
			case 4: mManager.sortAgeDes(); break;
			case 5: mManager.sortGenderDes(); break;
			case 9: System.out.println("메인 메뉴로 화면 이동합니다."); return;
			default : System.out.println("잘못 입력하셨습니다.");
			}
		}while(true);
	}
	public void modifyMenu() {
		do {
			System.out.print("***** 회원 정보 수정 메뉴 *****\r\n" + 
					"\r\n" + 
					"	1. 암호 변경\r\n" + 
					"	2. 이메일 변경\r\n" + 
					"	3. 나이 변경\r\n" + 
					"	9. 이전 메뉴로 가기\r\n" + 
					"	메뉴 선택 : ");
			no=sc.nextInt();
			int index;
			String name;
			switch(no) {
			case 1: System.out.print("변경할 아이디 : "); 				
					name = sc.next();
					index = mManager.searchMemberId(name);
					mManager.printMember(index);
					if(index!=-1) {
						System.out.print("변경할 암호 : ");			
						mManager.m1[index].setPassword(sc.next());
						System.out.println("회원의 정보가 변경되었습니다.");
						System.out.println(mManager.m1[index].memberInfo());
					}
					else 
						System.out.println("해당 정보가 없습니다.");
					break;
			case 2: System.out.print("변경할 아이디 : ");
					name = sc.next();
					index = mManager.searchMemberId(name);
					if(index!=-1) {
						System.out.print("변경할 이메일주소 : ");
						mManager.m1[index].setEmail(sc.next());
						System.out.println("회원 정보가 변경되었습니다.");
						System.out.println(mManager.m1[index].memberInfo());
					}
					break;
			case 3: System.out.print("변경할 아이디 : ");
					name = sc.next();
					index = mManager.searchMemberId(name);
					if(index!=-1) {
						System.out.print("변경할 나이 : ");
						mManager.m1[index].setAge(sc.nextInt());
						System.out.println("회원 정보가 변경되었습니다.");
						System.out.println(mManager.m1[index].memberInfo());
					}
					break;
			case 9: System.out.println("메인 메뉴로 화면 이동합니다.");return;
			default : System.out.println("잘못 입력하셨습니다.");
			}
		}while(true);
	}
	
}
