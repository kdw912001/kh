package day10.silsub;

import java.util.Scanner;

public class Sample {
	public void munjae1() {
		int[][] ar = new int[4][4];
		int[][] sum = new int[4][4];
		
		for(int i=0;i<3;i++) {//�հ� ��������
			for(int j=0;j<3;j++) {
				int rnum = (int)(Math.random()*100)+1;
				ar[i][j]=rnum;
				System.out.print(ar[i][j]+" ");
				sum[i][3]+=ar[i][j];
				ar[i][3]=sum[i][3];
				
			}
			sum[3][3]+=sum[i][3];//������
			System.out.println();
			System.out.println(sum[i][3]);
		}
		for(int i=0;i<3;i++ ) {//�������� �� ����־�� ���� ���� ���� �� ����
			for(int j=0;j<3;j++) {
				sum[3][i]+=ar[j][i];
				ar[3][i]=sum[3][i];
				
			}
			sum[3][3]+=sum[3][i];//���� ��
		}
		ar[3][3]=sum[3][3]; //����+���� ��
		
		for(int i=0;i<4;i++) { //��� �迭 ���
			for(int j=0;j<4;j++) {
				System.out.print(ar[i][j]+"  ");
			}
			System.out.println();
		}
	}
	
	public void munjae2() {
		int[][] ar = new int[3][]; //3�� ���� ����(����) �迭
		int num;
		int[] sum = new int[3];
		for(int i=0;i<ar.length;i++) {
			System.out.print(i+"���� �� ������ �Է� : ");
			num = new Scanner(System.in).nextInt();
			ar[i]=new int[num];
			for(int j=0; j<num;j++) {
				int rnum=(int)(Math.random()*100)+1;
				ar[i][j]=rnum;
				sum[i]+=ar[i][j];
				System.out.print(ar[i][j]+" ");
			}
			System.out.println();
			System.out.println("�� ���� �� : "+sum[i]);
		}
		for(int i=0;i<ar.length;i++) {
			if(sum[i]%5==0)
				System.out.println("���� ���� 5�� ����� �� ��� : "+i+"��");
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
