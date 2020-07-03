import java.util.*;

public class serverTraining2 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in); 
		System.out.print("Enter vault password: ");
		String userInput = sc.next();
		String input = userInput.substring("EACTF{".length()+4,userInput.length()-5);
		System.out.println(input);
		if (checkPassword(input)) {
			System.out.println("Access granted.");
		} else {
			System.out.println("Access denied!");
		}
	}

	// Okay, so my my predecessor have been like terminated, but this code
	// This is unstoppable, those foolz got nothings on mees.
	//
	// -Minion #9572
	public static boolean checkPassword(String password) {
		return password.equals("N00b_pr3v3N710N_l01z");
	}
}
