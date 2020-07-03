import java.util.*;


public class LostInTime {

	static Scanner s = new Scanner(System.in);

	// Write a program that finds the Newmerals that are embedded in Max's message and calculates 
	// the year that he is stuck in.
	//
	// sample data to copy into input stream
	// I am in 500 AD dave
	// foLLoW DAVe aND hIS BAd cAb BaC
	// find me you must DAB a lot
	// I want my 2 dollars!
	//
	// When you are finished, copy and paste the the entire contents of this file into the
	// dashboard to test your algorithm.

	public static void main(String[] args) {
		String message = s.nextLine();                 // The message left by Max.
		// code to solve the problem.  You can write and call other methods as well.
		
		String[] word = message.split(" ");
		List<String> words = Arrays.asList(word);
		int total = 0;
		for (int i = words.size() - 1; i>= 0; i--) {
			if (validWord(words.get(i))) {
				total += calculateScore(words.get(i));
			}
		}
		System.out.println(total);                    // print your answer and just your answer.
	}
	
	static boolean validWord(String in) {
		char[] cur = in.toCharArray();
		for (int i = 0; i < cur.length; i++) {
			if (!(cur[i] >= 'a' && cur[i] <= 'd') && !(cur[i] >= 'A' && cur[i] <= 'D')) {
				return false;
			}
		}
		return true;
	}
	
	static int calculateScore(String in) {
		char[] cur = in.toCharArray();
		//System.out.println(Arrays.toString(cur ));
		int total = 0;
		TreeMap<Character, Integer> scores = new TreeMap<>();
		scores.put('a', -1);
		scores.put('b', -10);
		scores.put('c', -100);
		scores.put('d', -1000);
		scores.put('A', 1);
		scores.put('B', 10);
		scores.put('C', 100);
		scores.put('D', 1000);
		
		for (int i = 0; i < cur.length; i++) {
			total += scores.get(cur[i]);
		}
		
		return total;
	}

}
