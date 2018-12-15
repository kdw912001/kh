package wee4.io.silsub;
import java.util.*;
import java.io.*;
public class TestSilsub1 {
	private Scanner sc = new Scanner(System.in);
	public void fileSave() {
		System.out.print("파일명 : ");
		String fileName = sc.next();
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));){
			System.out.print("파일에 저장할 내용을 입력하시오 : ");
			String line = null;
			while(!(line = sc.nextLine()).equals("exit")) {
				bw.write(line + "\n");
			}
			bw.flush();
			System.out.println("파일에 성공적으로 저장되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void fileRead() {
		System.out.print("읽을 파일명 : ");
		String fileName = sc.next();
		
		try(BufferedReader br = new BufferedReader(new FileReader(fileName));){
			StringBuilder sb = new StringBuilder();
			String line = null;
			while((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			System.out.println("파일의 내용은 다음과 같습니다.");
			System.out.println(sb.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//입출력 실습문제1
		TestSilsub1 test1 = new TestSilsub1();
		//test1.fileSave();
		test1.fileRead();
	}
}
