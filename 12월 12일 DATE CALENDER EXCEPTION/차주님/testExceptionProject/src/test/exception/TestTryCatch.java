package test.exception;

import java.io.*;

public class TestTryCatch {

	public void fileRead() {
		//sample.txt ������ ������ �о
		//�ֿܼ� ����ϴ� �޼ҵ�
		
		try {
			FileReader fr = 
				new FileReader("sample.txt");
			
			int ch;
			while((ch = fr.read()) != -1) {
				System.out.print((char)ch);
			}
			
			System.out.println("���� �б� �Ϸ�.");
			
		}catch(FileNotFoundException e) {
			System.out.println("sample.txt ������ �������� �ʽ��ϴ�.");
			System.out.println("�ٽ� �����Ͻʽÿ�.");
		}catch(IOException e) {
			System.out.println("���� �б� ���� �߻�...");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// try ~ catch �׽�Ʈ
		new TestTryCatch().fileRead();
	}

}
