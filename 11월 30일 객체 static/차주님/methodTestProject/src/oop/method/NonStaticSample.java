package oop.method;

//�ǽ� 2
public class NonStaticSample {
	
	public NonStaticSample(){}
	
	//int �Ѱ��� ���ް��� �޾Ƽ�, 
	//�迭�� �ּҸ� �����ϴ� �޼ҵ�
	//ó���� ���� : 
	//���޹��� ���� ������ŭ�� �迭������ 
	//�Ҵ��Ͽ�, ������ 1���� 100������ ������
	//�� ����ϰ� �ּ� ������
	//�޼ҵ� �� : intArrayAllocation
	//�Ű������� �ְ� ��ȯ���� �ִ� �޼ҵ�
	public int[] intArrayAllocation(
			int length) {
		int[] ar = new int[length];
		
		for(int i = 0; i < ar.length; i++)
			ar[i] = (int)(Math.random() * 100) + 1;
		
		return ar;
	}
	

	//�޼ҵ� �� : display
	//�Ű����� �ְ� ��ȯ�� ���� �޼ҵ�
	//ó���� ���� : �迭�� ���޹޾� ȭ�鿡 �����
	public void display(int[] par) {
		System.out.print("�迭���� : ");
		for(int i = 0; i < par.length; i++) {
			System.out.print(par[i] + "  ");
		}
		System.out.println();
	}	
	
	//�޼ҵ�� : swap
	//�Ű����� �ְ� ��ȯ�� ���� �޼ҵ�
	//ó���� ���� : 
	//�迭��, �� ������ �ε����� ���޹޾�
	//	�� �ε����� ���� ��ȯ��
	public void swap(int[] ar, int i, int j) {
		int tmp = ar[i];
		ar[i] = ar[j];
		ar[j] = tmp;
	}
	
	//�޼ҵ�� : sortDescending
	//�Ű����� �ְ� ��ȯ�� ���� �޼ҵ�
	//ó���� ���� : 
	//������ �ۼ��� swap �޼ҵ带 �̿��Ͽ�
	//	�迭�� �� ���� �������� ���� ó����
	public void sortDescending(int[] ar) {
		for(int i = 0; i < ar.length - 1; i++) {
			for(int j = i + 1; j < ar.length; j++) {
				if(ar[i] < ar[j])
					/*this.*/swap(ar, i, j);
			}
		}
	}
	
	
	//�޼ҵ�� : sortAscending
	//�Ű����� �ְ� ��ȯ�� ���� �޼ҵ�
	//ó���� ���� : swap �޼ҵ带 �̿��Ͽ� �迭�� ������ �������� ������
	public void sortAscending(int[] ar) {
		for(int i = 0; i < ar.length - 1; i++) {
			for(int j = i + 1; j < ar.length; j++) {
				if(ar[i] > ar[j])
					/*this.*/swap(ar, i, j);
			}
		}
	}
	
	//1. ���ڿ��� ���� �ϳ��� ���޹޾�, 
	//���ڿ��� ���Ե� ������ ������ 
	//�����ϴ� �޼ҵ�
	//���Ե� ���ڰ� ������ 0 ������
	//�޼ҵ�� : countChar
	public int countChar(String str, char ch) {
		int count = 0;
		
		if(str != null && str.length() > 0) {
			int i = 0;
			while(i < str.length()) {
				if(str.charAt(i) == ch)
					count++;
				
				i++;
			}
		}
		
		return count;
	}
	
	//2. ���� �� ���� ���޹޾�, 
	//�� ���� ���� ������ ū �������� 
	//�������� �հ踦 ���ؼ� �����ϴ� �޼ҵ�
	//�޼ҵ�� : totalValue
	public int totalValue(int first, int second) {
		/*int max = Math.max(first, second);
		int min = Math.min(first, second);
		
		int sum = 0;
		for(int k = min; k <= max; k++)
			sum += k;*/
		
		int sum = 0;
		for(int k = Math.min(first, second); 
				k <= Math.max(first, second); 
				k++)
			sum += k;
		
		return sum;
	}
	
	//���ڿ��� �ε����� ���޹޾�, 
	//�� ��ġ�� ���ڸ� �����ϴ� �޼ҵ�
	//�޼ҵ�� : pCharAt
	public char pCharAt(String s, int index) {
		//return s.charAt(index);
		char ch = '\u0000';
		
		if(s != null && s.length() > 0) {
			char[] arr = s.toCharArray();
			ch = arr[index];
		}
		
		return ch;
	}
	
	//�� ���� ���ڿ��� ���޹޾�, 
	//�ϳ��� ���ڿ��� ���ļ� �����ϴ� �޼ҵ�
	//�޼ҵ�� : pConcat
	public String pConcat(String s1, 
						String s2) {
		return s1 + s2;
	}
}







