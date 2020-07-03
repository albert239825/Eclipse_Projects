import java.util.Scanner;

public class VendingMachine {
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		String start = s.nextLine();            // The starting point.
        int n = Integer.parseInt(s.nextLine());
		String[][] path = new String[n][2];					// a nx2 array of connections.
		
		// The following code will read in the connections from the input stream and fill the array.
        for (int i = 0; i < n; i++) {
            path[i] = s.nextLine().split(" ");
        }

		// code to solve the problem.  You can write and call other methods as well.
		
		System.out.println();                     // print your answer and just your answer.
	}
}
