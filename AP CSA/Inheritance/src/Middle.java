
public class Middle extends Student{

	
	public Middle(String name, int gradYear) {
		super(name, gradYear);
		this.createUsername(name);
	}
	
	public void getChapel() {
		System.out.println("You go to Chapel: On Even Days");
	}
	
	public void getLunch() {
		super.getLunch();
		System.out.println("3rd block");
	}
	
}
