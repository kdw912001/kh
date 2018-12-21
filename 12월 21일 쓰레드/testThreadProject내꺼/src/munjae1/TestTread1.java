package munjae1;

public class TestTread1 {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Increment(50));
		Thread t2 = new Thread(new Decrement(12,45));
		t1.run();
		t2.run();
	}
}
