package thread.synch;

public class TestSynchronized {

	public static void main(String[] args) {
		// 동기화 테스트
		Thread t1 = new AccountManager("인터넷뱅킹");
		Thread t2 = new AccountManager("체크카드");
		
		t1.start();
		t2.start();
	}

}
