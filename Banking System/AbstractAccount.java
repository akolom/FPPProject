
public  abstract class AbstractAccount implements IAccount {

	private String accountNumber;
	private double balance;
	private String pin;
	
	public AbstractAccount() {
		System.out.println("Default constructor of AbstractClass called...");
		this.accountNumber = "";
		this.balance = 0.0;
	}

	public AbstractAccount(String accountNumber, double balance, String pin) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.pin= pin;
	}

	
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	//public abstract void deposit(double amount);

	public abstract void withdraw(double amount);
}
