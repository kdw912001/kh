package test.byteio;

import java.util.*;
import java.io.*;

public class TestFileIO {
	private Scanner sc = new Scanner(System.in);
	
	//����Ʈ��� ������½�Ʈ�� Ŭ���� ���
	//������ �ϳ� ����
	//���Ͽ� Ű���� �Է°��� ������� ó��
	public void fileSave() {
		FileOutputStream fout = null;
		
		System.out.print("������ ���ϸ� : ");
		String fileName = sc.next();
		
		try {
			fout = new FileOutputStream(fileName);
			//���ϰ� ���� ���μ����� ����� ��½�Ʈ�� ������
			//���� ��½�Ʈ�� �����ÿ�
			//��� ������ ������, �ڵ�����
			//������ �������
			//��� ������ �����ϸ�, ���� ����
			//������ ����鼭 ���ξ��� ���·�
			//������ ���µ�			
			
			//���Ͽ� ������ ��� ó��
			fout.write(65);
			byte[] bar = {74, 65, 86, 65};
			fout.write(bar);
			String str = "oop programming";
			byte[] bstr = str.getBytes();
			fout.write(bstr, 4, 7);
			
			//fout.close();
			//��Ʈ�� �ݳ�
			//���ܰ� �߻��ϵ� ���ϵ�
			//������ �ݳ��ؾ� ��
		} catch (FileNotFoundException e) {
			System.out.println("������ �������� �ʽ��ϴ�.");
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			//���ܰ� �߻��ص� �����ϰ� ����
			//���ܰ� �߻� ���ص� �����ϰ� ����
			try {
				fout.close();
				System.out.println(fileName + "�� ���� �Ϸ�.");
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}
	}
	
	//����Ʈ��� �����Է½�Ʈ�� Ŭ���� ���
	//������ �����͸� �о
	//�ֿܼ� ��� ó��
	public void fileRead() {
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
		// ����Ʈ��Ʈ�� ��������� �׽�Ʈ
		TestFileIO test = new TestFileIO();
		//test.fileSave();
		test.fileRead();

	}

}



