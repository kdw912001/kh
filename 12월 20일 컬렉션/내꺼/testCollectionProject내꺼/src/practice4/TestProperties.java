package practice4;

import java.util.*;
import java.io.*;
import practice4.Student;
public class TestProperties {

	public Student[] readFile() {
		Properties prop = new Properties();
		Student[] s= new Student[4];
		
		try {
			prop.load(new FileReader("score.txt"));
			prop.list(System.out);
			
			Set<String> keys = prop.stringPropertyNames();
			Iterator<String> keyIter = keys.iterator();
			
			System.out.println(keys);
		
			for(int i=0; i<s.length;i++) {
				s[i]=new Student();
			}
			int i=0;
			String[] str;
			while(keyIter.hasNext()) {
				String key = keyIter.next();
				String value = prop.getProperty(key);
				
				str = value.split(",");
				int sno = Integer.parseInt(str[0]);
				String sname = str[1];
				int kor = Integer.parseInt(str[2]);
				int eng = Integer.parseInt(str[3]);
				int mat = Integer.parseInt(str[4]);
				int tot = kor+eng+mat;
				int avg = (kor+eng+mat)/3;
				
				s[i] = new Student(sno,sname,kor,eng,mat,tot,avg);
				
				i++;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}
	public void printConsole(Student[] sr) {
		int korSum=0;
		int engSum=0;
		int matSum=0;
		for(int i=0; i<sr.length;i++) {
			korSum+=sr[i].getKor();
			engSum+=sr[i].getEng();
			matSum+=sr[i].getMat();
		}
		System.out.println("국어합계 : "+korSum);
		System.out.println("영어합계 : "+engSum);
		System.out.println("수학합계 : "+matSum);
		System.out.println("국어평균 : "+korSum/4);
		System.out.println("수학평균 : "+engSum/4);
		System.out.println("수학평균 : "+matSum/4);	
	}
	public void saveXMLFile(Student[] sr) {
		Properties prop = new Properties();
		
		for(Student s:sr)
			prop.setProperty(String.valueOf(s.getSno()), s.toString());
		
		try {
			prop.storeToXML(new FileOutputStream("student.xml"), "학생 성적 결과","UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		TestProperties test = new TestProperties();
		test.printConsole(test.readFile());
		test.saveXMLFile(test.readFile());
	}
}
