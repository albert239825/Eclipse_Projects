import java.util.*;
public class WordScrambler {
	public static void main(String[] args) {
		int times = 0;
		//Repeat the program
		int rep = 1;
		while (rep == 1) {
			String input = "";
			Scanner in = new Scanner(System.in);
			System.out.println("How would you like to shuffle: \n1) Default Amount (5)"
					+ "\n2) Custom Amount \n3) Run Trials");
			int res = in.nextInt();
			if (res == 1) {
				times = 5;
			}
			else if (res == 2) {
				System.out.println("how many times?");
				times = in.nextInt();
			}
			
			if (res != 3) {
				//Get String input
				in.nextLine();
				System.out.println("Please Input String");
				input = in.nextLine();
				for (int i = 0; i < times; i++) {
					input = split(input);
					System.out.println("Permutation #" + (i+1) + ": " +input);
				}
			}
			else {
				//random until match
				int total = 0;
				System.out.println("String Length");
				int length = in.nextInt();
				input = generateString(length);
				
				System.out.println("How many trials");
				int trial = in.nextInt();
				for (int i = 0; i < trial; i++) {
					System.out.println("***********Trial " + (i+1) + "**********");
					total += circle(input);
				}
				float average = ((float) total) / trial;
				System.out.println("average: " + average);
			}
			System.out.println("Again? 1 = Yes, 2 = No:");
			rep = in.nextInt();
		}
		System.out.println("bye");
	}
	
	//Generates two numbers within the range
	public static int[] generate (int length) {
		Random rd = new Random();
		int first = rd.nextInt(length - 2);
		int second = rd.nextInt(length - first - 2) + first + 2;
		//System.out.println(first + ", " + second);
		int[] out = new int[] {first, second};
		return out;
	}
	
	//Splits the String 
	public static String split (String in) {
		Random rd = new Random();
		int[] indexes = generate(in.length());
		//Where the string will be split
		int firstCut = indexes[0];
		int secondCut = indexes[1];
		
		//Output String
		String output = "";
		
		//The parts of the String
		String beg = in.substring(0, firstCut);
		String mid = in.substring(firstCut, secondCut);
		String end = in.substring(secondCut);
		
		output = end + mid + beg;
		//Mistake, Random order of strings
//		//Available stuff (makes sure no repeats)
//		ArrayList<Integer> available = new ArrayList<>(Arrays.asList(1,2,3)); 
//		
//		//selection
//		int curInt = 0;
//		int cur = 0;
//		
//		for (int i = 0; i < 3; i++) {
//			//Randomize the order of string parts
//			curInt = rd.nextInt(available.size());
//			cur = available.get(curInt);
//			if (cur == 1) {
//				output += beg;
//				available.remove(curInt);
//			}
//			if (cur == 2) {
//				output += mid;
//				available.remove(curInt);
//			}
//			if (cur == 3) {
//				output += end;
//				available.remove(curInt);
//			}
//		}
//		
		return output;
	}
	
	//Keeps splitting the string until it returns to the original state
	public static int circle(String input) {
		int tries = 1;
		String attempt = input;
		attempt = split(attempt);
		System.out.println("Permutation 1: " + attempt);
		while (!attempt.equals(input)) {
			attempt = split(attempt);
			tries++;
			System.out.println("Permutation " + tries + ": " + attempt);
		}
		return tries;
	}
	
	//returns "abcde" based on length
	public static String generateString(int n) {
		String output = "";
		//TO DO
		//Add transition to uppercase
		for (int i = 0; i < n; i++) {
			//lower case
			if (i < 26) {
				output += (char) ('a'+i);
			}
			if (i >= 26) {
				output += (char) ('a'+i-58);
			}
		}
		return output;
	}
}
