package test.byteio;

import java.util.*;
import java.io.*;

public class TestFileIO2 {
	private static Scanner sc = new Scanner(System.in);
	
	public static void menu() {
		int no;
		TestFileIO2 test = new TestFileIO2();
		
		do {
			System.out.println("**** ���� �޸��� ****");
			System.out.println();
			System.out.println("1. �� �޸� ��� ����");
			System.out.println("2. �޸� �о����");
			System.out.println("3. ����");
			System.out.print("��ȣ ���� : ");
			no = sc.nextInt();
			
			switch(no){
			case 1: test.fileSave(); break;
			case 2:	test.fileRead(); break;
			case 3:	System.out.println("�޸����� �����մϴ�."); 
					return; //���ο��� ���������� �������� ��������
			default : 	System.out.println("�߸� �Է��ϼ̽��ϴ�.");
						System.out.println("�ٽ� �Է��Ͻʽÿ�.");
			}
		}while(true);	
	}
	public void fileSave() {
		//����Ʈ��� ������½�Ʈ�����
		//���ϸ��� Ű����� �Է¹���
		//����� ������ Ű����� ���ڿ���
		//�Է¹޾Ƽ� ���Ͽ� �����
		//�ݺ� �Է°� ��� ó����
		//���� ���� : "exit" �� �ԷµǸ� ����
		FileOutputStream fout = null;
		System.out.print("���ϸ� �Է� : ");
		String filename = sc.next();
		sc.nextLine(); //������ ����Ű ����
		
		try {
			fout = new FileOutputStream(filename);
			String str = "";
			byte[]b;
			/*���� �Ѱ�
			 * System.out.print("������ �Է� : ");
			while(!str.equals("exit")) {
				
				str = sc.nextLine();
				System.out.print("������ �Է� : ");
				b = str.getBytes();
				fout.write(b);
			}*/
			//���ִԲ�
			System.out.print("���� �Է� : ");
			while(!(str = sc.nextLine()).equals("exit")) {
				System.out.print("���� �Է� : ");
				fout.write(str.getBytes());
			}
		} catch (FileNotFoundException e) {
			System.out.println(filename + " ������ �������� �ʽ��ϴ�.");
		}catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				fout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void fileRead() {
		//����Ʈ��� �����Է½�Ʈ�� ���
		//����� ������ ������ �о
		//�ֿܼ� ��� ó��
		FileInputStream fin= null;
		System.out.print("���� ���ϸ� �Է� : ");
		String filename = sc.next();
		try {
			fin = new FileInputStream(filename);
			int data;
			while((data = fin.read()) != -1) {
				System.out.print((char)data);
			}
			System.out.println();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		// ����Ʈ��� ���� ����� �ǽ�
		menu();

	}

}
