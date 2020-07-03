import java.util.*;

public class serverTraining1 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in); 
		System.out.print("Enter vault password: ");
		String userInput = sc.next();
		String input = userInput.substring("EACTF{".length(),userInput.length()-1);
		System.out.println(input);
		if (checkPassword(input)) {
			System.out.println("Access granted.");
		} else {
			System.out.println("Access denied!");
		}
	}

	// The password is below. Is it safe to put the password in the source code?
	// What if somebody stole our source code? Then they would know what our
	// password is. Hmm... I will think of some ways to improve the security
	// on the other doors.
	//
	// -Minion #9567
	public static boolean checkPassword(String password) {
		return password.equals("w4rm1ng_Up_w1tH_jAv4_ezxj,hf^&$");
	}
}
