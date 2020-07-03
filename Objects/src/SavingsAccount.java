
public class SavingsAccount extends Account{

	public SavingsAccount(double f, String o) {
		super(f, o);
	}
	
	public void deductFunds(double money) {
		funds -= money;
		funds -= 10;
	}
	
}
