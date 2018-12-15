package test.method;

public class NonStaticSample {//메소드실습1
	public NonStaticSample() {}
	
	public void printLottoNumbers(){
		int[] ar = new int[6];
		for(int i=0; i<ar.length;i++) {
			ar[i]=(int)(Math.random()*45)+1;
			for(int j=1;j<i;j++) {
				if(ar[i]==ar[j]) {
					i--;
					break;
				}
			}
		}
		for(int i=0; i<ar.length;i++) {
			System.out.print(ar[i]+"  ");
		}
		System.out.println();
	}
	
	public void outputChar(int num, char ch) {
		for(int i=0; i<num;i++) {
			System.out.print(ch);
		}
		System.out.println();
	}
	
	public char alphabette() {
		char ch='\u0000';
		while(!Character.isAlphabetic(ch)) {
			ch=(char) ((int) (Math.random()*58)+65);
		}
		return ch;
	}
	
	public String mySubstring(String str, int start, int end) {
		
		if(str.equals(null))
			return null;
		else{
			String str1="";
			for(int i=start;i<=end;i++) {
			str1+=str.charAt(i);
			}
			return str1;
		}
	}
}
