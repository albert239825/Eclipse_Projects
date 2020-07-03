import java.util.Scanner;

public class NewWaveTimeMachine {

	static Scanner s = new Scanner(System.in);

	// Write a program that accepts the starting and finishing years for Noah's trip along with 
	// the lengths of each of the five time jumps and returns how many iterations Noah would need to take.
	//
	// sample data to copy into input stream
	// 2016
	// 2110
	// 1
	// 6
	// 3
	// 4
	// 2
	//
	// 2019
	// 2231
	// 4
	// 3
	// 2
	// 4
	// 1
	//
	//
	// When you are finished, copy and paste the the entire contents of this file into the
	// dashboard to test your algorithm.

	public static void main(String[] args) {
		int startingYear = s.nextInt();                  
		int endingYear = s.nextInt();
		int jump1 = s.nextInt();
		int jump2 = s.nextInt();
		int jump3 = s.nextInt();
		int jump4 = s.nextInt();
		int jump5 = s.nextInt();
		
		int[] jumps = new int[] {jump1, jump2, jump3, jump4, jump5};
		double iter = 0;
		int year = startingYear;
		int i = 0;
		
		while (year < endingYear) {
			year += jumps[i];
			//System.out.println(year);
			iter += .2;
			//System.out.println(jumps[i]);
			i++;
			if (i >= 5) {
				i =0;
			}
		}
		
		
		// code to solve the problem.  You can write and call other methods as well.

		System.out.println(iter);                    // print your answer and just your answer.
	}

}
