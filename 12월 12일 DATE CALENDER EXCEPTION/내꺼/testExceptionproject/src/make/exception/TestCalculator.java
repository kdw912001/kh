package make.exception;

public class TestCalculator {

	public static void main(String[] args) {
		// ����� ���� ����Ŭ���� �׽�Ʈ
		Calculator calc = new Calculator();
		
		try {
			System.out.println(calc.sum(5, 7));
			System.out.println(calc.sub(12, 4));
			System.out.println(calc.mul(3, 5));
			System.out.println(calc.div(7, 0));
		} catch (MyException e) {
			System.out.println(e.getMessage());
			//MyException �� �ִ� �޽����� �������ؼ�getMessage()
		}
		
		
		
	}

}
