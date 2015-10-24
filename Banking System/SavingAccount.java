
public class SavingAccount extends AbstractAccount  {
	private static int numberOfSavingAccounts;

	public SavingAccount(String accountNumber, double balance, String pin) {
		super(accountNumber, balance, pin);
		numberOfSavingAccounts++;
	}

	public static int getNumberOfSavingAccounts() {
		return numberOfSavingAccounts;
	}

	@Override
	public void deposit(double amount) {
		try {
			if (amount <= 0) {
				throw new AccountException(
						"Invalid amount to be deposited. Amount must be > 0.");
			}
			super.setBalance(super.getBalance() + amount);
		} catch (AccountException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void withdraw(double amount) {
		try {
			if (getBalance() - amount < 0) {
				super.setBalance(getBalance() - amount);
				System.out.println("Current balance $" + getBalance());
			} else
				throw new AccountException("Sorry! You don't have sufficient fund");
		} catch (AccountException e) {
			System.out.println(e.getMessage());
		}
	}

}
