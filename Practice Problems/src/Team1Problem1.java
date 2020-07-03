import java.util.*;
import java.io.*;

public class Team1Problem1 {
	public static void main(String[] args) throws FileNotFoundException {
		int[] sides = new int[3];
		int total = 0;
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			int cur = in.nextInt();
			sides[i] = cur;
			total += cur;
		}
		in.close();
		
		if (total != 180) {
			System.out.println("Error");
		}
		else if (sides[0] == sides[1] && sides[1] == sides[2] && sides[0] == sides[2]) {
			System.out.println("Equilateral");
		}
		else if (sides[0] == sides[1] || sides[1] == sides[2] || sides[0] == sides[2]){
			System.out.println("Isosceles");
		}
		else {
			System.out.println("Scalene");
		}

		int result = 0;
	}
}
