import java.util.Scanner;

public class SmugglingFish {

	static Scanner s = new Scanner(System.in);

	// Write a program that is given a type and amount of fish that they would like to put in 
	// the time machine’s tank and determines if they will fit. If the fish take up exactly 
	// 1500 in3 of space, the output should still be true.

	//
	// sample data to copy into input stream
	// minnow
	// 8
	//
	// shark
	// 3
	//
	// crab
	// 27
	//
	// salmon
	// 56
	//
	// When you are finished, copy and paste the the entire contents of this file into the
	// dashboard to test your algorithm.

	public static void main(String[] args) {
		String fish = s.nextLine();                  // the name of the fish in lowercase that will be in the tank
		int numOfFish = s.nextInt();				 // the number of that type of fish that will be in the tank
									
		boolean fit = false;
		int space = 0;
		// code to solve the problem.  You can write and call other methods as well.
		if (fish.equals("minnow")) {
			space = 12*numOfFish;
		}
		if (fish.equals("shark")) {
			space = 612*numOfFish;
		}
		if (fish.equals("crab")) {
			space = 7 *numOfFish;
		}
		if (fish.equals("salmon")) {
			space = 68* numOfFish;
		}
		
		if (space <= 1500) {
			fit = true;
		}
		
		System.out.println(fit);                    // print your answer and just your answer.
	}

}
