package silsub.model;

import java.util.Scanner;

public class Sample {
	public void munjae1() {
		int[][] ar = new int[4][4];
		
		//1~100������ ������ ���� ���
		for(int i=0;i<3;i++) {
			for(int j=0; j<3;j++) {
				ar[i][j]=(int)(Math.random()*100)+1;
			}
		}
		
		//�� ��� 3���� 3�࿡ �Բ� ���
		for(int i=0; i<ar.length-1;i++) {
			for(int j=0; j<ar[i].length-1;j++) {
				ar[i][3]+=ar[i][j];
				ar[3][i]+=ar[j][i];
			}
			ar[3][3]+=ar[i][3]+ar[3][i];
		}
		/*for(int i=0; i<ar.length-1;i++) {
				ar[3][3]+=ar[i][3]+ar[3][i];
		}*/
		
		//���
		for(int i=0; i<ar.length;i++) {
			System.out.print(i+"�� : ");
			for(int j=0; j<ar[i].length;j++) {
				System.out.print(ar[i][j]+"      ");
			}
			System.out.println();
		}
	}
	
	public void munjae2() {
		/* ���� �Ѱ� �հ� ���� ���� ���� ����.
		 * int ar[][] = new int[3][];
		for(int i=0; i<ar.length;i++) {
			System.out.print(i+"���� �� ���� �Է� : ");
			int num = new Scanner(System.in).nextInt();
			ar[i]=new int[num];
		}
		for(int i=0; i<ar.length;i++) {
			System.out.print(i+"�� 5�� ��� : ");
			for(int j=0; j<ar[i].length;j++) {
				ar[i][j]=(int)(Math.random()*100)+1;
				if(ar[i][j]%5==0)
					System.out.print(ar[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("��ü ���");
		for(int i=0; i<ar.length;i++) {
			for(int j=0; j<ar[i].length;j++) {
				System.out.print(ar[i][j]+"\t");
			}
			System.out.println();
		}*/
		int[][] tar=new int[3][];
		Scanner sc = new Scanner(System.in);
		
		//�� �ະ ���� ������ Ű����� �Է¹޾� �Ҵ���
		for(int i=0; i<tar.length;i++) {
			System.out.print(i+"���� ������ �� ���� :");
			int col = sc.nextInt();
			tar[i] = new int[col];
		}
		
		//1���� 100������ ������ ������ ��� �濡 ���
		for(int i=0; i<tar.length;i++) {
			int sum=0;
			for(int j=0; j<tar[i].length;j++) {
				tar[i][j] = (int)(Math.random()*100)+1;
				sum+=tar[i][j];
			}
			//�� �ະ ���� �հ谡 5�� ����� �ุ ���
			if(sum%5==0) {
				System.out.println(i+"�� �հ� : "+sum);
				for(int j=0; j<tar[i].length;j++) {
					System.out.print(tar[i][j]+"\t");
				}
				System.out.println();
			}
		}
	}
	public void munjae2_1() {
		int[][] tar=new int[3][];
		int[] sum = new int[3];
		Scanner sc = new Scanner(System.in);
		
		//�� �ະ ���� ������ Ű����� �Է¹޾� �Ҵ���
		for(int i=0; i<tar.length;i++) {
			System.out.print(i+"���� ������ �� ���� :");
			int col = sc.nextInt();
			tar[i] = new int[col];
		}
		
		//1���� 100������ ������ ������ ��� �濡 ���
		//�ະ �հ� ���ؼ� sum�迭�� ��� ����
		for(int i=0; i<tar.length;i++) {
			for(int j=0; j<tar[i].length;j++) {
				tar[i][j] = (int)(Math.random()*100)+1;
				sum[i]+=tar[i][j];
			}
		}
		
		//���� �հ谡 5�� ����� �ุ ���
		for(int i=0; i<tar.length; i++) {
			if(sum[i]%5==0) {
				System.out.println(i+"���� �հ� : "+sum[i]);
				for(int j=0; j<tar[i].length;j++) {
					System.out.print(tar[i][j]+"\t");
				}
				System.out.println();
			}
		}
	}
	
	public void munjae3() {
		
	}
}
