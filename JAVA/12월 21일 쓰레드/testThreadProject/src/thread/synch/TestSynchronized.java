package thread.synch;

public class TestSynchronized {

	public static void main(String[] args) {
		// ����ȭ �׽�Ʈ
		Thread t1 = new AccountManager("���ͳݹ�ŷ");
		Thread t2 = new AccountManager("üũī��");
		
		t1.start();
		t2.start();
	}

}
