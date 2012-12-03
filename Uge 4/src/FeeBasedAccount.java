
public class FeeBasedAccount extends AbstractAccount {

	private int transactions;
	
	@Override
	public void deposit(int amount){
		super.deposit(amount);
		transactions++;
	}
	
	@Override
	public boolean withdraw(int amount) {
		deposit(-amount);
		return true;
	}

	@Override
	public void yearEnd() {
		deposit(-transactions);
		transactions = 0;
	}

}
