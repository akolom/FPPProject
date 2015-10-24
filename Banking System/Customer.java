
public class Customer {
	private String firstName;
	private String lastName;
	private String ssn;
	private IAccount checkingAccount;
	private IAccount savingAccount;
	
	public Customer(String firstName, String lastName, String ssn) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public IAccount getCheckingAccount() {
		return checkingAccount;
	}

	public void setCheckingAccount(IAccount checkingAccount) {
		this.checkingAccount = checkingAccount;
	}

	public IAccount getSavingAccount() {
		return savingAccount;
	}

	public void setSavingAccount(IAccount savingAccount) {
		this.savingAccount = savingAccount;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	
	

}
