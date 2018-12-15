package test.method;

import java.util.Random;

public class NonStaticSample {
	public NonStaticSample(){}
	
	//1. ��ȯ�� ���� �Ű����� ���� �޼ҵ�
	//���� ��û�� 1~45������ ������ ���� 
	//6�� �ߺ����� �ʰ� �߻����� 
	//����ϴ� �޼ҵ�
	//�޼ҵ�� : printLottoNumbers
	public void printLottoNumbers() {
		int[] lotto = new int[6];
		Random r = new Random();
		
		for(int i = 0; i < lotto.length; i++) {
			lotto[i] = r.nextInt(45) + 1;
			//�ߺ�Ȯ��
			if(i > 0) {
				//������ ��ϵ� ���� ��
				for(int j = 0; j < i; j++) {
					if(lotto[i] == lotto[j]) {
						i--;
						break;
					}
				}
			}
		}
		
		//���ó��
		System.out.print("lotto : ");
		for(int i = 0; i < lotto.length; i++)
			System.out.print(lotto[i] + "   ");
		System.out.println();
	}
	
	//2. ��ȯ�� ���� �Ű����� �ִ� �޼ҵ�
	//���� ��û�� ���� �ϳ�, ���� �ϳ��� 
	//���޹޾� ���ڸ� ���� ������ŭ 
	//����ϴ� �޼ҵ�
	//�޼ҵ�� : outputChar
	public void outputChar(int count, char ch) {
		for(int c = 1; c <= count; c++)
			System.out.print(ch);
		
		System.out.println();
	}
	
	//3. ��ȯ�� �ְ� �Ű����� ���� �޼ҵ�
	//���� ��û�� ���ĺ� ������ ������ �����ڸ� 
	//�ϳ� �߻����� �����ϴ� �޼ҵ�
	//�޼ҵ�� : alphabette
	public char alphabette() {
		//����빮�� : 65(A)~90(Z)
		//����ҹ��� : 97(a)~122(z)
		//91~96 : ��ȣ����
		int rnum;
		Random r = new Random();
		
		while(true) {
			rnum = r.nextInt(122-65+1) + 65;
			
			//if(!(rnum >= 91 && rnum <= 96))
			if(rnum < 91 || rnum > 96)
				break;
		}
		
		return (char)rnum;
	}
	
	//4. ��ȯ�� �ְ� �Ű����� �ִ� �޼ҵ�
	//���� ��û�� ���ڿ��� �����ε���, ���ε����� ���޹޾� �ش� �ε��� ������ ���ڿ���
	//�����Ͽ� �����ϴ� �޼ҵ�. �� ���ڿ��� �ݵ�� ���� �־����. ������ null ����ó��
	//�޼ҵ�� : mySubstring
	public String mySubstring(
		String str, int begin, int end) {
		
		String subStr = null;
		
		if(str != null && str.length() > 0) {
			subStr = "";
			for(int i = begin; i <= end; i++) {
				subStr += str.charAt(i);
			}
		}
		
		return subStr;
	}
}









