package test.controller;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
	
		for(int dan=2; dan<=5;dan++) {
			for(int i=1; i<10;i++) {
				if((dan*i)%2==1)
					System.out.println(dan+"*"+i+"="+(dan*i));
			}
		}

	}

}
