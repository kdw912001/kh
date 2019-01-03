package wee4.io.silsub;
import java.util.*;
import java.io.*;
public class TestSilsub1 {
	private Scanner sc = new Scanner(System.in);
	public void fileSave() {
		System.out.print("���ϸ� : ");
		String fileName = sc.next();
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));){
			System.out.print("���Ͽ� ������ ������ �Է��Ͻÿ� : ");
			String line = null;
			while(!(line = sc.nextLine()).equals("exit")) {
				bw.write(line + "\n");
			}
			bw.flush();
			System.out.println("���Ͽ� ���������� ����Ǿ����ϴ�.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void fileRead() {
		System.out.print("���� ���ϸ� : ");
		String fileName = sc.next();
		
		try(BufferedReader br = new BufferedReader(new FileReader(fileName));){
			StringBuilder sb = new StringBuilder();
			String line = null;
			while((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			System.out.println("������ ������ ������ �����ϴ�.");
			System.out.println(sb.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//����� �ǽ�����1
		TestSilsub1 test1 = new TestSilsub1();
		//test1.fileSave();
		test1.fileRead();
	}
}
