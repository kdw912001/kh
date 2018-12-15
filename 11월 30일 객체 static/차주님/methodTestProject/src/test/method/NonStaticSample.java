package test.method;

import java.util.Random;

public class NonStaticSample {
	public NonStaticSample(){}
	
	//1. 반환값 없고 매개변수 없는 메소드
	//실행 요청시 1~45까지의 임의의 정수 
	//6개 중복되지 않게 발생시켜 
	//출력하는 메소드
	//메소드명 : printLottoNumbers
	public void printLottoNumbers() {
		int[] lotto = new int[6];
		Random r = new Random();
		
		for(int i = 0; i < lotto.length; i++) {
			lotto[i] = r.nextInt(45) + 1;
			//중복확인
			if(i > 0) {
				//기존의 기록된 값과 비교
				for(int j = 0; j < i; j++) {
					if(lotto[i] == lotto[j]) {
						i--;
						break;
					}
				}
			}
		}
		
		//출력처리
		System.out.print("lotto : ");
		for(int i = 0; i < lotto.length; i++)
			System.out.print(lotto[i] + "   ");
		System.out.println();
	}
	
	//2. 반환값 없고 매개변수 있는 메소드
	//실행 요청시 정수 하나, 문자 하나를 
	//전달받아 문자를 정수 갯수만큼 
	//출력하는 메소드
	//메소드명 : outputChar
	public void outputChar(int count, char ch) {
		for(int c = 1; c <= count; c++)
			System.out.print(ch);
		
		System.out.println();
	}
	
	//3. 반환값 있고 매개변수 없는 메소드
	//실행 요청시 알파벳 범위의 임의의 영문자를 
	//하나 발생시켜 리턴하는 메소드
	//메소드명 : alphabette
	public char alphabette() {
		//영어대문자 : 65(A)~90(Z)
		//영어소문자 : 97(a)~122(z)
		//91~96 : 기호문자
		int rnum;
		Random r = new Random();
		
		while(true) {
			rnum = r.nextInt(122-65+1) + 65;
			
			//if(!(rnum >= 91 && rnum <= 96))
			if(rnum < 91 || rnum > 96)
				break;
		}
		
		return (char)rnum;
	}
	
	//4. 반환값 있고 매개변수 있는 메소드
	//실행 요청시 문자열과 시작인덱스, 끝인덱스를 전달받아 해당 인덱스 범위의 문자열을
	//추출하여 리턴하는 메소드. 단 문자열은 반드시 값이 있어야함. 없으면 null 리턴처리
	//메소드명 : mySubstring
	public String mySubstring(
		String str, int begin, int end) {
		
		String subStr = null;
		
		if(str != null && str.length() > 0) {
			subStr = "";
			for(int i = begin; i <= end; i++) {
				subStr += str.charAt(i);
			}
		}
		
		return subStr;
	}
}









