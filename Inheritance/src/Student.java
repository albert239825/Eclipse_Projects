
// Extends means that Student is the subclass of EAPerson
public class Student extends EAPerson{

	// Private Variable, Cannot be accessed by any other classes
	private int gradYear;
	
	public void getLunch() {
		System.out.println("You go to lunch: ");
	}
	
	
	
	// Default Constructor is ALWAYS CALLED
	// Implicit Call to Super
	public Student(String name, int gradYear){
		super(name);
		this.gradYear = gradYear;
		
	}
	
	public void createUsername(String n){
		String last =n.substring(n.lastIndexOf(" ")+ 1, n.lastIndexOf(" ")+ 5);
		String first = n.substring(0,1);
		String middle = n.substring(n.indexOf(" ") + 1, n.indexOf(" ") + 2);
		String username = last + first + middle + this.gradYear; 
		setUN(username);
	}
	
	//public String returnUN(){
		//return username;  
	//}
	
	public void getChapel() {
		
	}
	
	public int getGradYear() {
		return gradYear;
	}
	public boolean hasALaptop() {
		if (gradYear <= 2027) {
			return true;
		}
		return false;
	}
}