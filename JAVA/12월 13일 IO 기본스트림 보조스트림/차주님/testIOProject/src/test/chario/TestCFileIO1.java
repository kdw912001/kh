package test.chario;

import java.util.*;
import java.io.*;

public class TestCFileIO1 {
	private Scanner sc = new Scanner(System.in);
	
	public TestCFileIO1() {}
	
	//���ڽ�Ʈ������ ���Ͽ� ���� ó��
	public void fileSave() {
		FileWriter fw = null;
		
		System.out.print("������ ���ϸ� : ");
		String fileName = sc.next();
		
		try {
			fw = new FileWriter(fileName);
			//��� ������ ������ ������ ���� ����
			//��� ������ ������, ���ξ��� ���·� ����
			
			fw.write('A');
			fw.write("java program" + "\n");
			char[] charr = {'a', 'p', 'p', 'l', 'e'};
			fw.write(charr);
			fw.flush();
			
			System.out.println("���� ��� ���� �Ϸ�.");
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	//���ڽ�Ʈ������ ���Ϸ� ���� �о�ͼ�
	//�ֿܼ� ���
	public void fileRead() {
		//FileReader fr = null;
		
		System.out.print("���� ���ϸ� : ");
		String fileName = sc.next();
		
		try(FileReader fr = 
				new FileReader(fileName);) {
			//fr = new FileReader(fileName);
			//������ ������ ������
			
			int readData;
			while((readData = fr.read()) != -1) {
				System.out.print((char)readData);
			}
			
			System.out.println("\n�����б� �Ϸ�.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}/*finally {
			try {
				fr.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}*/
	}
	
	public static void main(String[] args) {
		// ���ڱ�� ��������� �׽�Ʈ
		TestCFileIO1 test = new TestCFileIO1();
		//test.fileSave();
		test.fileRead();

	}

}






