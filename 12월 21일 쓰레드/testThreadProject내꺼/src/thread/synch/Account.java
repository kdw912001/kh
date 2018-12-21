package thread.synch;

public class Account {
	//잔액 기록용
	private static int balance;
	
	public Account() {}
	
	//잔액 인출용(출금용) 메소드
	public synchronized void withDraw(int money) {
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(balance >= money)
			balance-=money;
	}
	
	public int getBalance() {
		return this.balance;
	}
	public void setBalance(int money) {
		balance += money;
	}
	
}
