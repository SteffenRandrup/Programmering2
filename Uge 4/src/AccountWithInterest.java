public class AccountWithInterest extends AbstractAccount {
	
	
	@Override
	public boolean withdraw(int amount) {
		if (super.getBalance() - amount < 0) {
			return false;
		} else {
			super.deposit(-amount);
			return true;
		}
	}

	@Override
	public void yearEnd() {
		super.deposit((int) Math.floor(super.getBalance()*0.05));
	}	
	
}