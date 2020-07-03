import java.util.*;

public class LotteryNumbers {

	static Scanner s = new Scanner(System.in);

	// Write a program that would compute the next highest integer using the same numbers that are given in a hint. 
	// The number given may already be the largest possible number composed of those digits, in which case the number 
	// should be returned without modification. The hint will be less than 263. Remember that your solution must run 
	// in less than 10 seconds.
	//
	// sample data to copy into input stream
	// 732
	//
	// 981132567
	//
	// 987566554321
	//
	// 9988761
	//
	// 862582347377
	//
	// When you are finished, copy and paste the the entire contents of this file into the
	// dashboard to test your algorithm.

	public static void main(String[] args) {
		long hint = s.nextLong();					 // an integer hint
										
		// code to solve the problem.  You can write and call other methods as well.
		
		long copy = hint;
		ArrayList<Integer> digits = new ArrayList<>();
		while (hint > 0) {
			Long cur = hint % 10;
			//System.out.println(digits);
			digits.add(0, cur.intValue());
			hint /= 10;
		}
		
		//where we are going to start doing the recur
		int stop = 0;
		boolean found = false;
		for (int i = digits.size() - 1; i > 0; i--) {
			//System.out.println(digits.get(i) + " " + digits.get(i-1));
			if (digits.get(i) > digits.get(i-1)) {
				stop = i - 2;
				found = true;
				break;
			}
		}
		
		//System.out.println(stop);
		if (found) {
			ArrayList<Integer> rDigits = new ArrayList<>();
			for (int i = digits.size() - 1; i > stop; i--) {
				rDigits.add(0, digits.get(i));
			}
			
			//System.out.println(rDigits);
			String sTarget = "";
			for (int i = 0 ; i < rDigits.size(); i++) {
				sTarget += rDigits.get(i);
			}
			int target = Integer.parseInt(sTarget);
			int num = recur(rDigits, target, "");
			
			if (num == Integer.MAX_VALUE) {
				num = target;
			}
			String sResult = "";
			for (int i = 0; i <= stop; i++) {
				sResult += digits.get(i);
			}
			sResult += ((Integer) num).toString();
			System.out.println(sResult);
		}
		else {
			System.out.println(copy);
		}
	}

	/*
	 * New Strat: check check digits until they are no longer ascending grab those
	 * digits and find smallest integer larger than target
	 */

	
	static int recur(ArrayList<Integer> remaining, int target, String past) {
		//System.out.println(past);
		if (remaining.size() <= 0) {
			//System.out.println(past);
			return Integer.parseInt(past);
		}
		
		int min = Integer.MAX_VALUE;
		int cur = 0;
		String added = "";
		for (int i = 0; i < remaining.size(); i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>(remaining);
			added = "";
			added = temp.remove(i).toString();
			cur = recur(temp, target, past + added);
			if (cur < min && cur > target) {
				min = cur;
				//System.out.println("match");
			}
		}
		//System.out.println(min);
		return min;
	}

}
