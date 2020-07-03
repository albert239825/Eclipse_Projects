import java.util.*;
public class StoreProgram {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Ask the user what you sell and what the cost is
		System.out.println("What do we sell? (plural)");
		String item = sc.nextLine();

		System.out.println("How much do "+ item + " cost?");

		double cost = sc.nextDouble();
		
		System.out.println("How many days do you want to simulate? ");
		int days = sc.nextInt();
		
		while (days > 0) {
			//Calculate the number of items sold and the total
			//Math.random is exclusively upper bound
			//int sold = 1; //debug for negative items
			int sold = (int) (Math.random() * 25);
			System.out.println("Today you sold " + sold + " " + item + ".");
//			System.out.println(cost);
//			System.out.println(sold); //debugging
			double total = cost * sold;
			total = (int) (total * 100);  //removing unwanted decimal places 
			total = total / 100;
	
			System.out.println("you made $" + total);
	
			
			int max = sold +5;
			int min;
			//making sure min cannot be < 0
			if (sold < 3) {
				min = sold - (int) (Math.random() * sold);
			}
			else {
				min = sold - 3;
			}
			
			int ddSold = (int) (Math.random() * (max-min + 1) + min);
			//System.out.println(ddSold); //debugging
			double ddCost;
			//making sure the cost cannot be < 0
			if (cost < 2) {
				ddCost = cost - (Math.random() * cost);
			}
			else {
				ddCost = cost - (Math.random() * 2);
			}
			double ddTotal = ddSold * ddCost;
			ddTotal = (int) (ddTotal * 100);  //removing unwanted decimal places 
			ddTotal = ddTotal / 100;
	
			System.out.println("Your main competitor is dictator Davis' " + item + " Emporium");
			System.out.println("Today they sold" + " " + ddSold + " " + item + " and they made $" + ddTotal);
	
			if (ddTotal > total) {
				System.out.println("not noice");
			}
			else {
				System.out.println("noice");
			}
			System.out.println(""); // seperating days
			days--; //subtracting days
		}
	}

}

//extra credit
//no negative prices
//no negative items
//two decimals
