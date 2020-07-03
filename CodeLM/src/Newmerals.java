import java.util.Scanner;

public class Newmerals {

    static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		String newmeralA = s.next();              // The first newmeral.
		String newmeralB = s.next();              // The second newmeral.
		char operator = s.next().charAt(0);       // The operator, ':', '^' or '%'.

		// code to solve the problem.  You can write and call other methods as well.
		
		if (operator == ':') {
			System.out.println(colon(newmeralA, newmeralB));
		}
		if (operator == '^') {
			if (newmeralA.length() < newmeralB.length()) {
				System.out.println(prom(newmeralA, newmeralB));
			}
			else {
				System.out.println(prom(newmeralB, newmeralA));
			}
		}
		if (operator == '%') {
			System.out.println(mirror(newmeralA, newmeralB));
		}
		
		System.out.println();  // print your answer and just your answer.
	}
	
	static String mirror (String b, String a){
		String output = "";
		for (int i = a.length(); i > 0; i--) {
			output += a.substring(i - 1, i);
		}
		//System.out.println(output);
		output += b;
		output += a;
		
		return output;
	}
	static String prom(String a, String b) {
		String output = "";
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) > b.charAt(i)) {
				output += a.charAt(i);
			}
			else if (a.charAt(i) < b.charAt(i)){
				output += b.charAt(i);
			}
			else if (a.charAt(i) == 'D') {
				output += 'A';
			}
			else {
				output += (char) (a.charAt(i) + 1);
			}
		}
		output += b.substring(a.length(), b.length());
		return output;
	}
	
	static String colon(String a , String b) {
		String output = "";
		int n = Math.min(a.length(), b.length());
		if (a.length() < b.length()) {
			int iter = b.length() / n;
			for (int i = 0 ; i < n; i++) {
				output += a.substring(i, i + 1);
				output += b.substring(i * iter, i * iter + iter);
			}
		}
		else {
			int iter = a.length() / n;
			for (int i = 0 ; i < n; i++) {
				output += a.substring(i*iter, i * iter + iter);
				output += b.substring(i, i+ 1);
			}
		}
		return output;
		
				
	}

}
