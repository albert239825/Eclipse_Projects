import java.util.*;
public class Make_Change {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Random number generation
		double remain;
		int numQ; // number of quarters
		int numD; // number of dimes
		int numN; // number of nickels
		int numP; // number of pennies
		int max = 1900;
		int min = 100;
		int randomNum = (int)(Math.random() * ((max - min) + 1)) + min; //inclusive
		double myNum = randomNum/100.0;
		double change = 20 - myNum;
		// cast into two decimal points
		change = (int) (change * 100);
		change = change / 100;
		System.out.println("Random Number: " + myNum);
		//change = 6.73; test
		
		//Num Quarters
		remain = (change % .25);
		remain = Math.round(remain * 100.0) / 100.0;
		numQ  = (int) (change / .25);
		//Num dimes
		numD  = (int) (remain / .1);
		remain = remain % .1;
		remain = Math.round(remain * 100.0) / 100.0;
		//Num nickels
		numN  = (int) (remain / .05);
		remain = remain % .05;
		remain = Math.round(remain * 100.0) / 100.0;
		//Num pennies
		numP  = (int) (remain / .01);
		
		System.out.println("your change is " + change);
		System.out.println("Quarters: " + numQ);
		System.out.println("Dimes: " + numD);
		System.out.println("Nickels: " + numN);
		System.out.println("Pennies: " + numP);
	}

}
