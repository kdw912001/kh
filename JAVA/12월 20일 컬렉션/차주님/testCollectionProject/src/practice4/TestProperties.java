package practice4;

import java.util.*;
import java.io.*;

public class TestProperties {

	public static void main(String[] args) {
		// 컬렉션 실습문제 4
		TestProperties test4 = 
				new TestProperties();
		
		Student[] sr = test4.readFile();
		test4.printConsole(sr);
		test4.saveXMLFile(sr);
	}
	
	public Student[] readFile(){
//		1. Properties 객체 생성하고, score.txt 파일의 내용을 읽어
//		2. 리스트 만듦
		Properties prop = new Properties();
		
		try {
			prop.load(new FileReader("score.txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		3. 키를 사용하여, 객체정보를 Student[] 에 저장하여 리턴함
//		  => ", " 으로 문자열 분리처리		
//		  => 분리된 문자열을 각 자료형 필드의 값으로 형변환 대입 저장함
//		  => 세 과목의 합계와 평균을 구해서 각 필드에 기록함
		Set<String> keys = prop.stringPropertyNames();
		Student[] sr = new Student[keys.size()];
		Iterator<String> keyIter = keys.iterator();
		
		for(int i = 0; keyIter.hasNext(); i++){
			String value = prop.getProperty(keyIter.next());
			String[] values = value.split(",");
			
			int kor = Integer.parseInt(values[2]);
			int eng = Integer.parseInt(values[3]);
			int mat = Integer.parseInt(values[4]);
			int tot = kor + eng + mat;
			int avg = tot / 3;
			
			sr[i] = new Student(Integer.parseInt(values[0]), values[1],
								kor, eng, mat, tot, avg);								
		}
		
		return sr;
	}
	
	public void printConsole(Student[] sr){
		int totKor, totEng, totMat;
		totKor = totEng = totMat = 0;
		
//		1. 전달받은 값 출력
		for(Student s : sr){
			System.out.println(s);
			totKor += s.getKor();
			totEng += s.getEng();
			totMat += s.getMat();
		}
		
//		2. 각 객체의 국어합계, 영어합계, 수학합계를 구하고
//		3. 과목별 평균점수를 출력함
		System.out.println("전체 국어 평균 : " + totKor / sr.length);
		System.out.println("전체 영어 평균 : " + totEng / sr.length);
		System.out.println("전체 수학 평균 : " + totMat / sr.length);
	}
	
	public void saveXMLFile(Student[] sr){
//		1. "student.xml" 파일에 번호필드를 key로 객체가 가진 값 기록 저장함.
		Properties prop = new Properties();
		
		for(Student s : sr)
			prop.setProperty(
				String.valueOf(s.getSno()), 
				s.toString());
		
		try {
			prop.storeToXML(
				new FileOutputStream("student.xml"), 
					"학생 성적 결과", "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
