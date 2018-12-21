package test.thread;

public class TestThread1 {

	public static void main(String[] args) {
		// 멀티스래드 프로그래밍 테스트 1
		/*Star star = new Star();
		Number number = new Number();
		
		Thread t1 = star;
		Thread t2 = number;*/
		
		//Thread 상속 받은 경우에 사용
		/*Thread t1 = new Star();
		Thread t2 = new Number();*/
		
		//Runnable 상속받은 경우
		/*Runnable star = new Star();
		Runnable number = new Number();
		
		Thread t1 = new Thread(star);
		Thread t2 = new Thread(number);*/
		
		Thread t1 = new Thread(new Star());
		Thread t2 = new Thread(new Number());
		
		//각 스래드의 우선 순위 확인
		int p1 = t1.getPriority();
		int p2 = t2.getPriority();
		
		//System.out.println("t1 priority : " + p1);
		//System.out.println("t2 priority : " + p2);
		
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		
		t1.start();
		t2.start();

	}

}
