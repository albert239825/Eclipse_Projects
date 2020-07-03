package problemSet_2017;
import java.util.*;
public class Problem_10 {
	public static void main(String[] args) {
		int total = 0;
		for (int i = 1; i < 2017; i++) {
			if (works(i)) {
				System.out.println(i);
				total++;
			}
		}
		System.out.println(total);
	}
	
	public static ArrayList<Integer> getDigits(int cur) {
		ArrayList<Integer> digits = new ArrayList<>();
		while (cur > 0) {
			digits.add(cur % 10);
			cur /= 10;
		}
		return digits;
	}
	
	public static boolean works(int cur) {
		ArrayList<Integer> digits = getDigits(cur);
		for (int i = 0; i < digits.size() - 1; i++) {
			if ((digits.get(i) != 0 && digits.get(i) % 2 == 0) && (digits.get(i+1) != 0 && digits.get(i + 1) % 2 == 0)) {
				return true;
			}
		}
		return false;
	}
}
