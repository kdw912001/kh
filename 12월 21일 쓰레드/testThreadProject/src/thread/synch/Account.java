package thread.synch;

public class Account {
	//�ܾ� ��Ͽ�
	private static int balance;
	
	public Account() {}
	
	//�ܾ� �����(��ݿ�) �޼ҵ�
	public synchronized void withDraw(int money) {
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(balance >= money)
			balance -= money;
	}

	public int getBalance() {
		return this.balance;
	}
	
	public void setBalance(int money) {
		balance += money;
	}
}






