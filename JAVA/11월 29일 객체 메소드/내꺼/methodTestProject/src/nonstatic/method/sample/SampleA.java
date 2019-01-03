package nonstatic.method.sample;

public class SampleA {
	//Field
	private SampleB sb; //클래스 SampleB 자료형+변수; ->참조변수->클래스에 대한 객체의 주소저장
	private int age;	//기본자료형 + 변수; ->값 저장
	
	//Constructor
	public SampleA() {}
	
	//Method
	public void testMethod() {
		SampleB sp = new SampleB();//new를 사용하여 heap에 공간 마련
		int num;
	}
}
