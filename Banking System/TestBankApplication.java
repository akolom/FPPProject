public class TestBankApplication {
	
	public static void main(String[] args) {

		BankApplication wellsfargo = new BankApplication();

		Customer luwam = new Customer("Luwam", "Alem", "123456");
		Customer bereket = new Customer("Bereket", "Tesfatsion", "347289");
		Customer akelom = new Customer("Akolom", "Gebrezgabhier", "767679");

		wellsfargo.addCustomer(luwam);
		wellsfargo.addCustomer(bereket);
		wellsfargo.addCustomer(akelom);

		luwam.setCheckingAccount(new CheckingAccount("ch-0001", 2000.00, "123"));
		luwam.setSavingAccount(new SavingAccount("s-0002", 2100.11, "123"));
		bereket.setCheckingAccount(new CheckingAccount("s-0002", 2100.11, "123"));
		bereket.setSavingAccount(new SavingAccount("s-0002", 2100.11, "123"));
		akelom.setCheckingAccount(new CheckingAccount("s-0002", 2100.11, "123"));
		akelom.setSavingAccount(new SavingAccount("s-0002", 2100.11, "123"));
		System.out.println("Customers in the system is: ");
		wellsfargo.displayReport();
		System.out.println("------------------------------------------------");
		IAccount luwamCheckingAccount = luwam.getCheckingAccount();

		try {
			System.out.println("Luwam's checking account balance: "
					+ luwamCheckingAccount.getBalance());
			luwam.getCheckingAccount().deposit(5000);
			System.out.println("Your balance is : "
					+ luwam.getCheckingAccount().getBalance());
			luwam.getCheckingAccount().withdraw(6500);
		} catch (Exception e) {
			System.out.println("Oh! You don't have a checking account");
		}
		System.out.println("---------------------------------------");
		System.out.println("Searching customer saving balance by social security number: ");
		try{
		System.out.println(wellsfargo.find("123456").getFirstName()+" "+wellsfargo.find("123456").getLastName());
		}catch(NullPointerException e){
			System.out.println("not created this customer in the System: ");
		}
		
		System.out.println("-------------------------------------------");

		System.out.println("Total number of accounts: "
				+ BankApplication.getNumberOfAccounts());
		System.out.println("------------------------------------------------");

		wellsfargo.deleteCustomer(akelom);
		System.out.println("customers after deleting Akolom from list: ");
		wellsfargo.displayReport();
		System.out.println("--------------------------------------------");
		System.out.println("adding new Customer to the System: ");
		Customer cust = wellsfargo.createCustomer();
		wellsfargo.displayReport();
		System.out.println(((AbstractAccount) cust.getCheckingAccount())
				.getPin());
		System.out.println(((AbstractAccount) cust.getCheckingAccount())
				.getAccountNumber());

	}

}
