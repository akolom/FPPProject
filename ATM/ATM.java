
public class ATM {
	
	private boolean userAuthenticated;
	private int currentAccountNumber;
	private Screen screen;
	private Keypad keypad;
	private CashDispenser cashDispenser;
	private DepositSlot depositSlot;
	private BankDatabase bankDatabase;
	
	
	private static final int BALANCE_INQUIRY = 1;
	private static final int WITHDRAWAL = 2;
	private static final int DEPOSIT = 3;
	private static final int EXIT = 4;
	
	
	public ATM(){
		
		userAuthenticated = false;
		currentAccountNumber = 0;
		screen = new Screen();
		keypad = new Keypad();
		cashDispenser = new CashDispenser();
		depositSlot = new DepositSlot();
		bankDatabase = new BankDatabase();
		}
	
	public void run(){
		
		while(true){
			
			while(!userAuthenticated){
				
				screen.displayMessageLine("\nwelcome");
				authenticateUser();
			}
			performTransaction();
			userAuthenticated = false;
			currentAccountNumber = 0;
			screen.displayMessageLine("\ngoodbye");
		}
	
			
}
	   
	private void authenticateUser(){
		
		screen.displayMessage("\nenter ur account number");
		int accountNumber = keypad.getInput();
		screen.displayMessage("\nenter pin number");
		int pin = keypad.getInput();
		
		
		userAuthenticated = bankDatabase.authenticateUser( accountNumber, pin);
		
		if(userAuthenticated)
		{
			currentAccountNumber = accountNumber;
		}
		else
			screen.displayMessageLine("invalide accoun number or pi please try again");
		
		}
	
	
	private void performTransaction(){
		
		Transaction currentTransaction = null;
		
		boolean userExited = false;
		
		while(!userExited){
			
			int mainMenuSelection = displayMainMenu();
			
			switch(mainMenuSelection){
			
			case BALANCE_INQUIRY:
			case WITHDRAWAL:
			case DEPOSIT:
				
				
				currentTransaction = creatTransaction(mainMenuSelection);
				
				currentTransaction.execute();
				break;
				
			case EXIT:
				screen.displayMessageLine("\nexit the system....");
				userExited = true;
				break;
			default:
				screen.displayMessageLine("\nyou did not enter valide selection try again");
				break;
			
				}
		}
	}
	
	private int displayMainMenu(){
		
		screen.displayMessageLine("\nmain menu");
		screen.displayMessageLine("1 - view my balance");
		screen.displayMessageLine("2 - withdrawal cash");
		screen.displayMessageLine("3 - deposit fund");
		screen.displayMessageLine("4 - exit");
		screen.displayMessageLine("enter a choice: ");
		return keypad.getInput();
		
	}
	
	private Transaction creatTransaction( int type)
	{
		Transaction temp = null;
		
		switch( type ){
		
		
		case BALANCE_INQUIRY:
			temp = new BalanceInquiry( currentAccountNumber, screen, bankDatabase );
			break;
		case WITHDRAWAL:
			temp = new Withdrawal( currentAccountNumber, screen, bankDatabase, keypad, cashDispenser );
			break;
		case DEPOSIT:
			temp = new Deposit( currentAccountNumber, screen, bankDatabase, keypad, depositSlot );
			break;
			
		
		}
		
		return temp;
		
	
	}

}
