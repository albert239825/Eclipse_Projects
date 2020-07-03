import java.util.*;

public class newWAveCAse {

	static Scanner s = new Scanner(System.in);

	// Given a string in various variable naming conventions, output that string in newWAveCAse. 
	// newWAveCAse is the practice of writing identifiers such that each word or abbreviation phrase, 
	// other than the first word, begins with two capital letters, with no intervening spaces or 
	// punctuation. The first word starts with a lowercase letter. For example, "Noah Rubin Salary"
	// in newWAveCAse would be written noahRUbinSAlary.

	//
	// sample data to copy into input stream
	// A_Variable_Name
	//
	// noah_rubin
	//
	// newWaveComputers
	//
	// _timeTravel
	//
	// TimeMachineWizard
	//
	// NEW_WAVE
	//
	// When you are finished, copy and paste the the entire contents of this file into the
	// dashboard to test your algorithm.
	
	static boolean cap = false;
	static boolean newWord = false;

	public static void main(String[] args) {
		String input = s.nextLine();                  // The string that needs to be converted.
		List<String> words = new ArrayList<>();
		if (input.charAt(0) == '_') {
			input = input.substring(1);
		}
		
		if (input.contains("_")) {
			input = input.toLowerCase();
			words = Arrays.asList(input.split("_"));
		}
		else {
			int prev = 0;
			for (int i = 1; i < input.length(); i++) {
				char cur = input.charAt(i);
				if (Character.isUpperCase(cur)) {
					words.add(input.substring(prev, i).toLowerCase());
					prev = i;
				}
			}
			words.add(input.substring(prev, input.length()).toLowerCase());
		}
		
		String output = " ";
		for (int i = 0; i < words.size(); i++) {
			if (i == 0) {
				output += words.get(i);
			}
			else {
				String cur = words.get(i);
				cur = cur.substring(0,2).toUpperCase() + cur.substring(2, cur.length());
				output += cur;
			}
		}
		
		//System.out.println(Arrays.toString(words.toArray()));
		System.out.println(output);                // print your answer and just your answer.
	}

}
