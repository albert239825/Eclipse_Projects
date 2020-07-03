import java.util.Scanner;

public class MoleInTheCompany {
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
        int n = Integer.parseInt(s.nextLine());
		int[][] code = new int[n][n];					   // a nxn array of ints.
		
		// The following code will read in the ints from the input stream and fill the 2d array.
        for (int i = 0; i < n; i++) {
            String[] row = s.nextLine().split(" ");
            
            for (int j = 0; j < n; j++) {
                code[i][j] = Integer.parseInt(row[j]);
            }
        }

		// code to solve the problem.  You can write and call other methods as well.
		
		System.out.println();                                 // print your answer and just your answer.
	}
}
