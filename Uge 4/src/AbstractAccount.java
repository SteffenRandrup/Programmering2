
public abstract class AbstractAccount implements Account{
	
	private int balance;
	
	@Override
	public void deposit(int amount) {
		balance += amount;
	}
	
	@Override
	public int getBalance() {
		return balance;
	}
	
}
