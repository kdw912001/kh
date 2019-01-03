package silsub.model;

import java.util.Scanner;

public class Sample {
	// �ǽ�����1
	public void munjae1() {
		int[][] tar = new int[4][4];

		// 1~100������ ������ ���� ���
		for (int i = 0; i < tar.length - 1; i++) {
			for (int j = 0; j < tar[i].length - 1; j++) {
				tar[i][j] = (int) (Math.random() * 100) + 1;
			}
		}

		// �� �ະ 3���� 3�࿡ �հ� ���
		for (int i = 0; i < tar.length - 1; i++) {
			for (int j = 0; j < tar[i].length - 1; j++) {
				tar[i][3] += tar[i][j];
				tar[3][i] += tar[j][i];
			}
			tar[3][3] += tar[i][3] + tar[3][i];
		}

		// ���
		for (int i = 0; i < tar.length; i++) {
			System.out.print(i + "�� : ");
			for (int j = 0; j < tar[i].length; j++) {
				System.out.print(tar[i][j] + " \t");
			}
			System.out.println();
		}
	}

	// �ǽ�����2
	public void munjae2() {
		int[][] tar = new int[3][];
		Scanner sc = new Scanner(System.in);

		// �� �ະ ���� ������ Ű����� �Է¹޾� �Ҵ���
		for (int i = 0; i < tar.length; i++) {
			System.out.print(i + "���� ������ �� ���� : ");
			int col = sc.nextInt();
			tar[i] = new int[col];
		}

		// 1���� 100������ ������ ������ ��� �濡 ���
		for (int i = 0; i < tar.length; i++) {
			int sum = 0;
			for (int j = 0; j < tar[i].length; j++) {
				tar[i][j] = (int) (Math.random() * 100) + 1;
				sum += tar[i][j];
			}

			// �� �ະ ���� �հ谡 5�� ����� �ุ ���
			if (sum % 5 == 0) {
				System.out.println(i + "�� �հ� : " + sum);
				for (int j = 0; j < tar[i].length; j++) {
					System.out.print(tar[i][j] + "\t ");
				}
				System.out.println();
			}
		}
	}

	// �ǽ�����2
	public void munjae2_1() {
		int[][] tar = new int[3][];
		int[] sum = new int[3];
		Scanner sc = new Scanner(System.in);

		// �� �ະ ���� ������ Ű����� �Է¹޾� �Ҵ���
		for (int i = 0; i < tar.length; i++) {
			System.out.print(i + "���� ������ �� ���� : ");
			int col = sc.nextInt();
			tar[i] = new int[col];
		}

		// 1���� 100������ ������ ������ ��� �濡 ���
		//�ະ �հ� ���ؼ� sum �迭�� ��� ����
		for (int i = 0; i < tar.length; i++) {
			for (int j = 0; j < tar[i].length; j++) {
				tar[i][j] = (int) (Math.random() * 100) + 1;
				sum[i] += tar[i][j];
			}
		}
		
		//���� �հ谡 5�� ����� �ุ ���
		for(int i = 0; i < tar.length; i++) {
			if(sum[i] % 5 == 0) {
				System.out.println(i + "���� �հ� : " 
						+ sum[i]);
				for(int j = 0; j < tar[i].length; j++) {
					System.out.print(tar[i][j] + "\t ");
				}
				System.out.println();
			}
		}

	}
}







