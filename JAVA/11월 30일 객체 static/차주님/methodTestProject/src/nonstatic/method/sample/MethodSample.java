package nonstatic.method.sample;

import java.util.Scanner;

public class MethodSample {
	//Field
	//접근제한자 [예약어] 자료형 변수명;
	private Scanner sc = new Scanner(System.in);
	
	//Constructor
	//접근제한자 클래스명([자료형 변수]){ 필드 초기화 }
	//기본생성자
	public MethodSample() {}
	
	//Method
	//접근제한자 [예약어] 반환자료형 메소드명([자료형 변수]){}
	
	//1. 반환값 없고 매개변수 없는 메소드
	public void printLotto() {
		int[] lotto = new int[6];
		
		for(int i = 0; i < lotto.length; i++) {
			lotto[i] = (int)(Math.random() * 45) + 1;
			
			if(i > 0) {  //중복값 체크
				for(int j = 0; j < i; j++) {
					if(lotto[j] == lotto[i]) {
						i--;
						break;
					}
				}
			}
		}
		
		//오름차순정렬하고 출력
		for(int i = 0; i < lotto.length - 1; i++) {
			for(int j = i + 1; j < lotto.length; j++) {
				if(lotto[i] > lotto[j]) {
					//swap 공식 사용
					int tmp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = tmp;
				}
			}
		}
		
		//정렬 후 출력
		System.out.print("lotto : ");
		for(int i = 0; i < lotto.length; i++)
			System.out.print(lotto[i] + "   ");
		System.out.println();
		
		return;
	}
	
	//2. 반환값 없고 매개변수 있는 메소드
	public void printUnicode(char ch) {
		System.out.println(ch + " is unicode " + (int)ch);
		return;
	}
	
	//3. 반환값 있고 매개변수 없는 메소드
	public int random1to100() {
		return (int)(Math.random() * 100) + 1;
	}
	
	//4. 반환값 있고 매개변수 있는 메소드
	public int randomInt(int start, int end) {
		return (int)(Math.random() * (end - start + 1)) + start;
	}
}










