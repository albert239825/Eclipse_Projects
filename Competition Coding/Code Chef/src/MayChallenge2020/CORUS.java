package MayChallenge2020;
import java.util.*;
class CORUS {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			//Inputs (we are going to deal with each query later
			int t = in.nextInt();
			ArrayList<String> inputs = new ArrayList<>();
			ArrayList<Integer[]> run = new ArrayList<>();
			for (int j = 0; j < t; j++) {
				int n = in.nextInt();
				int q = in.nextInt();
				
				in.nextLine();
				String template = in.nextLine();
				inputs.add(template);
				
				
				Integer[] iso = new Integer[q];
				for (int i = 0; i < q; i++) {
					iso[i] = in.nextInt();
					//System.out.println(iso[i]);
				}
				run.add(iso);
			}
			
			System.out.println(inputs);
			for (Integer[] cur : run) {
				System.out.println(Arrays.toString(cur));
			}
			for (int i = 0; i < inputs.size(); i++ ) {
				String template = inputs.get(i);
				Integer[] iso = run.get(i);
				HashMap<Character, Integer> queue = new HashMap<>();
				char[] letters = template.toCharArray();
				//Getting the number of people with each type of rona
				for (char cur : letters) {
					if (queue.containsKey(cur)) {
						queue.put(cur, queue.get(cur) + 1);
					}
					else {
						queue.put(cur, 1);
					}
				}
				
				//System.out.println(queue.keySet());
				ArrayList<Integer> numEachInfec = new ArrayList<>(queue.values());
				
				//System.out.println(numEachInfec);
				
				//System.out.println();
				
				for (int j = 0; j < iso.length; j++) {
					//System.out.println("trial " + i);
					//Number of people in queue of current query 
					int cur = 0;
					
					ArrayList<Integer> curQ = (ArrayList<Integer>) numEachInfec.clone();
					//number of isolation centers for this query
					//System.out.println("getting here");
					int c = iso[j];
					//System.out.println("iso " + c);
					for (Integer num : curQ) {
						if (num > c) {
							cur += num-c;
						}
					}
					System.out.println(cur);
				}
				
				//System.out.println("yes");
			}
			
		}
		catch(Exception e) {
			return;
		}
	}
	
}


/*
Outline:
1. Get the number of each rona in a treeset with the type of rona as the key and number as the value
2. loop through the keyset C, the number of isolation centers, times and one of each rona in the isolation center
3. Remove a type of rona from the treeset if the remaining people is left is 0
4. Return the number of remaining people still in the cue

*/