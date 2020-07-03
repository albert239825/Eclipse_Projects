import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DMV {

	static Scanner s = new Scanner(System.in);

	// Noah Rubin needs to register the time machine at the DMV. Unfortunately, the DMV is especially busy today, 
	// and he must wait in line with the rest of the disgruntled drivers. Noah would like to offer the person 
	// in the front of the line WaveCoin in exchange for taking their place in the line. In order to do this he 
	// needs to figure out what their name is. 
	//
	// sample data to copy into input stream
	// Jeff
	// J Frank B, L B, J George F, L F
	// 
	// Jeff
	// 
	//
	// Jeff
	// J Hank F, J Anne B
	//
	// When you are finished, copy and paste the the entire contents of this file into the
	// dashboard to test your algorithm.

	public static void main(String[] args) {
		String name = s.nextLine();								// The name of the original person in line.
		String[] input = s.nextLine().split(",");
		String[] actions = new String[input.length];			// An array of actions.
		
		for(int i = 0; i < actions.length; i++)
			actions[i] = input[i].trim();										  
		// code to solve the problem.  You can write and call other methods as well.
		ArrayList<String> line = new ArrayList<>();
		line.add(name);
		
		if (!actions[0].equals("")) {
			for (int i = 0; i < actions.length; i++) {
				String[] steps = actions[i].split(" ");
				
				for(int j = 0; j < steps.length; j++) {
					steps[j] = steps[j].trim();	
					//System.out.println(steps[j]);
				}
//				System.out.println();
				
				
				if (steps[0].equals("J")) {
					String curName = steps[1];
					if (steps[2].equals("F")) {
						line.add(0, curName);
					}
					else {
						line.add(curName);
					}
				}
				else {
					if (steps[1].equals("F")) {
						if (line.size() > 0) {
							line.remove(0);
						}
					}
					else {
						if (line.size() > 0) {
							line.remove(line.size() - 1);
						}
					}
				}
				//System.out.println(line);
			}
			
	
			                  // print your answer and just your answer.
		}
		if (line.size() > 0) {
			System.out.println(line.get(0));
		}
		else {
			System.out.println("");
		}
	}

}
