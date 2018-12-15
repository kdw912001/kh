package make.exception;

public class TestCalculator {

	public static void main(String[] args) {
		// ����� ���� ����Ŭ���� �׽�Ʈ
		Calculator calc = new Calculator();
		
		try {
			System.out.println(calc.sum(5, 7)); //12
			System.out.println(calc.sub(12, 4)); //8
			System.out.println(calc.mul(3, 5)); //15
			System.out.println(calc.div(7, 0));  //catch��
			
		} catch (MyException e) {
			System.out.println(e.getMessage()); //0���� ���� �� �����ϴ�.
		}
	}
}
