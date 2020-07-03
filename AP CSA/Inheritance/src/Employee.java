
public class Employee extends EAPerson{
	
	
	public Employee (String name) {
		super(name);
		super.createUsername(name);

	}
	
	public boolean hasALaptop() {
		return true;
	}
	
	
	
	
	
}
