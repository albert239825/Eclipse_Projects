package MayCookOff2020;
import java.util.*;

class CHEFRECP {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			int t = in.nextInt();
			int[][] trials = new int[t][];
			
			for (int i = 0; i < t; i++) {
				//System.out.println("here");
				int n = in.nextInt();
				//System.out.println(n);
				trials[i] = new int[n];
				//add ingred to an array
				for (int j = 0; j < n; j++) {
					trials[i][j] = in.nextInt();
				}
				//System.out.println("yes");
			}
			
			//System.out.println(Arrays.deepToString(trials));
			
			for (int i = 0; i < t; i++) {
				int[] ingred = trials[i].clone();
				
//				System.out.println();
//				System.out.println(Arrays.toString(ingred));
				
				//number of each ingredient
				HashSet<Integer> quantities = new HashSet<>();
				//Ingredients seen
				HashSet<Integer> seen = new HashSet<>();

				int count = 1;
				seen.add(ingred[0]);
				//System.out.println(seen);
				boolean output = true;
				
				for (int j = 1; j < ingred.length; j++) {
					//System.out.println("here");
					//System.out.println(ingred[j - 1] + " " + ingred[j]);
					if (ingred[j] != ingred[j-1]) {
						//System.out.println("broke");
						if (seen.contains(ingred[j])) {
							System.out.println("NO");
							output = false;
						}
						else {
							seen.add(ingred[j]);
							if (!quantities.add(count)) {
								System.out.println("NO");
								output = false;
							}

							count = 1;
						}
					}
					
					else {
						//System.out.println("working");
						count++;
					}
					//System.out.println("done");
					
					if (!output) {
						break;
					}
					//System.out.println(seen);
					//System.out.println(quantities);
				}
				
				//System.out.println(count);
				if (output && quantities.add(count)) {
					System.out.println("YES");
				}
				else if (output) {
					System.out.println("NO");
				}
				//System.out.println(quantities);
				
			}
		}
		catch (Exception e) {

		}
	}
	//If we have seen the number before and the number before it is not the same number return false;
	
}
