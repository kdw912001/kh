package snippet;

public class Snippet {
	public void munjae2(){
			int[][] tar = new int[3][];
			
			Scanner sc = new Scanner(System.in);
			
			//�� �ະ ���� ������ Ű����� �Է¹޾� �Ҵ���
			for(int i = 0; i < tar.length; i++){
				System.out.print(i + "���� ������ �� ���� : ");
				int col = sc.nextInt();
				tar[i] = new int[col];
			}
			
			//1���� 100������ ������ ������ ��� �濡 ���
			for(int i = 0; i < tar.length; i++){
				int sum = 0;
				for(int j = 0; j < tar[i].length; j++){
					tar[i][j] = (int)(Math.random() * 100) + 1;
					sum += tar[i][j]; //�ະ �հ� ó���� �ٷ� ����
				}
				
				//�� �ະ ���� �հ谡 5�� ����� �ุ ���
				if(sum % 5 == 0){				
					System.out.println(i + "�� �հ� : " + sum);
					for(int j = 0; j < tar[i].length; j++){
						System.out.print(tar[i][j] + "\t ");
					}
					System.out.println();
				}
			}
		}
}

