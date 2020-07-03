package MayChallenge2020;
import java.util.*;
class COVID19 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			int t = in.nextInt();
			ArrayList<Integer[]> trial = new ArrayList<>();
			for (int i = 0; i < t; i++) {
				int n = in.nextInt();
				Integer[] line = new Integer[n];
				for (int j = 0; j < n; j++) {
					line[j] = in.nextInt();
				}
				trial.add(line);
			}
			
	//		for (int i = 0; i < trial.size(); i++) {
	//			Integer[] cur = trial.get(i);
	//			for(Integer j : cur) {
	//				System.out.print(j);
	//			}
	//			System.out.println();
	//			
	//		}
			
			for (int i = 0; i < trial.size(); i++) {
				Integer[] cur = trial.get(i);
				int min = 10;
				int max = 0;
				for (int j = 0; j < cur.length; j++) {
					ArrayList<Integer> infected = new ArrayList<>();
					//System.out.println("new Test");
					int test = infect(j, cur, infected);
					//System.out.println("result: " + test);
					if (test > max) {
						max = test;
					}
					if (test < min) {
						min = test;
						//System.out.println("set min to " + min);
					}
				}
				
				//System.out.println("FINAL RESULT:");
				System.out.print(min + " ");
				System.out.println(max);
			}
		}
		catch (Exception e) {
			return;
		}

	}
	
	
	
	public static int infect(int cur, Integer[] line, ArrayList<Integer> infected) {
		
		infected.add(line[cur]);
//		System.out.println(line[cur]);
//		System.out.println(infected);
//		System.out.println();
		if (!moreInfect(cur, line, infected)) {
			//System.out.println("nomore");
			return 1;
		}
		
		int total = 0;
		if (cur - 1 < 0) {
			if (line[cur + 1] - line[cur] <= 2 && !infected.contains(line[cur + 1])) {
				total += infect(cur + 1, line , infected);
			}
		}
		else if (cur + 1 >= line.length) {
			if (line[cur] - line[cur - 1] <= 2 && !infected.contains(line[cur - 1])) {
				total += infect(cur-1, line, infected);
			}
		}
		else {
			if (line[cur] - line[cur - 1] <= 2 && !infected.contains(line[cur - 1])) {
				total += infect(cur-1, line, infected);
			}
			if (line[cur + 1] - line[cur] <= 2 && !infected.contains(line[cur + 1])) {
				total += infect(cur + 1, line , infected);
			}
		}
		return total + 1;
	}
	
	
	//Checks for the base case whether people can still be infected
	public static boolean moreInfect(int cur, Integer[] line, ArrayList<Integer> infected) {
		if (cur - 1 < 0) {
			if (line[cur + 1] - line[cur] > 2 || infected.contains(line[cur + 1])) {
				//System.out.println("fail");
				return false;
			}
		}
		else if (cur + 1 >= line.length) {
			if (line[cur] - line[cur - 1] > 2 || infected.contains(line[cur - 1])) {
				return false;
			}
		}
		else {
			if ((line[cur + 1] - line[cur] > 2 || infected.contains(line[cur + 1])) && (line[cur] - line[cur - 1] > 2 || infected.contains(line[cur - 1]))) {
				return false;
			}
		}
		
		return true;
				
	}
}
