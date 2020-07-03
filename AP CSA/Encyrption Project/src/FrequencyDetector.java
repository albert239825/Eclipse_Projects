import java.util.*;
import java.io.*;

public class FrequencyDetector {
	
	public static void main(String[] args) {
		
		//Creates the encrypted file
		File f = new File("Encrypted Martian.txt"); 
		//Creates file where the decrypted info will go
		File g = new File("Decrypted Martian.txt");
		
		//imports the original file
		File text = new File("/Volumes/GoogleDrive/My Drive/9th Grade/F AP Computer Science A/eclipse-workspace/Encyrption Project/src/The Martian.txt");
		
		Scanner sc = null;
		try {
			sc = new Scanner(text);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//read in entire file
		String content = sc.useDelimiter("\\A").next(); 
		sc.close();
		
		//Chooses a random shift
		int shift = (int) (Math.random() * 26) + 1; 
		
		//System.out.println(shift);
		
		String encrypted = Caesar(content, shift);
		
		//System.out.println(encrypted);
		
		
		
		printInFile(encrypted, f);
		
		//Record the max score
		double bestScore = 0;
		//Record the shift correlating with that score
		int bestShift = 0;
		
		
		
		//Loops through possible shifts and find the best one
		for (int i = 1; i < 27; i++) {
			double score = findScore(encrypted, i);
			if (score > bestScore) {
				bestScore = score;
				bestShift = i;
			}
		}
		
		System.out.println("acutal shift is: " + shift);
		System.out.println("predicted shift is: " + bestShift);
		
		//prints decrypted code into the decrypted file
		printInFile(Caesar(encrypted, -bestShift), g);
		
		
	}
	
	
	public static String Caesar(String password, int shift) {
		String result = "";
		char[] characters = password.toCharArray();
		for (int i = 0; i < characters.length; i++) {
			if ((characters[i] >= 'a' && characters[i] <= 'z') || characters[i] >= 'A' && characters[i] <= 'Z') {
				
				//Becuase Shift can shift character from lowercase to upper case
				boolean cap = (characters[i] <= 'Z');
				//Shift each character by the shift amount
				characters[i] += shift; 
				
				
				//Looping
				if (cap) {
					if (characters[i] > 'Z') {
						//If the char is more than the range, find how much it is over and add that from the min
						characters[i] = (char) ('A' + (characters[i] - 'Z') - 1); //If the char is more than the range, find how much it is over and add that from the min
					}
					
					if (characters[i] < 'A') {
						//If the char is less than the range, find how much it is under and subtract that from the max
						characters[i] = (char) ('Z' - ('A' - characters[i]) + 1);
					}
				}
				else {
					if (characters[i] < 'a') {
						characters[i] = (char) ('z' - ('a' - characters[i]) + 1); 
					}
					if (characters[i] > 'z') {
						characters[i] = (char) ('a' + (characters[i] - 'z') - 1); 
					}
				}
				

			}
			//System.out.println("working 2");
			//System.out.println(i);
			result += characters[i];
		}
		

		
		System.out.println("done caesar");
		return result;
	}
	
	public static double findScore(String encrypted, int shift) {
		int score = 0;
		//Holds the scores for each letter
		double[] scores = {8.2, 1.5, 2.8, 4.3, 12.7, 2.2, 2.0, 6.1, 7.0, 0.2, 0.8, 4.0, 2.4, 6.7, 7.5, 1.9, 0.1, 6.0, 6.3, 9.1, 2.8, 1.0, 2.4, 0.2, 2.0, 0.1};

		//String holding the attempted decrypted code
		String attempt = Caesar(encrypted, -shift);
		//TreeMap holding chars and corresponding freq
		TreeMap<Character, Integer> freq = new TreeMap<>();
		//Char[] holding all chars for the attempted decryption in lower case
		char[] attemptChar = attempt.toLowerCase().toCharArray();
		
		//Put all letters with freq 0 into treemap, makes calculation later easier
		for (int i = 0; i < 26; i++) {
			freq.put((char) ('a' + i), 0);
		}
		//get all chars into a treemap
		for (int i = 0; i < attemptChar.length; i++) {
			if (freq.containsKey(attemptChar[i])) {
				freq.put(attemptChar[i], freq.get(attemptChar[i]) + 1);
			}
		}
		
		//Score detection
		for (char key : freq.keySet()) {
		     //System.out.println("Key: " + key + ". Value: " + freq.get(key));
		     //calculate score based on frequency of letters
		     score += freq.get(key) * scores[key-'a'];
		}
		
		//Checks for words
		//This works but is really slow
//		int words = numOcu(attempt, "and");
//		words += numOcu(attempt, "the");
//		score += 100 * words;
		
		if (attempt.contains("and") ) {
			score += 50000;
		}
		if (attempt.contains("the") ) {
			score += 50000;
		}
		System.out.println(score);
		
		
		
		
		return score;
		
	}
	
	//counts the number of substrings in a string
	
	public static int numOcu(String str, String tar) {
		int lastIndex = 0;
		int count = 0;

		while (lastIndex != -1) {
		    lastIndex = str.indexOf(tar,lastIndex);
		    System.out.println("slowdown");
		    if( lastIndex != -1) {
		    	count++;
		    }

		    lastIndex += tar.length();
		}
		return count;
	}
	
	
	public static void printInFile(String input, File file) {
		FileWriter fileWriter = null;
		try {
			//Appends text to the file instead of overwriting it
			fileWriter = new FileWriter(file,true);
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
