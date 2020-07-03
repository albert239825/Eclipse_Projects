
public class Lower extends Student{
	

	public Lower(String name, int gradYear) {
		super(name, gradYear);
		this.createUsername(name);
	}
	
	public void getChapel() {
		System.out.println("You go to Chapel: On day 1");
	}
	

}
