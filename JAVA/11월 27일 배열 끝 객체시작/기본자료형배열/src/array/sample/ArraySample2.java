﻿package array.sample;

public class ArraySample2 {
	public void lotto() {
		int[] numbers = new int[6];
		
		for(int i=0; i<numbers.length; i++) {
			numbers[i] = (int)(Math.random()*45)+1;
			
			if(i > 0) {
				//중복 체크 처리
				for(int j=0; j < i; j++) {
					if(numbers[j] == numbers[i]) {
						i--;
						break;
					}
				}
			}
		}
		
		//출력 확인
		
		for(int i=0; i<numbers.length;i++)
			System.out.print(numbers[i]+"  ");
		System.out.println();
		
		//선택정렬 내림차순
		for(int i=0; i<numbers.length-1;i++) {
			for(int j=i+1; j<numbers.length;j++) {
				if(numbers[i]<numbers[j]) {
					int tmp=numbers[i];
					numbers[i]=numbers[j];
					numbers[j]=tmp;
				}
			}
		}
		//내림차순 출력
		for(int i=0; i<numbers.length;i++)
			System.out.print(numbers[i]+"  ");
		
		//선택정렬 오름차순
		for(int i=0; i<numbers.length-1;i++) {
			for(int j=i+1;j<numbers.length;j++) {
				if(numbers[i]>numbers[j]) {
					int tmp = numbers[i];
					numbers[i]=numbers[j];
					numbers[j]=tmp;
				}
			}
		}
		System.out.println();
		//선택정렬 오름차순 출력
		for(int i=0; i<numbers.length;i++)
			System.out.print(numbers[i]+"  ");
	}
	
	public void sortDecending() {
		int[] iar = new int[10];
		
		//값 기록
		for(int i=0; i<iar.length;i++) {
			
			iar[i] = (int)(Math.random()*100)+1;
		}
		
		//정렬전 확인 출력
		System.out.print("iar : ");
		for(int i=0; i<iar.length; i++) {
			System.out.print(iar[i]+"  ");
		}
		System.out.println();
		
		//select sort 방식의 내림차순 정렬 처리
		for(int i=0; i<iar.length-1;i++) {
			for(int j=i+1; j<iar.length;j++) {
				if(iar[i] < iar[j]) {  //부등호만 바꾸면 오름차순 정렬
					int tmp = iar[i];
					iar[i]=iar[j];
					iar[j]=tmp;
				}
			}
		}
		
		//정렬후 확인 출력
		System.out.print("iar : ");
		for(int i=0; i<iar.length; i++) {
			System.out.print(iar[i]+"  ");
		}
		System.out.println();
	}
	
	public void sortAscendint() {
		
		int[] iar = new int[10];
			
		//값 기록
		for(int i=0; i<iar.length;i++) {
			iar[i] = (int)(Math.random()*100)+1;
		}
			
		//정렬전 확인 출력
		System.out.print("iar : ");
		for(int i=0; i<iar.length; i++) {
			System.out.print(iar[i]+"  ");
		}
		System.out.println();
				
		//select sort 방식의 오림차순 정렬 처리
		for(int i=0; i<iar.length-1;i++) {
			for(int j=i+1; j<iar.length;j++) {
					if(iar[i] >  iar[j]) {
						int tmp = iar[i];
						iar[i]=iar[j];
						iar[j]=tmp;
					}
				}
			}
				
			//정렬후 확인 출력
			System.out.print("iar : ");
			for(int i=0; i<iar.length; i++) {
				System.out.print(iar[i]+"  ");
			}
			System.out.println();
	}
	
}
