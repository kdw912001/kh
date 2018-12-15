package test.controller;

public class Test3 {

	public static void main(String[] args) {
		
		int sum=0, i=1;
		while(i<101) {
			sum+=i++;
		}
		System.out.println("ÇÕ°è : "+(double)sum);
		System.out.println("Æò±Õ : "+(sum/100.0));
	}

}
