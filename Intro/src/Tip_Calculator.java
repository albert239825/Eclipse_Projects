import java.util.*;
public class Tip_Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		boolean repeat = true;
		
		System.out.println("Welcome to tip calculator");
		
		while (repeat) {
			System.out.println("Please type in the cost of the bill");
			double cost = sc.nextDouble();
			System.out.println("Please type in the tip percentage");
			int per = sc.nextInt();
			
			double tip = cost * ((double)per/100);
			double total = tip + cost;
			System.out.println("With " + per + "% tip. Your total is " + total + " with " + tip + " dollars tip");
			
			System.out.println("How many people would you like to split this with");
			int people = sc.nextInt();
			if (people == 1) {
				System.out.println("your lonely too. huh. Welp your total is " + total);
			}
			else {
				System.out.println("your per person total is " + (total / people));
			}
			System.out.println("Would you like to calculate another tip? (Yes or No)");
			sc.nextLine();
			String response = sc.nextLine();
			response = response.toLowerCase();
			if (response.equals("yes")) {
				
			}
			else if (response.equals("no")) {
				repeat = false;
				System.out.println("Thanks for using my program and peace");
			}
		}
		

	}

}
