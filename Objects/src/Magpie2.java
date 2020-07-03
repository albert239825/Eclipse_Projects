/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 * 		    Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
import java.util.*;

public class Magpie2
{
	/**
	 * Get a default greeting 	
	 * @return a greeting
	 */
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}
	
	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		String response = "";
		
		ArrayList<String> words = new ArrayList<>(); //This arraylist will be for detection and will be all lower case
		ArrayList<String> original = new ArrayList<>(); //This arraylist will for be println statements so that if, in the example, the user inputs Math Class, it will print out Math Class instead of math class
		int loc = 1;
		int last = 0;
		while (loc < statement.length() && loc > 0) {
			loc = statement.indexOf(' ', loc) + 1;
			//System.out.println(loc);
			if (loc > 0) { //Seperate statement into arraylist
				String word = statement.substring(last, loc - 1); //separate string by spaces
				if (!(word.charAt(word.length() - 1) >= 'a' && word.charAt(word.length() - 1) <= 'z') 
						&& !(word.charAt(word.length() - 1) >= 'A' && word.charAt(word.length() - 1) <= 'Z')) { //Reason for this omega long if statement is because I need two arraylists, one with user inputed capitals and one for the if statement detections 
					word = word.substring(0, word.length() - 1); //removes last character if not a letter
				}
				if (!(word.charAt(0) >= 'a' && word.charAt(0) <= 'z') 
						&& !(word.charAt(0) >= 'A' && word.charAt(0) <= 'Z')) { 
					System.out.println(word.charAt(0));
					word = word.substring(1, word.length()); //This removes the first character if it is not a letter. This is so that exclaimation points and commas don't count 
				}
				original.add(word);
				word = word.toLowerCase(); //makes lower case
				if (word.charAt(word.length() - 1) == 's'){
					word = word.substring(0, word.length() - 1);
				}
				words.add(word); 
			}
			
			else {
				String word = statement.substring(last, statement.length());
				if (!(word.charAt(word.length() - 1) >= 'a' && word.charAt(word.length() - 1) <= 'z') 
						&& !(word.charAt(word.length() - 1) >= 'A' && word.charAt(word.length() - 1) <= 'Z')) {
					//System.out.println(word.charAt(word.length() - 1));
					word = word.substring(0, word.length() - 1); //This removes the last character if it is not a letter. This is so that exclaimation points and commas don't count 
				}
				if (!(word.charAt(0) >= 'a' && word.charAt(0) <= 'z') 
						&& !(word.charAt(0) >= 'A' && word.charAt(0) <= 'Z')) { 
					System.out.println(word.charAt(0));
					word = word.substring(1, word.length()); //This removes the first character if it is not a letter. This is so that exclaimation points and commas don't count 
				}
				
				original.add(word);
				word = word.toLowerCase();
				//System.out.println(word);
				if (word.charAt(word.length() - 1) == 's'){
					word = word.substring(0, word.length() - 1);
				}
				words.add(word);
				
			}
			last = loc;
		}
		
		
		//System.out.println(words);
		//System.out.println(original);
		
		//response selection section
		if (words.contains("no")){
			response = "Why so negative?";
		}
		else if (words.contains("mother")
				|| words.contains("father")
				|| words.contains("sister")
				|| words.contains("brother")) {
			response = "Tell me more about your family.";
		}
		
		else if (words.contains("dog") || words.contains("cat")) {
			response = "Tell me more about your pets. My advice is to keep them away from Chris.";
		}
		
		else if (words.contains("davis") || words.contains("memmo")) {
			response = "Yes teacher man is good";
		}
		
		else if (words.contains("crowley")) {
			response = "Yes she teach very good";
		}
		
		else if (words.contains("bye") && words.size() == 1) {
			response = "Bye";
		}
		else if (words.contains("albert")) {
			response = "Yes I heard he's a bad writer";
		}
		else if (words.contains("chris")) {
			response = "Yes he is big beta";
		}
		
		// Part 2 Section
		else if (words.contains("i") && words.contains("you") && words.indexOf("i") < words.indexOf("you")) { //This chunk is for the I something you part
			System.out.print("Why do you");
			for (int i = words.indexOf("i") + 1; i < words.indexOf("you"); i++) {
				System.out.print(" " + original.get(i));
			}
			System.out.print(" about me?");
		}
		else if (words.contains("i") && words.contains("want") && words.indexOf("i") == words.indexOf("want") - 1) { //This chunk is for the I want something
			System.out.print("Would you be happy if you had");
			for (int i = words.indexOf("want") + 1; i < words.size(); i++) {
				System.out.print(" " +original.get(i));
			}
			
			System.out.print("?");
			
		}
		else if (words.contains("i") && words.contains("like") && words.indexOf("i") == words.indexOf("like") - 1) { //This chunk is for the I like something
			System.out.print("What do you like about");
			for (int i = words.indexOf("like") + 1; i < words.size(); i++) {
				System.out.print(" " + original.get(i));
			}
			System.out.print("?");
		}
		
		
		else{
			response = getRandomResponse();
		}
		return response;
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 6;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";
		
		if (whichResponse == 0)
		{
			response = "Interesting, tell me more.";
		}
		else if (whichResponse == 1)
		{
			response = "Hmmm.";
		}
		else if (whichResponse == 2)
		{
			response = "Do you really think so?";
		}
		else if (whichResponse == 3)
		{
			response = "You don't say.";
		}
		else if (whichResponse == 4) {
			response = "I don't really know";
		}
		else if (whichResponse == 5) {
			response = "Ok";
		}

		return response;
	}
}