
public class Supplies implements Expenses {
	private String name;
	private double cost;
	
	Supplies(String n, double c) {
		this.name = n;
		this.cost = c;
	}
	
	public double getExpenses() {
		return cost;
	}
	
	
}
