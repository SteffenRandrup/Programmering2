public class AccountTest {
    public static void main(String[] args) {
		Account mySavings = new AccountWithInterest();
		mySavings.deposit(1000);
		assert mySavings.withdraw(200);
		assert !mySavings.withdraw(900);
		mySavings.yearEnd();
		mySavings.deposit(100);
		mySavings.yearEnd();
		assert mySavings.getBalance()==987;
		Account myChecking = new FeeBasedAccount();
		myChecking.deposit(1000);
		assert myChecking.withdraw(200);
		assert myChecking.withdraw(900);
		myChecking.yearEnd();
		myChecking.deposit(100);
		assert myChecking.getBalance()==-4;
	  	try {
		    assert false;
		    System.out.println("Please enable assertions!");
		}
		catch(AssertionError e) {
		    System.out.println("Success!");
	    }
	}
}