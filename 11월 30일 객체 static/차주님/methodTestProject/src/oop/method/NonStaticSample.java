package oop.method;

//실습 2
public class NonStaticSample {
	
	public NonStaticSample(){}
	
	//int 한개의 전달값을 받아서, 
	//배열의 주소를 리턴하는 메소드
	//처리할 내용 : 
	//전달받은 정수 갯수만큼의 배열공간을 
	//할당하여, 임의의 1부터 100사이의 값으로
	//값 기록하고 주소 리턴함
	//메소드 명 : intArrayAllocation
	//매개변수도 있고 반환값도 있는 메소드
	public int[] intArrayAllocation(
			int length) {
		int[] ar = new int[length];
		
		for(int i = 0; i < ar.length; i++)
			ar[i] = (int)(Math.random() * 100) + 1;
		
		return ar;
	}
	

	//메소드 명 : display
	//매개변수 있고 반환값 없는 메소드
	//처리할 내용 : 배열을 전달받아 화면에 출력함
	public void display(int[] par) {
		System.out.print("배열값들 : ");
		for(int i = 0; i < par.length; i++) {
			System.out.print(par[i] + "  ");
		}
		System.out.println();
	}	
	
	//메소드명 : swap
	//매개변수 있고 반환값 없는 메소드
	//처리할 내용 : 
	//배열과, 두 정수의 인덱스를 전달받아
	//	두 인덱스의 값을 교환함
	public void swap(int[] ar, int i, int j) {
		int tmp = ar[i];
		ar[i] = ar[j];
		ar[j] = tmp;
	}
	
	//메소드명 : sortDescending
	//매개변수 있고 반환값 없는 메소드
	//처리할 내용 : 
	//위에서 작성한 swap 메소드를 이용하여
	//	배열의 값 들을 내림차순 정렬 처리함
	public void sortDescending(int[] ar) {
		for(int i = 0; i < ar.length - 1; i++) {
			for(int j = i + 1; j < ar.length; j++) {
				if(ar[i] < ar[j])
					/*this.*/swap(ar, i, j);
			}
		}
	}
	
	
	//메소드명 : sortAscending
	//매개변수 있고 반환값 없는 메소드
	//처리할 내용 : swap 메소드를 이용하여 배열의 값들을 오름차순 정렬함
	public void sortAscending(int[] ar) {
		for(int i = 0; i < ar.length - 1; i++) {
			for(int j = i + 1; j < ar.length; j++) {
				if(ar[i] > ar[j])
					/*this.*/swap(ar, i, j);
			}
		}
	}
	
	//1. 문자열과 문자 하나를 전달받아, 
	//문자열에 포함된 문자의 갯수를 
	//리턴하는 메소드
	//포함된 문자가 없으면 0 리턴함
	//메소드명 : countChar
	public int countChar(String str, char ch) {
		int count = 0;
		
		if(str != null && str.length() > 0) {
			int i = 0;
			while(i < str.length()) {
				if(str.charAt(i) == ch)
					count++;
				
				i++;
			}
		}
		
		return count;
	}
	
	//2. 정수 두 개를 전달받아, 
	//두 수중 작은 값에서 큰 값사이의 
	//정수들의 합계를 구해서 리턴하는 메소드
	//메소드명 : totalValue
	public int totalValue(int first, int second) {
		/*int max = Math.max(first, second);
		int min = Math.min(first, second);
		
		int sum = 0;
		for(int k = min; k <= max; k++)
			sum += k;*/
		
		int sum = 0;
		for(int k = Math.min(first, second); 
				k <= Math.max(first, second); 
				k++)
			sum += k;
		
		return sum;
	}
	
	//문자열과 인덱스를 전달받아, 
	//그 위치의 문자를 리턴하는 메소드
	//메소드명 : pCharAt
	public char pCharAt(String s, int index) {
		//return s.charAt(index);
		char ch = '\u0000';
		
		if(s != null && s.length() > 0) {
			char[] arr = s.toCharArray();
			ch = arr[index];
		}
		
		return ch;
	}
	
	//두 개의 문자열을 전달받아, 
	//하나의 문자열로 합쳐서 리턴하는 메소드
	//메소드명 : pConcat
	public String pConcat(String s1, 
						String s2) {
		return s1 + s2;
	}
}







