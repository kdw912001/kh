package oop.run;

import oop.method.NonStaticSample;

public class NonStaticSampleTest {

	public static void main(String[] args) {
		NonStaticSample nssamp=new NonStaticSample();
		
		System.out.print("�迭�� �ּ� : ");
		System.out.println(nssamp.intArrayAllocateion(5));
		System.out.println();
		
		System.out.println("1~100���� ������ ������ �迭10���� �Է�");
		int[] ar = new int[10];
		for(int i=0; i<ar.length;i++) {
			ar[i]=(int)(Math.random()*100)+1;
		}
		nssamp.display(ar);
		System.out.println();
		
		System.out.println("ù��° ���ڿ� ������ ���� ��ȯ");
		nssamp.swap(ar, 0, 9);
		nssamp.display(ar);
		System.out.println();
		
		System.out.println("�迭 �������� ����");
		nssamp.sortDescendint(ar);
		nssamp.display(ar);
		System.out.println();
		
		System.out.println("�迭 �������� ����");
		nssamp.sortAscending(ar);
		nssamp.display(ar);
		System.out.println();
		
		
		System.out.println(nssamp.countChar("appleeip", 'p'));
		
		System.out.println(nssamp.totalValue(1, 100));
		
		System.out.println(nssamp.pCarAt("apple",4));
		
		System.out.println(nssamp.pConcat("��", "����"));
	}

}
