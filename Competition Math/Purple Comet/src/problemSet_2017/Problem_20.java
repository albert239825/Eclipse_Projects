package problemSet_2017;
import java.util.*;
public class Problem_20 {
	public static void main(String[] args) {
		for (int i = -100; i < 100; i++) {
			if (Math.sqrt(Math.pow(i,2)+2) == (Math.pow(i, 1/3) +45)) {
				System.out.println(i);
			}
		}
	}
}
