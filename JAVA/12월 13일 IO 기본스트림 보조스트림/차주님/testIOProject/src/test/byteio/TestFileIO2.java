package test.byteio;

import java.util.*;
import java.io.*;

public class TestFileIO2 {
	private static Scanner sc = new Scanner(System.in);
	
	public static void menu() {
		int no;
		TestFileIO2 test = new TestFileIO2();
		
		do {
			System.out.println("*** ���� �޸��� ***");
			System.out.println();
			System.out.println("1. �� �޸� ��� ����");
			System.out.println("2. �޸� �о����");
			System.out.println("3. ����");
			System.out.print("��ȣ ���� : ");
			no = sc.nextInt();
			
			switch(no) {
			case 1:  test.fileSave();  break;
			case 2:  test.fileRead();  break;
			case 3:	System.out.println("�޸����� �����մϴ�.");
			        return;
			default: System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			       System.out.println("�ٽ� �Է��Ͻʽÿ�.");
			}
			
		}while(true);
	}
	
	public void fileSave() {
		//����Ʈ��� ������½�Ʈ�� ���
		//���ϸ��� Ű����� �Է¹���
		//����� ������ Ű����� ���ڿ���
		//�Է¹޾Ƽ� ���Ͽ� �����
		//�ݺ� �Է°� ��� ó����
		//�������� : "exit" �� �ԷµǸ� ������
		FileOutputStream fout = null;
		
		System.out.print("������ ���ϸ� : ");
		String fileName = sc.next();
		sc.nextLine();  //������ ����Ű ����
		
		try {
			fout = new FileOutputStream(fileName);
			
			System.out.println(fileName + "�� ����� ������ �Է��ϼ���.");
			String line = null;
			while(!(line = sc.nextLine()).equals("exit")) {
				fout.write(line.getBytes());
			}
			
			System.out.println("�������� �Ϸ�.");
		} catch (FileNotFoundException e) {
			System.out.println(fileName + " ������ �������� �ʽ��ϴ�.");
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fout.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void fileRead() {
		//����Ʈ��� �����Է½�Ʈ�� ���
		//����� ������ ������ �о
		//�ֿܼ� ��� ó��
		FileInputStream fin = null;
		
		System.out.print("���� ���ϸ�(*.dat) : ");
		String fileName = sc.next();
		
		try {
			fin = new FileInputStream(fileName);
			//��� ������ ������ ���� ��
			
			int data;
			while((data = fin.read()) != -1) {
				System.out.print((char)data);
			}
			
			System.out.println("\n�б�Ϸ�!");
			
		} catch (FileNotFoundException e) {
			System.out.println(fileName + " ������ �������� �ʽ��ϴ�.");
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fin.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// ����Ʈ��� ��������� �ǽ�
		menu();

	}

}
