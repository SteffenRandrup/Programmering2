//implements Account
//	private int balance;
//
//	@Override
//	public void deposit(int amount) {
//		balance += amount;
//	}
//
//	@Override
//	public boolean withdraw(int amount) {
//		if (balance - amount < 0) {
//			return false;
//		} else {
//			balance -= amount;
//			return true;
//		}
//	}
//
//	@Override
//	public int getBalance() {
//		return balance;
//	}
//
//	@Override
//	public void yearEnd() {
//		balance = (int) (balance + Math.floor(balance * 0.05));
//	}

//Fee based Account implements Account

//	private int balance;
//	private int transactions;
//	
//	@Override
//	public void deposit(int amount) {
//		balance += amount;
//		transactions++;
//	}
//
//	@Override
//	public boolean withdraw(int amount) {
//		balance -= amount;
//		transactions++;
//		return true;
//	}
//
//	@Override
//	public int getBalance() {
//		return balance;
//	}
//
//	@Override
//	public void yearEnd() {
//		balance -= transactions;
//		transactions = 0;
//	}