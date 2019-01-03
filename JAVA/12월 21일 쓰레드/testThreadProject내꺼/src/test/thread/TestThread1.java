package test.thread;

public class TestThread1 {

	public static void main(String[] args) {
		// 멀티스레드 프로그래밍 테스트1
		/*Star star = new Star();
		Number number = new Number();
		
		Thread t1 = star;
		Thread t2 = number;*/
		//이걸 줄여쓰자면
		
		//Thread 상속 받은 경우에 사용
		/*Thread t1 = new Star();
		Thread t2 = new Number();*/
		
		//Runnable 상속받은 경우
		//Thread 클래스의 생성자 매개변수를 Runnable로 사용할 수 있음
		/*Runnable star = new Star();
		Runnable number = new Number();
		Thread t1 = new Thread(star);//매개변수에 Runnable사용
		Thread t2 = new Thread(number);*/
		//이걸 줄이자면
		
		Thread t1 = new Thread(new Star());
		Thread t2 = new Thread(new Number());
		
		//각 스래드의 우선순위 확인
		int p1 = t1.getPriority();
		int p2 = t2.getPriority();
		//System.out.println("t1 priority : " + p1);
		//System.out.println("t2 priority : " + p2);
		
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		//우선순위가 높은게 먼저 수행 됨.
		//하지만 원하는대로 수행되지 않기 때문에 sleep 등을 이용해야 함.
		
		t1.start();
		t2.start();
	
	}
}
