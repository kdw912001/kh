package method.run;

public class TestRecursiveCall {
	
	//���丮�� ���ϱ� : ���ȣ�� �޼ҵ�
	//5! = 5*4*3*2*1
	public static int fectorial(int num) {
		if(num == 1)
			return 1;
		else 
			return num * fectorial(num - 1);
	}

	public static void main(String[] args) {
		// ���ȣ�� �޼ҵ� �׽�Ʈ
		System.out.println("5! : " + fectorial(5));
	}

}








