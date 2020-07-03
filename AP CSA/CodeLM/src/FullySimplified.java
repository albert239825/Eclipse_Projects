import java.util.*;

public class FullySimplified {

	static Scanner s = new Scanner(System.in);

	// Write a program that is given a minimum year and maximum year that the engineers would like to travel 
	// to and calculates the number of fully simplified fractional time dilations that the time machine would 
	// travel through. These years will both be positive numbers.
	//
	// sample data to copy into input stream
	// 1
	// 5
	//
	// 1
	// 1
	//
	// 11
	// 13
	//
	// 3
	// 6
	//
	// When you are finished, copy and paste the the entire contents of this file into the
	// dashboard to test your algorithm.

	public static void main(String[] args) {
		int low = s.nextInt();                  // the lowest number that could be either the numerator or denominator of the fraction
		int high = s.nextInt();					// the highest number that could be either the numerator or denominator of the fraction 
		
		// code to solve the problem.  You can write and call other methods as well.
		int total = 0;
		for (int n = low; n <= high; n++) {
			for (int d = low; d <= high; d++) {
				if (isSimple(n,d)) {
					total++;
				}
			}
		}

		System.out.println(total);                    // print your answer and just your answer.
	}
	
	static boolean isSimple(int n, int d) {
		return (gcd(n,d) == 1);
	}

	static int gcd(int n, int d) {
		int gcd = 0;
		for (int i = 1; i <= n && i <= d; i++) {
			if (n % i == 0 && d % i == 0) {
				gcd = i;
			}
		}
		return gcd;
	}
}
