package thread.synch;

public class AccountManager extends Thread{
	private Account acc;
	private String type;
	
	public AccountManager() {}
	
	public AccountManager(String type) {
		this.type=type;
	}
	
	@Override
	public void run() {
		acc = new Account();
		acc.setBalance(1000);
		
		while(acc.getBalance()>0) {
			System.out.println("잔액 : "+acc.getBalance());
			int money = new java.util.Random().nextInt(10) * 100;
			//0,100,200,300,400,500,600,700,800,900
			System.out.println(type + "이 인출할 금액 : " + money);
			acc.withDraw(money);
			
		}
	}
}
