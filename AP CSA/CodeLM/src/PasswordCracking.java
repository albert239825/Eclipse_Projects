import java.util.Scanner;

public class PasswordCracking {
	static Scanner s = new Scanner(System.in);
	static int numz;
	
	public static void main(String[] args) {
		int guess = s.nextInt();              // A five-digit integer.
		int lower = s.nextInt();			  // The lower bound.
		int upper = s.nextInt();			  // The upper bound.
		int answer = s.nextInt();             // The correct password.
		
		numz = 0;
		// code to solve the problem.  You can write and call other methods as well.
		
		if (!Check(guess, answer, lower, upper)) {
			System.out.println("0");
		}
		//System.out.println(numz);
		else {
			int range = upper - lower + 1;
			double prob = Math.pow((1.0/range), numz) * 100;
			
			System.out.println(prob);     
		}// print your answer and just your answer.
	}
	
	static boolean Check(int guess, int answer, int min, int max) {
		String g = guess + "";
		String a = answer + "";
		for (int i = 0 ;  i < a.length(); i++) {
			if (g.charAt(i) == '0') {
				int ex = Integer.parseInt(a.substring(i, i+1));
				if (ex < min || ex > max) {
					return false;
				}
				numz++;
			}
			else if (g.charAt(i) != a.charAt(i)) {
				return false;
			}
		}
		
		return true;
	}
	
	
}
