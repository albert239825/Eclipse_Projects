import java.util.*;
import java.io.*;

public class Cryptogram
{
	File f;
	public static void main (String[] args)
	{
		File f = new File("Passwords PLEASE DON'T STEAL.txt");
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PrintWriter pw = new PrintWriter(fileWriter);

		String response = "";
		
		Scanner sc = null;
		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Scanner in = new Scanner(System.in);
		//System.out.println("yes");
		while (!(response.equals("stop"))) {
			System.out.println("Do you want to encrypt or decrypt");
			response = in.nextLine();
			
			if (response.equals("encrypt")) {
				System.out.println("Enter Text to be encrypted");
				String password = in.nextLine();
				System.out.println("Please Input the amount you want to shift");
				int shift = in.nextInt();
				String encrypted = Caesar(password, shift);
				System.out.println(encrypted);
				printInFile(encrypted,f);
			}
			
			else {
				if(sc.hasNextLine()) {
					String password = sc.nextLine(); //gets the encrypted passcode from the file
					System.out.println("What is you shift");
					int shift = in.nextInt();
					password = Caesar(password, -shift); //Decrypts the passcode with a reverse shift
					System.out.println(password);
				}
				
				else {
					System.out.println("No password Currently Saved");
				}
			}
			
			in.nextLine();
			System.out.println("do you want to stop (type stop to stop, anything else to continue)");
			response = in.nextLine();
		}
	}
	
	public static String Caesar(String password, int shift) {
		String result = "";
		char[] characters = new char[password.length()];
		for (int i = 0; i < password.length(); i++) {
			characters[i] = password.charAt(i);
		}
		
		for (int i = 0; i < characters.length; i++) {
			characters[i] += shift; //Shift each character by the shift amount
			if (characters[i] < ' ') {
				characters[i] = (char) ('~' - (' ' - characters[i]) + 1); //If the char is less than the range, find how much it is under and subtract that from the max
			}
			if (characters[i] > '~') {
				characters[i] = (char) (' ' + (characters[i] - '~') - 1); //If the char is more than the range, find how much it is over and add that from the min

			}
		}
		
		for (int i = 0; i < characters.length; i++) {
			result += characters[i];
		}
		
		return result;
	}
	
	public static void printInFile(String input, File f) {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(f,true); //Appends text to the file instead of overwriting it
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PrintWriter pw = new PrintWriter(fileWriter);
		pw.println(input);
		pw.close();
		System.out.println("done");
		
	}
	
	
	
}