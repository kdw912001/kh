package snippet;

public class Snippet {
	public void munjae2(){
			int[][] tar = new int[3][];
			
			Scanner sc = new Scanner(System.in);
			
			//각 행별 열의 갯수는 키보드로 입력받아 할당함
			for(int i = 0; i < tar.length; i++){
				System.out.print(i + "행이 참조할 열 갯수 : ");
				int col = sc.nextInt();
				tar[i] = new int[col];
			}
			
			//1부터 100사이의 임의의 정수를 모든 방에 기록
			for(int i = 0; i < tar.length; i++){
				int sum = 0;
				for(int j = 0; j < tar[i].length; j++){
					tar[i][j] = (int)(Math.random() * 100) + 1;
					sum += tar[i][j]; //행별 합계 처리를 바로 해줌
				}
				
				//각 행별 열의 합계가 5의 배수인 행만 출력
				if(sum % 5 == 0){				
					System.out.println(i + "행 합계 : " + sum);
					for(int j = 0; j < tar[i].length; j++){
						System.out.print(tar[i][j] + "\t ");
					}
					System.out.println();
				}
			}
		}
}

