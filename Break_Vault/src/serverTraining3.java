import java.util.*;

public class serverTraining3 {

	
	public static void main(String args[]) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter vault password: ");
		String userInput = scanner.next();
		String input = userInput.substring("EACTF{".length(),userInput.length()-1);
		System.out.println(input);
		if (checkPassword(input)) {
			System.out.println("Access granted.");
		} else {
			System.out.println("Access denied!");
		}
	}

	// I came up with a more secure way to check the password without putting
	// the password itself in the source code. I think this is going to be
	// UNHACKABLE!! I hope Dictator Davis agrees...
	//
	// -Minion #8728
	public static boolean checkPassword(String password) {
		return password.length() == 28 &&
				password.charAt(3) == 'i' && 
				password.charAt(5) == '1' && 
				password.charAt(27) == '$' && 
				password.charAt(23) == '_' && 
				password.charAt(24) == 't' && 
				password.charAt(14) == '3' && 
				password.charAt(17) == 'r' && 
				password.charAt(26) == '1' && 
				password.charAt(0) == 'u' && 
				password.charAt(4) == '1' && 
				password.charAt(21) == 'l' && 
				password.charAt(15) == '5' && 
				password.charAt(7) == 'N' && 
				password.charAt(22) == '3' && 
				password.charAt(25) == 'H' && 
				password.charAt(1) == '_' && 
				password.charAt(12) == '_' && 
				password.charAt(10) == '3' && 
				password.charAt(20) == 'b' && 
				password.charAt(13) == 'd' && 
				password.charAt(2) == 'w' && 
				password.charAt(18) == '4' && 
				password.charAt(16) == 'c' && 
				password.charAt(11) == 'R' && 
				password.charAt(8) == '3' && 
				password.charAt(9) == 'V' && 
				password.charAt(19) == 'm' && 
				password.charAt(6) == '_';


	}
}
