package day10.silsub;

import java.util.Scanner;

public class Sample {
	public void munjae1() {
		int[][] ar = new int[4][4];
		int[][] sum = new int[4][4];
		
		for(int i=0;i<3;i++) {//합계 전까지만
			for(int j=0;j<3;j++) {
				int rnum = (int)(Math.random()*100)+1;
				ar[i][j]=rnum;
				System.out.print(ar[i][j]+" ");
				sum[i][3]+=ar[i][j];
				ar[i][3]=sum[i][3];
				
			}
			sum[3][3]+=sum[i][3];//가로합
			System.out.println();
			System.out.println(sum[i][3]);
		}
		for(int i=0;i<3;i++ ) {//랜덤값을 다 집어넣어야 열의 합을 구할 수 있음
			for(int j=0;j<3;j++) {
				sum[3][i]+=ar[j][i];
				ar[3][i]=sum[3][i];
				
			}
			sum[3][3]+=sum[3][i];//세로 합
		}
		ar[3][3]=sum[3][3]; //가로+세로 합
		
		for(int i=0;i<4;i++) { //모든 배열 출력
			for(int j=0;j<4;j++) {
				System.out.print(ar[i][j]+"  ");
			}
			System.out.println();
		}
	}
	
	public void munjae2() {
		int[][] ar = new int[3][]; //3행 열은 동적(가변) 배열
		int num;
		int[] sum = new int[3];
		for(int i=0;i<ar.length;i++) {
			System.out.print(i+"행의 열 갯수를 입력 : ");
			num = new Scanner(System.in).nextInt();
			ar[i]=new int[num];
			for(int j=0; j<num;j++) {
				int rnum=(int)(Math.random()*100)+1;
				ar[i][j]=rnum;
				sum[i]+=ar[i][j];
				System.out.print(ar[i][j]+" ");
			}
			System.out.println();
			System.out.println("각 열의 합 : "+sum[i]);
		}
		for(int i=0;i<ar.length;i++) {
			if(sum[i]%5==0)
				System.out.println("행의 합이 5의 배수인 행 출력 : "+i+"행");
			for(int j=0; j<ar[i].length;j++) {
				if(sum[i]%5==0)
					System.out.print(ar[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}
	
	
	public static void main(String[] args) {
		Sample samp=new Sample();
		//samp.munjae1();
		samp.munjae2();
	}
}
