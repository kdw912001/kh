package logic.home.model;
import java.util.*;

public class DoWhileSample {
	private Scanner sc= new Scanner(System.in);
	
	public void addDashToken() {
		System.out.print("문자열 입력 : ");
		String str = sc.next();
		int i=0;
		do {
			if(i<str.length()-1)
				System.out.print(str.charAt(i)+"-");
			else
				System.out.println(str.charAt(i));
			i++;
		}while(str.length()!=i);//while(i<str.length())
			
	}
	public void burgerKingMenu() {
		
	}
	public void isStringAlphabet() {

		
		System.out.print("문자열 입력 : ");
		String str = sc.next();
		int i=0;

		do {
			char c = str.charAt(i);
			
			if(!Character.isUpperCase(c) && !Character.isLowerCase(c)) {
				System.out.println("영문자가 아니다."); 
				break;
			}
			
			if(i==str.length()-1)
				System.out.println("영문자다");
			i++;
		
		}while(i<str.length());
		
	}

}
