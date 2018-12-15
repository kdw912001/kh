package oop.method;

public class NonStaticSample { //메소드실습2
	public NonStaticSample() {}
	
	public int intArrayAllocateion(int num) {
		int[] ar = new int[num];
		for(int i=0;i<ar.length;i++) {
			ar[i]=(int)(Math.random()*100)+1;
		}
		return ar.hashCode();
	}
	
	public void display(int[]ar) {
		for(int i=0; i<ar.length;i++) {
			System.out.print(ar[i]+"  ");
		}
		System.out.println();
	}
	
	public void swap(int[] ar,int num1, int num2) {
	
		int tmp=ar[num1];
		ar[num1]=ar[num2];
		ar[num2]=tmp;
		
	}
	
	public void sortDescendint(int[] ar) {
		for(int i=0; i<ar.length-1;i++) {
			for(int j=i;j<ar.length;j++) {
				if(ar[i]<ar[j]) {
					swap(ar,i,j);
				}
			}
		}
	}
	
	public void sortAscending(int[] ar) {
		for(int i=0; i<ar.length-1;i++) {
			for(int j=i;j<ar.length;j++) {
				if(ar[i]>ar[j]) {
					swap(ar,i,j);
				}
			}
		}
	}
	
	public int countChar(String str, char ch) {
		int count=0;
		if(str.length()==0 ||str.equals(null)) {
			return count;
		}
		for(int i=0; i<str.length();i++) {
			if(ch==str.charAt(i)) {
				count+=1;
			}
		}
		return count;
		
	}
	
	public int totalValue(int num1, int num2) {
		int sum=0;
		int max,min;
		if(num1<num2) {
			max=num2;
			min=num1;
		}else {
			max=num1;
			min=num2;
		}
		for(int i=min;i<=max; i++) {
			sum+=i;
		}
		return sum;
	}
	
	public char pCarAt(String str, int index) {
		return str.charAt(index);
	}
	
	public String pConcat(String str1, String str2) {
		return str1+str2;
	}
}
	
