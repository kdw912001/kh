package io.test;

import java.util.Scanner;
import io.silsub1.MyNote;

public class TestMyNote {

	public static void main(String[] args) {
		// ����� �ǽ�����1
		MyNote note = new MyNote();
		Scanner sc = new Scanner(System.in);
		int no;
		
		do{
		System.out.println("******   MyNote  *******");
		System.out.println();
		System.out.println("1. ��Ʈ ���� �����");		//MyNote�� fileSave()
		System.out.println("2. ��Ʈ ����");		//MyNote�� fileOpen()
		System.out.println("3. ��Ʈ ��� �����ϱ�");	//MyNote�� fileEdit()
		System.out.println("4. ������");		//main() ���� ����
		System.out.println();
		System.out.print("�޴� ���� : ");
		no = sc.nextInt();
		
		switch(no){
		case 1:	note.fileSave();   break;
		case 2:	note.fileOpen();   break;
		case 3:  note.fileEdit();    break;
		case 4:  System.out.println("MyNote ���α׷��� �����մϴ�.");
		        return;
		default:	System.out.println("��ȣ ������ �߸��Ǿ����ϴ�.");
		        System.out.println("�ٽ� �����Ͻʽÿ�.\n");
		}
		
		}while(no != 4);
	}

}
