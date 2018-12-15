package array.sample;

public class ArraySample2 {
	public void lotto() {
		int[] numbers = new int[6];
		
		for(int i=0; i<numbers.length;i++) {
			numbers[i]=(int)(Math.random()*45)+1;
			
			if(i>0) {
				//�ߺ� üũ ó��
				for(int j=0;j<i;j++) {
					if(numbers[j] == numbers[i]) {
						i--;
						break;
					}
				}
			}
		}
		//�������� ���� ó��
		for(int i=0; i<numbers.length-1;i++) {
			for(int j=i+1;j<numbers.length;j++) {
				if(numbers[i]>numbers[j]) {
					int temp=numbers[i];
					numbers[i]=numbers[j];
					numbers[j]=temp;
				}
			}
		}
		//��� Ȯ��
		for(int i=0; i<numbers.length;i++)
			System.out.print(numbers[i]+"  ");
		System.out.println();
	}
	
	public void sortDecending() {
		int[] iar = new int[10];
		
		//�� ���
		for(int i=0; i<iar.length;i++) {
			iar[i] = (int)(Math.random()*100)+1;
		}
		
		//������ Ȯ�� ���
		System.out.print("iar : ");
		for(int i=0; i<iar.length;i++) {
			System.out.print(iar[i]+" ");
		}
		System.out.println();
		
		//select sort ����� �������� ���� ó��
		for(int i=0; i<iar.length-1;i++) { //step ù �������� �����ϱ� ������ length-1
			for(int j=i+1; j<iar.length;j++) { //ù�������� �����ϰ� ���� ū ���� 
												//������ �ű����� ���� �ܰ踦 ���� i+1
				if(iar[i]<iar[j]) {			//��������
					int tmp = iar[i];
					iar[i]=iar[j];
					iar[j]=tmp;
				}
			}
			
		}
		
		//���� �� Ȯ�� ���
		System.out.print("iar : ");
		for(int i=0; i<iar.length; i++) {
			System.out.print(iar[i]+" ");
		}
	}
	
	public void sortAscending() {
		int[] iar = new int[10];
		//�� ���
		for(int i=0; i<iar.length;i++) {
			iar[i]=(int)(Math.random()*100)+1;
		}
		//���� �� Ȯ�� ���
		System.out.print("iar: ");
		for(int i=0; i<iar.length;i++) {
			System.out.print(iar[i]+" ");
		}
		System.out.println();
		
		//select sort ����� �������� ���� ó��
		for(int i=0; i<iar.length-1;i++) {
			for(int j=i+1;j<iar.length;j++) {
				if(iar[i]>iar[j]) {
					int tmp=iar[i];
					iar[i]=iar[j];
					iar[j]=tmp;
				}
			}
		}
		//���� �� Ȯ�� ���
		System.out.print("iar : ");
		for(int i=0; i<iar.length; i++) {
			System.out.print(iar[i]+" ");
		}
		System.out.println();
	}
}
