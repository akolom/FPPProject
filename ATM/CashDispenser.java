
public class CashDispenser {
	
	private final static int INTIAL_COUNT = 500;
	private int count;
	
	public CashDispenser(){
		
		count = INTIAL_COUNT;
		
	}
	public void dispenseCash( int amount ){
		
		int billRequired = amount/20;
		count -= billRequired;
	}
	
	public boolean isSufficientCashAvailable( int amount ){
		 
		int billRequired = amount/20;
		
		if(count >= billRequired)
			return true;
		else
			return false;
		
	}

}
