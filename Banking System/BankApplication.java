import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;

public class BankApplication {
	private HashMap<Integer, Customer> customers;

	public BankApplication() {
		customers = new HashMap<Integer, Customer>();
	}

	public static int getNumberOfAccounts() {
		return CheckingAccount.getNumberOfCheckingAccounts()
				+ SavingAccount.getNumberOfSavingAccounts();
	}

	public void addCustomer(Customer customer) {
		customers.put(customer.getSsn().hashCode(), customer);
	}

	public void deleteCustomer(Customer customer) {
		customers.remove(customer.getSsn().hashCode());
	}

	public void displayReport() {
		for (Entry<Integer, Customer> e : customers.entrySet()) {
			Customer c = e.getValue();
			//System.out.println("Customers in the system is: ");
			System.out.print(c.getSsn() + "--------");
			System.out.println(c.getFirstName() + "  " + c.getLastName() + " "
					+ c.getCheckingAccount().getBalance());
		}
	}

	public Customer find(String ssn) {
		return customers.get(ssn.hashCode());
	}

	protected Customer createCustomer() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your firstname: ");
		String firstname = input.next();
		System.out.println("Enter your lastname: ");
		String lastname = input.next();
		System.out.println("Enter your ssn: ");
		String ssn = input.next();

		Customer cust = new Customer(firstname, lastname, ssn);
		Random random = new Random();
		int pin = Math.abs(random.nextInt(900) + 100);
		int accountNumber = Math.abs(random.nextInt(90000) + 10000);

		cust.setCheckingAccount(new CheckingAccount("ch" + accountNumber, 0.0,
				"" + pin));

		addCustomer(cust);
		input.close();
		return cust;
	}

}
