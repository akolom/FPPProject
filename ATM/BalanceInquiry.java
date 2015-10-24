

	
	public class BalanceInquiry extends Transaction {
		
		
		
		
		
		public BalanceInquiry(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase){
			
			super( userAccountNumber, atmScreen, atmBankDatabase );
			
			
		}
		@Override
		public void execute(){
			
			BankDatabase bankDatabase = getBankDatabase();
			Screen screen = getScreen();
			
			double availableBalance = bankDatabase.getAvailableBalance(getAccountNumber());
			
			
			double totalBalance = bankDatabase.getTotalBalance(getAccountNumber());
			
			screen.displayMessageLine("\nBalance information: ");
			screen.displayMessage(" - AvailableBalance: ");
			screen.displayDollarAmount(availableBalance);
			screen.displayMessage(" \n - TotalBalance: ");
			screen.displayDollarAmount(totalBalance);
			screen.displayMessageLine( "");
			
		
		}

	}



