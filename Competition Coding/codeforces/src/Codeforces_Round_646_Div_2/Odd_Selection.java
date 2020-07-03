package Codeforces_Round_646_Div_2;

import java.util.*;
import java.io.*;

public class Odd_Selection {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		try {
			int t = in.nextInt();
			String[][] numbers = new String[t][];
			int[] n = new int[t];
			int[] x = new int[t];
			for (int l = 0; l < t; l++) {
				n[l] = in.nextInt();
				x[l] = in.nextInt();
				in.nextLine();
				String trial = in.nextLine();
				numbers[l] = trial.split(" ");
			}
			
	//		System.out.println(Arrays.toString(n));
	//		System.out.println(Arrays.toString(x));
	//		System.out.println(Arrays.deepToString(numbers));
			for (int l = 0; l < t; l++) {
				int numOdd = 0;
				boolean work = false;
				
				for (int i = 0; i < numbers[l].length; i++) {
					//System.out.println(numbers[i]);
					int cur = Integer.parseInt(numbers[l][i]);
					if (cur % 2 == 1) {
						numOdd++;
					}
					if (i > x[l] && numOdd % 2 == 1) {
						work = true;
						break;
					}
				}
	
				if (work || numOdd % 2 == 1) {
					out.println("Yes");
				}
				else {
					out.println("No");
				}
				//System.out.println("end: " + l);
	
			}
		}
		catch (Exception e) {
			
		}
	}

	//If odd number of odd numbers, yes
	//If even, check if there is an even number and replace
	//if there are more odds than x and there is one even true;

	//once you get to x, keep going until you have an odd number of odds
}
