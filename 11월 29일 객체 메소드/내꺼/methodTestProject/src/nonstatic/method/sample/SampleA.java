package nonstatic.method.sample;

public class SampleA {
	//Field
	private SampleB sb; //Ŭ���� SampleB �ڷ���+����; ->��������->Ŭ������ ���� ��ü�� �ּ�����
	private int age;	//�⺻�ڷ��� + ����; ->�� ����
	
	//Constructor
	public SampleA() {}
	
	//Method
	public void testMethod() {
		SampleB sp = new SampleB();//new�� ����Ͽ� heap�� ���� ����
		int num;
	}
}
