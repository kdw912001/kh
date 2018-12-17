package test.chario;

import java.io.*;

public class TestByteToCharStream {

	public static void main(String[] args) {
		// ����Ʈ��Ʈ���� ���ڽ�Ʈ������ �ٲٱ�
		// �б�� ��Ʈ������ ������ �� ����
		//�⺻��Ʈ���� InputStream ��
		//������Ʈ���� Reader ��
		
		//Ű���� ��ġ : System.in 
		//public static final InputStream in;
		BufferedReader br = 
			new BufferedReader(
				new InputStreamReader(
						System.in));
		
		System.out.println("�Է��� ���� : ");
		StringBuilder sb = new StringBuilder();
		String str = null;
		try {
			while((str = br.readLine()).equals("exit") == false) {
				sb.append(str + "\n");
			}
			
			System.out.println("--------------------");
			System.out.println(sb.toString());
			System.out.println("--------------------");
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}

	}

}





