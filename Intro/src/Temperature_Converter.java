import java.util.*;
public class Temperature_Converter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean repeat = true;
		System.out.println("Welcome to my temperature converter");
		while (repeat) {
			System.out.println("Type 1 for Celcius to Fahrenheit and type 2 for Fahrenheit to Celcius");
			
			int type = sc.nextInt();
			
			if (type == 1) {
				System.out.println("please input the degress celcius");
				double cel = sc.nextDouble();
				double fah = (9.0/5 * cel) + 32; //Math
				System.out.println(cel + " degress Celcius is equivilent to " + fah + " degress Fahrenheight");
			}
			else if (type == 2) {
				System.out.println("please input the degress Fahrenheight");
				double fah = sc.nextDouble();
				double cel = (fah - 32) * 5/9.0; //Math
				System.out.println(fah + " degress Fahrenheight is equivilent to " + cel + " degress Celcius");
			}
			System.out.println("Would you like to go again? (Yes or No)");
			sc.nextLine(); //Buffer
			String response = sc.nextLine();
			if (response.equals("yes")) {
				
			}
			else {
				repeat = false;
			}
		}
	}
}
