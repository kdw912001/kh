package test.byteio;

import java.util.*;
import java.io.*;

public class TestFileIO {
	private Scanner sc = new Scanner(System.in);
	
	//����Ʈ ��� ������½�Ʈ�� Ŭ���� ���
	//������ �ϳ� ���� 
	//���Ͽ� Ű���� �Է°��� ������� ó��
	public void fileSave() {
		FileOutputStream fout = null; //���� ������ �ϴ� �ʱ�ȭ
		//���� ���۷����� try�ȿ� ����� finally������ �� ��. �׷��� try�� �ۿ� ������.
		
		System.out.print("������ ���ϸ� : "); //���ڴ� txt,  byte�� ��쿣 ���ϸ�.dat
		String fileName = sc.next(); //���ϸ��� ���� ���� �ȵȴٴ°� ��Ģ ���� ������ ���Ǳ���
		
		try {
			fout = new FileOutputStream(fileName);//������ ���ÿ� ���ϰ� ����� ��Ʈ�� �������
			System.out.println(fileName+"�� ����Ϸ�");
			//���ϰ� ���� ���μ����� ����� ��½�Ʈ�� ������.
			//���� ��½�Ʈ�� ���� �ÿ� ��� ������ ������, �ڵ����� ������ �������.
			//��� ������ �����ϸ�, ���� ���� ������ ����鼭 ���ξ��� ���·� ������ ���µ�.
			
			//���Ͽ� ������ ��� ó��
			fout.write(65);
			byte[] bar = {74, 65, 86, 65}; //JAVA
			fout.write(bar);
			String str = "oop programming";
			byte[] bstr = str.getBytes();//public byte[] getBytes()Returns:The resultant byte array
			fout.write(bstr, 4, 7);//4�� �ε������� 7���� wirte->programming
			
			//fout.close();
			//close()�� ��Ʈ�� �ݳ�
			//���ܰ� �߻��ϵ� ���ϵ� ������ �ݳ��ؾ� ��.
			
		} catch(FileNotFoundException e) { 
			//IOException�� �ļ�, catch������ �ڼո��� ��� ��.
			System.out.println("������ �������� �ʽ��ϴ�.");
		} catch(IOException e) {
			e.printStackTrace();
		}finally {
			//���ܰ� �߻��ص� �����ϰ� ����
			//���ܰ� �߻� ���ص� �����ϰ� ����
			try {
				fout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//����Ʈ ��� �����Է½�Ʈ�� Ŭ���� ���
	//������ �����͸� �о 
	//�ֿܼ� ��� ó��
	public void fileRead() {
		FileInputStream fin = null;
		//���� ���۷����� try�ȿ� ����� finally������ �� ��. �׷��� try�� �ۿ� ������.
		
		System.out.print("���� ���ϸ�(*.dat) : ");
		String fileName = sc.next();
		
		try {
			fin = new FileInputStream(fileName);
			//��� ������ ������ ���� ��-FileNotFonudException(OutputStream�� �ٸ�)
			
			int data;
			while((data = fin.read()) != -1) {
				//public int read() throws IOException
				//Returns: the next byte of data, or -1 if the end of the file is reached.
				System.out.println((char)data); //char������ �ٲ������
			}
			System.out.println("\n �б� �Ϸ�");
			
		}catch(FileNotFoundException e ) {
			System.out.println(fileName + " ������ �������� �ʽ��ϴ�.");
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fin.close(); //close�޼ҵ�� IOExcetion
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
