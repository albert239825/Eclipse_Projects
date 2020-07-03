
public class Customer {
	private String name;
	private int height;
	private int price;

	public Customer (String name, int height) {
		this.name = name;
		this.height = height;
	}

	public String getName() {
		return name;
	}
	public int getHeight() {
		return height;
	}
	
	public void givePrice(int price) {
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
	
	public String toString()
	{
		String output = name + "," + height + ",$" + price;
		for (int i=0; i< (13-name.length()- String.valueOf(price).length()); i++ )
			output = output + " ";
		return output;
	}
}
