

import java.util.*;
import java.io.*;

public class censor {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("censor.in"));
		String result = "";
		String input = in.nextLine();
		String key = in.nextLine();
		System.out.println(key);
		in.close();
		for (int i = 0; i < input.length(); i++) {
			result += input.charAt(i);
			if (result.length() >= key.length()) {
				System.out.println(result.substring(result.length() - key.length()));
			}
			if (result.length() >= key.length() && (result.substring(result.length() - key.length())).equals(key)) {
				result = result.substring(0,result.length() - key.length());
				i -= key.length() + 1;
				System.out.println("removed");
			}
		}

		result = input;

		PrintWriter out = new PrintWriter(new File("censor.out"));
		System.out.println(result);
		out.println(result);
		out.close();
	}
}

/* ANALYSIS



 */