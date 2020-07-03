import java.util.Scanner;

public class Newber {
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		char[][] map = new char[4][4];
		
        for (int i = 0; i < 4; i++) {
            String line = s.nextLine();
            
            for (int j = 0; j < 4; j++) {
				map[i][j] = line.charAt(j);
            }
        }

		// code to solve the problem.  You can write and call other methods as well.
		
		System.out.println();                     // print your answer and just your answer.
	}
}
