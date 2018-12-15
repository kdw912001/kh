package test.exception;

import java.io.*;

public class TestTryCatch {

	public void fileRead() {
		//sample.txt ������ ������ �о
		//�ֿܼ� ����ϴ� �޼ҵ�
		
		try {
		FileReader fr = new FileReader("sample.txt");
		int ch;//���� Ÿ���� int�̱� ������
		while((ch = fr.read()) != -1) { //-1�̸� ���� character�� number�� ����.
			System.out.print((char)ch);
		}
		System.out.println("���� �б� �Ϸ�.");
		
		}/*catch(Exception e) {}*/ 
		//�θ� exception�� ���� ���� �ö󰡸� �Ʒ� catch���� ������ �ȵǱ� ������ �Ʒ� cat���� ��� ����
		catch (FileNotFoundException e) {//IO Exception�� �ڼ� exception
			System.out.println("sample.txt ������ �������� �ʽ��ϴ�.");
			System.out.println("�ٽ� �����Ͻʽÿ�");
		}catch(IOException e) {
			System.out.println("���� �б� ���� �߻�...");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// try ~ catch �׽�Ʈ 
		new TestTryCatch().fileRead(); 
		//fileRead()�� static�� �ƴϹǷ� new�� ��ߵǴµ� ���Ͱ��� �����
		//1���� ȣ����.
	}
}
