
public class Upper extends Student{
	
	public Upper(String name, int gradYear) {
		super(name, gradYear);
		this.createUsername(name);
	}
	
	public void getChapel() {
		System.out.println("You go to Chapel: On Odd Days");
	}
	
	public void getLunch() {
		super.getLunch(); //Call get lunch method of super class
		System.out.println("Flex & Second Lunch");
	}
	
	public void beard() {
		System.out.println("he has beard");
	}
	
	public void thunderDome() {
		if (this.getGradYear() == 2023) {
			System.out.println("thunda");
		}
	}

}
