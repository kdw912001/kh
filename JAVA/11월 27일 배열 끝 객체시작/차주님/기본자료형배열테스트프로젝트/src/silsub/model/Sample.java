package silsub.model;

import java.util.Scanner;

public class Sample {
	// 실습문제1
	public void munjae1() {
		int[][] tar = new int[4][4];

		// 1~100사이의 임의의 정수 기록
		for (int i = 0; i < tar.length - 1; i++) {
			for (int j = 0; j < tar[i].length - 1; j++) {
				tar[i][j] = (int) (Math.random() * 100) + 1;
			}
		}

		// 각 행별 3열과 3행에 합계 기록
		for (int i = 0; i < tar.length - 1; i++) {
			for (int j = 0; j < tar[i].length - 1; j++) {
				tar[i][3] += tar[i][j];
				tar[3][i] += tar[j][i];
			}
			tar[3][3] += tar[i][3] + tar[3][i];
		}

		// 출력
		for (int i = 0; i < tar.length; i++) {
			System.out.print(i + "행 : ");
			for (int j = 0; j < tar[i].length; j++) {
				System.out.print(tar[i][j] + " \t");
			}
			System.out.println();
		}
	}

	// 실습문제2
	public void munjae2() {
		int[][] tar = new int[3][];
		Scanner sc = new Scanner(System.in);

		// 각 행별 열의 갯수는 키보드로 입력받아 할당함
		for (int i = 0; i < tar.length; i++) {
			System.out.print(i + "행이 참조할 열 갯수 : ");
			int col = sc.nextInt();
			tar[i] = new int[col];
		}

		// 1부터 100사이의 임의의 정수를 모든 방에 기록
		for (int i = 0; i < tar.length; i++) {
			int sum = 0;
			for (int j = 0; j < tar[i].length; j++) {
				tar[i][j] = (int) (Math.random() * 100) + 1;
				sum += tar[i][j];
			}

			// 각 행별 열의 합계가 5의 배수인 행만 출력
			if (sum % 5 == 0) {
				System.out.println(i + "행 합계 : " + sum);
				for (int j = 0; j < tar[i].length; j++) {
					System.out.print(tar[i][j] + "\t ");
				}
				System.out.println();
			}
		}
	}

	// 실습문제2
	public void munjae2_1() {
		int[][] tar = new int[3][];
		int[] sum = new int[3];
		Scanner sc = new Scanner(System.in);

		// 각 행별 열의 갯수는 키보드로 입력받아 할당함
		for (int i = 0; i < tar.length; i++) {
			System.out.print(i + "행이 참조할 열 갯수 : ");
			int col = sc.nextInt();
			tar[i] = new int[col];
		}

		// 1부터 100사이의 임의의 정수를 모든 방에 기록
		//행별 합계 구해서 sum 배열에 기록 저장
		for (int i = 0; i < tar.length; i++) {
			for (int j = 0; j < tar[i].length; j++) {
				tar[i][j] = (int) (Math.random() * 100) + 1;
				sum[i] += tar[i][j];
			}
		}
		
		//행의 합계가 5의 배수인 행만 출력
		for(int i = 0; i < tar.length; i++) {
			if(sum[i] % 5 == 0) {
				System.out.println(i + "행의 합계 : " 
						+ sum[i]);
				for(int j = 0; j < tar[i].length; j++) {
					System.out.print(tar[i][j] + "\t ");
				}
				System.out.println();
			}
		}

	}
}







