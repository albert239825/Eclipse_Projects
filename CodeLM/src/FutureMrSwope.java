import java.util.*;

public class FutureMrSwope {

	static Scanner s = new Scanner(System.in);

	// Fax numbers are ten digits long. Future Mr. Swope has agreed to always fax from a number
	// whose last five digits are each divisible by the same number, excluding 1. The sum of all 
	// ten digits also must be divisible by this same number. Lastly the final five digits must be 
	// in non-decreasing order.
	//
	// sample data to copy into input stream
	// 3742824468
	//
	// 3549633693
	//
	// 1673434868
	//
	// 2322155555
	//
	// When you are finished, copy and paste the the entire contents of this file into the
	// dashboard to test your algorithm.

	public static void main(String[] args) {
		String Number = s.nextLine();	// a ten digit fax number
				
		long faxNumber = Long.parseLong(Number);
		// code to solve the problem.  You can write and call other methods as well.
		faxNumber %= 100000;
		int[] digits = new int[5];
		
		for (int i = 4; i >= 0; i--) {
			digits[i] = (int) faxNumber % 10;
			faxNumber /= 10;
			//System.out.println(faxNumber);
		}
		
		//System.out.println(Arrays.toString(digits));

		System.out.println(real(digits));                    // print your answer and just your answer.
	}
	
	static boolean real(int[] digits) {
		for (int i = 0; i < digits.length - 1; i++) {
			if (digits[i] > digits[i + 1]) {
				return false;
			}
		}
		
		//System.out.println("check one");
		for (int j = 2; j <= digits[0]; j++) {
			if (divisBy(digits, j) && sum(digits) % j == 0) {
				return true;
			}
		}
		
		
		return false;
	}
	
	static boolean divisBy (int[] digits, int check) {
		for (int i = 0; i < digits.length; i++) {
			if (digits[i] % check != 0) {
				return false;
			}
		}
		return true;
	}
	
	static int sum (int[] digits) {
		int sum = 0;
		for (int i = 0; i < digits.length; i++) {
			sum += digits[i];
		}
		return sum;
	}

}
