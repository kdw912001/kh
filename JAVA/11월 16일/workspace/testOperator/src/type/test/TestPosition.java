package type.test;

public class TestPosition {

	/*public static void main(String[] args) {
		//�Ǽ����� �Ҽ��� �ڸ��� ����
		double dnum = Math.PI;
		System.out.println("dnum : " + dnum);
		double result = (int)(dnum * 100) / 100.0; //(int)���(int)=(int)�̹Ƿ� 100.0���� ������
															//(int)/(double)������ ���
		System.out.println("result : " + result);
	}*/
	
	public void testLogical2() {
		//�Ϲݳ������� &&, || Ư¡
		//&& : ���� �����̸� �ڸ� �������
		//|| : ���� ���̸� �ڸ� ���� ����
		int num = 12;
		
		boolean result = 100 < 0 && ++num < 0;  //false�� ������ ++num�� ���� �ȵ� 
															//��� num=12
		System.out.println("result : " + result);
		System.out.println("num : " + num);
		
		boolean result2 = 100>0 || ++num<0;  //true�� ������ num=13
		System.out.println("result2 : " + result2);
		System.out.println("num : " +num);
		
	}
}
