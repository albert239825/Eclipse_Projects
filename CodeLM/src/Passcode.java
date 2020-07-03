import java.util.*;

public class Passcode {

	static Scanner s = new Scanner(System.in);

// Write a program that takes an integer value for the length of the sequence and
// an integer value for the gap size, and outputs the passcode that will open the safe.
// A passcode will always exist.
//
// sample data to copy into input stream
// 20
// 3
//
// 4
// 3
//
// 6
// 5
//
// When you are finished, copy and paste the the entire contents of this file into the
// dashboard to test your algorithm.

	public static void main(String[] args) {
		int gap = s.nextInt();                      // the difference between each prime in the sequence.
		int length = s.nextInt();					// the length of the sequence.

		int[] result = new int[length];
		// code to solve the problem.  You can write and call other methods as well.
		boolean found = false;
		int start = 1;
		while (!found) {
			start++;
			found = test(start, length, gap);
		}
		
		for (int i = 0; i < length; i++) {
			result[i] = start + (gap * i);
			System.out.print(result[i] + " ");
		}
		                  // print your answer and just your answer.
	}
	
	static boolean isPrime(int num) {
		for (int i = 2; i < (num/2); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		//System.out.println(num);
		return true;
	}
	
	static boolean test(int start, int length, int gap) {
		int cur = start;
		for (int i = 0; i < length; i++) {
			//System.out.println(cur);
			if (!isPrime(cur)) {
				return false;
			}
			cur += gap;
		}
		//System.out.println(start);
		return true;
	}

}
