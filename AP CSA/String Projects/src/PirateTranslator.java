import java.util.*;
public class PirateTranslator {
	static ArrayList<String> triggers;
	static ArrayList<String> references;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("please type in input");
		String input =  in.nextLine();
		
		triggers = new ArrayList<>(Arrays.asList("hello", "sir", "madam", "officer", "stranger", 
				"where", "is", "the", "my", "your", "restaurant", "hotel"));
		
		references = new ArrayList<>(Arrays.asList("ahoy", "matey", "proud beauty", "foul blaggart", "scurvy dog", 
				"whar", "be", "th'", "me", "yer", "galley", "fleabag inn"));
		
		String[] splited = input.split(" ");
		ArrayList<String> words = new ArrayList<>(Arrays.asList(splited));
		//send words to the piratize function
		piratize(words);
		
		//combine words back to a single string
		String output = "";
		for (int i = 0; i < words.size(); i++) {
			output += words.get(i) + " ";
		}
		System.out.println(output);
	}
	
	//Piratize a arraylist of words
	public static void piratize(ArrayList<String> words) {
		for (int i = 0; i < words.size(); i++) {
			//Original String
			String cur = words.get(i);
			//whether there is punctuation at the end of a word
			String punc = "";
			boolean upper = cur.charAt(0) >= 'A' && cur.charAt(0) <= 'Z';
			cur = cur.toLowerCase();
			if (cur.charAt(cur.length() - 1) < 'A') {
				punc = cur.substring(cur.length() - 1, cur.length());
				cur = cur.substring(0, cur.length() - 1);
			}
			
			if (triggers.contains(cur)) {
				int index = triggers.indexOf(cur);
				cur = references.get(index);
				
				//Capitalize first letter
				if (upper) {
					cur = cur.substring(0,1).toUpperCase() + cur.substring(1);
				}
				cur += punc;
			}
			
			words.set(i, cur);
			
			if (punc.equals(".") || punc.equals("!") || punc.equals("?")) {
				if (Math.random() < .5) {
					words.add(i + 1, "Arr!");
					i++;
				}
			}
		}
	}
}
