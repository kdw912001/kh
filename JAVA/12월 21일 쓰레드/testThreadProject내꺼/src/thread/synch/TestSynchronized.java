package thread.synch;

public class TestSynchronized {

	public static void main(String[] args) {
		// 동기화 테스트
		Thread t1 = new AccountManager("인터넷뱅킹");
		Thread t2 = new AccountManager("체크카드");
		//멘트가 잘 안나오는데 Account에 넣으면 되겠다고 말하심
		t1.start();
		t2.start();
	}

}
