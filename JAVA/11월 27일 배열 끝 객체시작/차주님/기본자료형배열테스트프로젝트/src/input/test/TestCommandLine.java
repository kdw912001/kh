package input.test;

public class TestCommandLine {

	public static void main(String[] args) {
		// 2�����迭 �ǽ����� 3
		String name = args[0];
		char gender = args[1].charAt(0);
		int age = Integer.parseInt(args[2]);
		double height = Double.parseDouble(args[3]);
		double weight = Double.parseDouble(args[4]);
		
		System.out.println("�̸� : " + name);
		System.out.println("���� : " + gender);
		System.out.println("���� : " + age);
		System.out.println("Ű : " + height);
		System.out.println("������ : " + weight);

	}

}
