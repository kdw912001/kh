package make.exception;

public class Calculator {
	public Calculator() {}
	
	public int sum(int a, int b) throws MyException{
		//���� ���� ���� : �� �� ��� �� �ڸ� �������� ��
		int result = 0;
		
		if((a>=1 && a<=9)&&(b>=1&&b<=9)) {
			result = a + b;
		}else {
			//���� �߻� ��Ŵ
			throw new MyException("�� �� ��� ���ڸ� �������� �մϴ�.");
			//throw ����ϴ� ������ �ִٸ� �޼ҵ忡 throws MyException ���
		}
		return result;
	}
	
	public int sub(int a, int b) {
		return a-b;
	}
	public int mul(int a, int b) {
		return a*b;
	}
	public int div(int a, int b) throws MyException{
		int result = 0;
		if(b==0)
			throw new MyException("0���� ���� �� �����ϴ�.");
		//throw ����ϴ� ������ �ִٸ� �޼ҵ忡 throws MyException ���
		else
			result=a/b;
		
		return result;
	}
	

}
