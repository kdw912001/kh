package day10.input.test;
import java.lang.*;

public class TestCommanLine {
	public static void main(String[] args) {
		String name=args[0];
		char gender=args[1].charAt(0);
		int age = Integer.parseInt(args[2]);
		double height = Double.parseDouble(args[3]);
		double kg = Double.parseDouble(args[4]);
		
		System.out.println("�̸� : "+name);
		System.out.println("���� : "+gender);
		System.out.println("���� : "+age);
		System.out.println("Ű : "+(int)(height*10)/10.0);
		System.out.println("������ : "+(int)(kg*10)/10.0);
	}
}
