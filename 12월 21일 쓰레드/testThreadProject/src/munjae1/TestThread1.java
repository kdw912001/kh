package munjae1;

public class TestThread1 {

	public static void main(String[] args) {
		// �ǽ����� 1
		Thread t1 = new Thread(new Increment(50));
		Thread t2 = new Thread(new Decrement(12, 45));
		
		t1.start();
		t2.start();
	}

}
