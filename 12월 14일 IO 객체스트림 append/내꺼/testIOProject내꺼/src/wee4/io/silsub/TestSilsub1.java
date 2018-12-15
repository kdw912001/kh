package wee4.io.silsub;
import java.util.*;
import java.io.*;
public class TestSilsub1 {
	private Scanner sc = new Scanner(System.in);
	public void fileSave() {
		FileWriter fw = null;
		BufferedReader br = null;
		System.out.print("파일명 : ");
		String fileName = br.readLine();
		br.readLine();
		try (fw = new FileWriter(fileName); 
				br = new BufferedReader(fw)){
			System.out.print("파일에 저장할 내용을 입력하시오 : ");
			sc.nextLine();
			while(!br.readLine().equals("exit")) {
				br.readLine();
				br.readline
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		

	}

}
