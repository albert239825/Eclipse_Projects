import java.util.*;

public class Fibonotcci {

	static Scanner s = new Scanner(System.in);

	// A Fibonotcci sequence consists of a series of numbers, initially of length n. Each successive term is 
	// calculated by alternatively adding and subtracting the previous n elements, where n is the length of the 
	// original series.
	//
	// sample data to copy into input stream
	// 1 2 3
	// 4
	//
	// -1 11 -2 10
	// 6
	// 
	// 1 -1
	// 6
	//
	// 81 9 3 1 100
	// 8
	//
	// When you are finished, copy and paste the the entire contents of this file into the
	// dashboard to test your algorithm.

	public static void main(String[] args) {
		String[] input = s.nextLine().split(" ");
		int[] starting_sequence = new int[input.length];     // the first n elements in the Fibonotcci sequence
		
		for(int i = 0; i < input.length; i++)
			starting_sequence[i] = Integer.parseInt(input[i]);
		
		int to_find = s.nextInt();                           // the index of the term that you are supposed to find.
		
		// code to solve the problem.  You can write and call other methods as well.
		ArrayList<Integer> queue = new ArrayList<Integer>();
		for (int i = 0; i < input.length; i++) {
			queue.add(starting_sequence[i]);
		}
		int n = queue.size();
		
		//System.out.println("getting there");
		for (int i = n; i < to_find; i++) {
			int next = queue.get(0);
			for (int j = 1; j < n; j++) {
				if (j % 2 == 1) {
					next += queue.get(j);
				}
				else {
					next -= queue.get(j);
				}
				//System.out.println(next);
			}
			queue.remove(0);
			queue.add(next);
			//System.out.println();
		}
		System.out.println(queue.get(queue.size() - 1));                    // print your answer and just your answer.
	}

}
