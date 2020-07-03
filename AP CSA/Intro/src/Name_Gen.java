//Albert Chen
//Please I need the credit. Also that decrypting thang was hard

import java.util.*;
public class Name_Gen {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Type in your First, Middle, and last names");
		String names = sc.nextLine();
		System.out.println("Plese input your graduation year");
		int grad = sc.nextInt();
//		if (grad >= 2000) { //make number the just tens and ones
//			grad -= 2000;
//		}
		grad %= 100;
		int loc = 1;
		int last = 0;
		ArrayList<String> list_Names = new ArrayList<>();
		while (loc < names.length() && loc > 0) {
			loc = names.indexOf(' ', loc) + 1;
			//System.out.println(loc);
			if (loc > 0) { //Seperate names into arraylist
				String curName = names.substring(last, loc - 1);
				list_Names.add(curName); 
			}
			else {
				list_Names.add(names.substring(last, names.length()));
				
			}
			last = loc;
		}
		String first = list_Names.get(0);                                    //						I	I	U	--------|
		String lastN = list_Names.get(list_Names.size()-1);//										N	Z	F			|
		String Middle = "";//																		I	I	F			|
		String last4;//																				T	N				|
		String firstMid = "";//																		I	G				|														
		String Username;//																			A					|
		char firstMidChar = 0;//																	L	S				|
		char firstInitalChar = 0;//																	-	T		--------|
		
		if (list_Names.size() >=3) {
			Middle = list_Names.get(1); //Middle name if there is
		}
		
		
		if (lastN.length() >= 5) {
			last4 = lastN.substring(0,4); //if the last name is more than 4 letters make 4 letters
		}
		else {
			last4 = lastN;
		}
		System.out.println(list_Names);
		String firstInital = first.substring(0,1);
		firstInitalChar = first.charAt(0);
		if (firstInitalChar >= 96) {
			firstInitalChar -= 32; //make uppercase
		}
		
		if (!Middle.equals("")) {
			firstMid = Middle.substring(0,1);//Get first initial of middle
			firstMidChar = Middle.charAt(0);
		}
		
		if (firstMidChar >= 96) {
			firstMidChar -= 32; //make uppercase
		}
		
		if (grad < 10) {
			Username = last4 + firstInitalChar + firstMidChar + "0" + grad; //for 02 and stuff
		}
		else {
			Username = last4 + firstInitalChar + firstMidChar + grad; //formatting
		}
		System.out.println(Username);
		
		int[][][] data = encrypt(Username); //encrypts username and get key
		int[][] encrypted = data[0]; //get encrypted matrix
		int[][] key = data[1]; //get key for matrix
		System.out.println("You encrypted data is" + Arrays.deepToString(encrypted));
		System.out.println("You encrypted key is" + Arrays.deepToString(key));
		String Hope = decrypt(data[0], data[1]);
		//System.out.println(Hope);
		
		
	}
	
	//this function encodes the username and returns a data marix and a key matrix
	public static int[][][] encrypt (String Username) { //encrypts a username a return a int[][] as well as a personal key 
		int[][] key = new int[3][3];
		int[][] encrypted = new int[3][3];
		for (int i = 0; i < encrypted.length; i++) {
			for (int j = 0; j < encrypted[0].length; j++) {
				encrypted[i][j] = 0; //Make sure there are no null values BAD
				key[i][j] = (int) ((Math.random() * 100) + 1); //creates a unique random key everytime
				if (i*3 + j < Username.length()) { //check we are not out of bounds
					encrypted[i][j] = Username.charAt(i*3 + j) * key[i][j]; //i*3 +j find the index of the letter that I want to work with
					//Also creates a unique encrypted data that can only be decrypted with the key
				}
			}
		}
		int[][][] both = new int[2][3][3]; // return type
		both[0] = encrypted;
		both[1] = key;
		return both;
	}
	
	//Decrypts a data matrix given the key matrix
	public static String decrypt (int[][] encrypted, int[][] key) {
		String Username = "";
		for (int i = 0; i < encrypted.length; i++) {
			for (int j = 0; j < encrypted[0].length; j++) {
				if (!(encrypted[i][j] == 0)) {
					char current = (char) (encrypted[i][j] / key[i][j]); //undo's encryption and converts to char
					//System.out.println(current); //debug
					Username += current;//adds char to string
				}
			}
		}
		return Username;
	}
}
