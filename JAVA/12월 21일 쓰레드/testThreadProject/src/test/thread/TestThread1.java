package test.thread;

public class TestThread1 {

	public static void main(String[] args) {
		// ��Ƽ������ ���α׷��� �׽�Ʈ 1
		/*Star star = new Star();
		Number number = new Number();
		
		Thread t1 = star;
		Thread t2 = number;*/
		
		//Thread ��� ���� ��쿡 ���
		/*Thread t1 = new Star();
		Thread t2 = new Number();*/
		
		//Runnable ��ӹ��� ���
		/*Runnable star = new Star();
		Runnable number = new Number();
		
		Thread t1 = new Thread(star);
		Thread t2 = new Thread(number);*/
		
		Thread t1 = new Thread(new Star());
		Thread t2 = new Thread(new Number());
		
		//�� �������� �켱 ���� Ȯ��
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
