package type.test;

public class TestChar {
	public static void main(String[] args) {
		//���ڰ� ��� Ȯ��
		char ch = 'a'; //97
		char result = (char)(ch +1);
		System.out.println(result + "->" + (int)result);
		
		System.out.println(++result);
		System.out.println('a' - 'A'); // ��ҹ��� ��ȯ 32 �̿�
				
	}
}
