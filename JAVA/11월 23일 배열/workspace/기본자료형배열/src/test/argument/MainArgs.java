package test.argument;

public class MainArgs {

	public static void main(String[] args) {
		// ���α׷� ����� main()�޼ҵ��
		// ���� ������ �� ����
		//Run Configurations
		//���ʿ� �ڹ� ���ø����̼ǿ� class������ ����Ŭ��
		//argument�� �� �� ��    �Է� �� run
		//�̷��� �ϰ� �����ϸ� args �迭 �ȿ� �Է��� ���� �״�� ������.
		
		//�ٸ� ��� ������ ������ �� �����ϰ������
		//Run Configurations->argument->variable->string_promt->run
		System.out.println("���޹��� ���� ���� : "+args.length);
		
		for(int i=0; i<args.length;i++) {
			System.out.println("args["+i+"]: "+args[i]);
		}
		int num = Integer.parseInt(args[0]);
		double dnum = Double.parseDouble(args[1]);
		char level = args[2].charAt(0);

	}

}
