
public class Deposit extends Transaction {
	
	
	private double amount;
	private Keypad keypad;
	private DepositSlot depositSlot;
	private final static int CANCELLED = 0;
	
	
	public Deposit( int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, 
			Keypad atmKeypad, DepositSlot atmDepositSlot){
		
		super(userAccountNumber, atmScreen, atmBankDatabase);
		
		keypad = atmKeypad;
		depositSlot = atmDepositSlot;
		
	}
	@Override
	public void execute(){
		
		
		BankDatabase bankDatabase = getBankDatabase();
		Screen screen = getScreen();
		
		
		amount = promptForDepositAmount();
		
		if(amount != CANCELLED){
			
			screen.displayMessage("\nPlease insert a deposit envelop containing ");
			screen.displayDollarAmount(amount);
			screen.displayMessageLine(".");
			
			boolean envelopeReceived = depositSlot.isEnvelopReceived();
			
			if(envelopeReceived){
				
				
				screen.displayMessageLine("\nYour envelope has been " + "received. \nNOTE: THE money just deposited will not " 
				+ "be available until we verify the amount of any " + "enclosed cash and your checks clear." );
				
				bankDatabase.credit(getAccountNumber(), amount);
				
				
					}
			else
			{
				screen.displayMessageLine("\nYou did not iser an "+ "envelope, so the ATM has cacelled your transaction.");
				
			}
			
		}
		else
		{
			screen.displayMessageLine("\ncanceling transaction ..");
		}
		
	}
	
	  private double promptForDepositAmount(){
		  
		  Screen screen = getScreen();
		  
		  screen.displayMessage("\nPlease enter a deposit amount in " + "CENTS (or 0 to cancele");
		  int input = keypad.getInput();
		  
		  if(input == CANCELLED )
			  
			  return CANCELLED;
			  
			  else 
			  {
				  return (double) input/100;
			  }
		  }

}
