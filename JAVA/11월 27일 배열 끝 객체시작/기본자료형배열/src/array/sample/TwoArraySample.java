﻿package array.sample;

public class TwoArraySample {
	public void testTwoArray() {
		//1. 2차원 배열에 대한 레퍼런스 선언
		int[][] tar;
		
		//2. 2차원 배열 공간을 힙에 할당
		tar = new int[3][];
		
		System.out.println("tar.length: "+tar.length);
		
		//행의 갯수는 레퍼런스 배열 갯수다.
		//레퍼런스 변수들의 묶음
		//주소 보관용 변수 3개를 배열로 할당.
		//힙에 할당된 참조변수의 기본값은 null임.
		for(int row=0; row<tar.length;row++) {
			System.out.println("tar["+row+"] : "+tar[row]);
		}
		
		//각 레퍼런스에 주소를 기록함
		//각 1차원배열을 할당하고 그 주소를 기록함
		tar[0] = new int[5];
		tar[1] = new int[4];
		tar[2] = new int[7];
		
		//각 레퍼런스에 주소 기록 확인
		for(int row=0; row<tar.length;row++) {
			System.out.println("tar["+row+"] : "+tar[row].hashCode());
																//hashCode() : 주소를10진수로 처리
		}
		
		//각 1차원 배열에 값 기록
		for(int r=0; r<tar.length; r++) {
			//각 레퍼런스가 참조하는 1차원 배열들 처리
			System.out.println("tar["+r+"].length : " + tar[r].length);
			for(int c=0; c<tar[r].length;c++) {
				tar[r][c] = (int)(Math.random()*100)+1;
			}
		}
		
		//2차원 배열 각 방의 값 확인
		for(int i=0; i<tar.length;i++) {
			for(int j=0; j<tar[i].length;j++) {
				System.out.print(tar[i][j]+"   ");
			}
			System.out.println();
		}
	}
	
	
	public void testTwoArray2() {

		int[][] tar = new int[3][5];
		
		System.out.println(tar.length);
		System.out.println(tar[0].length);
		System.out.println(tar[1].length);
		System.out.println(tar[2].length);
		
		//2차원 배열 각 방의 값 확인
		for(int i=0; i<tar.length;i++) {
			for(int j=0; j<tar[i].length;j++) {
				System.out.print(tar[i][j]+"   ");
			}
			System.out.println();
		}
	}
	
	//2차원 배열 초기화
	public void testIniTwoArray() {
		int[][] tar = {{1, 2, 3, 4, 5},
					{10, 20, 30, 40},
					{15, 25 ,34}};
		
		System.out.println("행갯수 : "+tar.length);
		
		for(int i=0; i<tar.length; i++) {
			System.out.println(i+"행 -> 방갯수 : "+tar[i].length);
			for(int j=0; j<tar[i].length; j++) {
				System.out.print(tar[i][j]+"  ");
			}
			System.out.println();
		}
	}
}
