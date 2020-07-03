

public class EAPerson{

	private String username;
	private String name;

	public EAPerson(){//default constructor
		System.out.println("Default");
		name = "Default Person";
	}

	public EAPerson(String name) { //constructor
		System.out.println("name");
		this.name = name;
	}

	public EAPerson(String name, String uN) { //constructor 
		this.name = name;
		this.username = uN;
	}

	
	public void createUsername(String n){
		username =  n.substring(0,1) +  n.substring(n.lastIndexOf(" ")+ 1);
	}
	
	public String getName() {
		return name;
	}
	
	public void setUN(String UN) {
		this.username = UN;
	}
	
	public String getUN() {
		return username;
	}

	
	public String assetTag() {
		if (hasALaptop()) {
			String asset = username;
			for (int i = 0; i < 4; i++) {
				asset += (int) (Math.random() * 10);
			}
			return asset;
		}
		return null;
	}
	
	public boolean hasALaptop() {
		return true;
	}
	
	
}
