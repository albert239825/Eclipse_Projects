import java.util.*;
import java.io.*;

public class Team1Problem5 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> open = new ArrayList<>();
		ArrayList<Integer[]> pairs = new ArrayList<>();
		ArrayList<Character> ops = new ArrayList<>();
		ArrayList<Integer> indexOfOp = new ArrayList<>();
		TreeMap<Integer[], Character> association = new TreeMap<>();
		int pos = in.nextInt();
		int[] nums = new int[pos];
		for (int i = 0; i < pos; i++) {
			nums[i] = in.nextInt();
		}
		int target = in.nextInt();
		in.nextLine();
		String input = in.nextLine();
		in.close();

		for (int i = 0; i < input.length(); i++) {
			char cur = input.charAt(i);
			if (cur == '(') {
				open.add(i);
			}
			else if (cur == ')') {
				int match = open.remove(open.size() - 1);
				pairs.add(new Integer[] {match,i});
			}
			else if (cur == '+' || cur == '-' || cur == '*'){
				ops.add(cur);
				indexOfOp.add(i);
			}
		}
		System.out.println("yes");
		for (int i = 0; i < pairs.size(); i++) {
			Integer[] cur = pairs.get(i);
			for (int j = 0; j < indexOfOp.size(); j++) {
				int index = indexOfOp.get(j);
				if (j > cur[0] && j < cur[1]) {
					association.put(cur, ops.get(index));
					indexOfOp.remove(index);
					ops.remove(index);
				}
			}
		}
	}
}
