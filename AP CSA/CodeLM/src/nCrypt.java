import java.util.*;


public class nCrypt {
	
	static Scanner s = new Scanner(System.in);
	
    public static void main(String[] args) {
		String message = s.nextLine();           // The message that is to be either encrypted or decrypted.

		// code to solve the problem.  You can write and call other methods as well.
		List<String> words = new ArrayList<String> ();
		
		words.add("NWPC");
		words.add("New");
		words.add("Wave");
		words.add("Noah");
		words.add("Rubin");
		words.add("myPhone");
		words.add("smudged");
		words.add("and");
		words.add("or");
		words.add("I");
		words.add("duct");
		words.add("tape");
		words.add("DDOS");
		words.add("spontaneous");
		words.add("combustion");
		words.add("Newmeral");
		int score = 0;
		int bestRot = 0;
		
		for (int i = 1; i < 26; i++) {
			int cur = score(message, i, words);
			if (cur > score) {
				score = cur;
				bestRot = i;
			}
		}
		
		//int cur = score(message, 1, words);
		
		System.out.println(bestRot);

		
	}
    
    static int score(String in , int rot, List<String> words) {
    	int score = 0;
    	char[] letters = in.toCharArray();
    	String roted = "";
    	for (int i = 0; i < letters.length; i++) {
    		if ((letters[i] >= 'a' && letters[i] <= 'z') || (letters[i] >= 'A' && letters[i] <= 'Z')) {
    			roted += (char) (letters[i] - rot);
    		}
    		else {
    			roted += letters[i];
    		}
    	}
    	//System.out.println(roted + " " + rot);
    	
    	ArrayList<String> curW = new ArrayList<> (Arrays.asList(roted.split(" ")));
    	curW = modify(curW);
    	//System.out.println(curW);
    	int streak = 0;
    	int ongoing = 0;
    	for (int i = 0; i < curW.size(); i++) {
    		if (words.contains(curW.get(i))) {
    			streak++;
    			ongoing += curW.get(i).length();
    			//System.out.println("yes");
    		}
    		else {
    			score +=  ongoing*streak;
    			streak = 0;
    			ongoing = 0;
    		}
    	}
    	if (streak != 0) {
    		score +=  ongoing*streak;
    	}
    	//System.out.println(score);
    	return score;
    }
    
    static ArrayList<String> modify (ArrayList<String> words) {
    	ArrayList<String> clone = new ArrayList<> (words);
    	for (int i = 0; i < words.size(); i++) {
    		String cur = clone.get(i);
    		if (cur.substring(cur.length() - 2, cur.length()).equals("'s")) {
    			clone.set(i, cur.substring(0, cur.length() - 2));
    		}
    		
    		else if (cur.substring(cur.length() -1 ).equals(".") || cur.substring(cur.length() -1 ).equals(",")) {
    			clone.set(i, cur.substring(0, cur.length() - 1));
    		}
    	}
    	
    	return clone;
    }

}
