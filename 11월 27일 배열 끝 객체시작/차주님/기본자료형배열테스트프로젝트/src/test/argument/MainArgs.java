package test.argument;

public class MainArgs {

	public static void main(String[] args) {
		// ���α׷� ����� main() �޼ҵ��
		//���� ������ �� ����
		System.out.println("���޹��� ���� ���� : " 
				+ args.length);
		
		for(int i = 0; i < args.length; i++) {
			System.out.println("args[" + i + "] : "
					+ args[i]);
		}
		
		int num = Integer.parseInt(args[0]);
		double dnum = Double.parseDouble(args[1]);
		char level = args[2].charAt(0);
		
		//int result = args[0] * 3;
		
		System.out.println("num : " + (num * 3));
		System.out.println("dnum : " + dnum);
		System.out.println("level : " + level);

	}

}
