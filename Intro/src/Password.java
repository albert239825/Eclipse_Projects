import java.util.*;
public class Password {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Requirements
		// At least one cap, number, lower case, symbol
		// length from 8-16;
		// Extra feature: Allow the user to input the number of which type of characters they want
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to my password generator");
		String c = "abcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()`~<>,.;’:[]{}/|_+-=?";
		
		
		// Asking user for inputs and which character and how many
		System.out.println("How many Lowercase Letters do you want? Must be greater than 1, or else, we will just add one to the end");
		int lowers = sc.nextInt();
		
		System.out.println("How many Uppercase Letters do you want? Must be greater than 1, or else, we will just add one to the end");
		int uppers = sc.nextInt();

		System.out.println("How many Numbers Letters do you want? Must be greater than 1, or else, we will just add one to the end");
		int nums = sc.nextInt();
		
		System.out.println("How many Symbols Letters do you want? Must be greater than 1, or else, we will just add one to the end");
		int syms = sc.nextInt();
		
		int length = lowers + uppers + nums + syms;
		String password = "";
		
		//These booleans will tell us after the initial for loop whether we have included all necessary character types
		boolean hasLower = false;
		boolean hasUpper = false;
		boolean hasNum = false;
		boolean hasSym = false;
		//System.out.println("check");
		
		
		
		
		for (int i = 0; i < length; i ++) {
			boolean repeat = true;
			while (repeat) {
				repeat = false; //This location is so that I only have to type it once instead of 4 times
				int choose = (int) (Math.random() * 4) + 1; //randomly picks a type of character to add and then subtracts one from the number of that character we need to add
				if (choose == 1 && lowers > 0) {
					password = password + giveLetter(c);
					hasLower = true;
					lowers--;
				}
				else if (choose == 2 && uppers > 0) {
					password = password + giveLetter(c).toUpperCase();
					hasUpper = true;
					uppers--;
				}
				else if (choose == 3 && nums > 0) {
					password = password + giveNum(c);
					hasNum = true;
					nums--;
				}
				else if (choose == 4 && syms > 0) {
					password = password + giveSym(c);
					hasSym = true;
					syms--;
				}
				else {
					repeat = true;
				}
			}
		}
		
		//This next section checks to see if we have all types of symbols and makes sure that if not, we add them
		if (hasLower == false) {
			password = giveLetter(c);
		}
		if (hasUpper == false) {
			password = giveLetter(c).toUpperCase();
		}
		if (hasNum == false) {
			password = giveNum(c);
		}
		if (hasSym == false) {
			password = giveSym(c);
		}
		System.out.println(password);

	}
	//Gives a letter
	public static String giveLetter (String c) {
		int index = (int) (Math.random() * 26);
		return c.substring(index, index+1);
	}
	//Give a number
	public static String giveNum (String c) {
		int index = (int) (Math.random() * 10) + 26;
		return c.substring(index, index+1);
	}
	//Give Sym
	public static String giveSym (String c) {
		int index = (int) (Math.random() * 30) + 36;
		return c.substring(index, index+1);
	}

}




//This commented out section is the original code without the extra feature

//public static void main(String[] args) {
//	// TODO Auto-generated method stub
//	// Requirements
//	// At least one cap, number, lowercase, symbol
//	// length from 8-16;
//	String c = "abcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()`~<>,.;’:[]{}/|_+-=?";
//	int length = (int) (Math.random() * 5) + 8; //we are only going up to 13 because we could add up to 3 characters later in the code
//	String password = "";
//	
//	//These booleans will tell us after the initial for loop whether we have included all necessary character types
//	boolean hasLower = false;
//	boolean hasUpper = false;
//	boolean hasNum = false;
//	boolean hasSym = false;
//	//System.out.println("check");
//	for (int i = 0; i < length; i ++) {
//		int choose = (int) (Math.random() * 4) + 1; //randomly picks a type of character to add
//		if (choose == 1) {
//			password = AddLower(password, c);
//			hasLower = true;
//		}
//		if (choose == 2) {
//			password = AddUpper(password, c);
//			hasUpper = true;
//		}
//		if (choose == 3) {
//			password = AddNum(password, c);
//			hasNum = true;
//		}
//		if (choose == 4) {
//			password = AddSym(password, c);
//			hasSym = true;
//		}
//	}
//	
//	//This next section checks to see if we have all types of symbols and makes sure that if not, we add them
//	if (hasLower == false) {
//		password = AddLower(password, c);
//	}
//	if (hasUpper == false) {
//		password = AddUpper(password, c);
//	}
//	if (hasNum == false) {
//		password = AddNum(password, c);
//	}
//	if (hasSym == false) {
//		password = AddSym(password, c);
//	}
//	System.out.println(password);
//
//}
