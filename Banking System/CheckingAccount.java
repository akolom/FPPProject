
public class CheckingAccount extends AbstractAccount {
	private final double BalanceMin = 100;
	private static int numberOfCheckingAccounts = 0;

	public static int getNumberOfCheckingAccounts() {
		return numberOfCheckingAccounts;
	}

	public CheckingAccount() {
		super();
	}

	public CheckingAccount(String accountNumber, double balance, String pin) {
		super(accountNumber, balance, pin);
		numberOfCheckingAccounts++;
	}

	@Override
	public void deposit(double amount) {

		try {
			if (amount <= 0) {
				throw new AccountException("Invalid amount to be deposited. Amount must be > 0.");
			}
			super.setBalance(super.getBalance() + amount);
		} catch (AccountException e) {
			System.out
					.println(e.getMessage());
		}
	}

	@Override
	public void withdraw(double amount) {

		try {
			if (getBalance() - amount >= BalanceMin) {
				super.setBalance(getBalance() - amount);
				System.out.println("Current balance $" + getBalance());
				if (getBalance() < 500) {
					System.out.println("Your Balance is getting below 500");
				}
			} else
				throw new AccountException("Sorry! You don't have sufficient fund");
		} catch (AccountException e) {
			System.out.println(e.getMessage());
		}

	}
}
