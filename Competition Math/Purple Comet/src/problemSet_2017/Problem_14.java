package problemSet_2017;
import java.util.*;
public class Problem_14 {
	public static void main(String[] args) {
		int sum = 0;
		ArrayList<Integer> cubes = new ArrayList<>();
		for (int i = -1000; i < 1000; i++) {
			int cube = (int) Math.pow(i,3);
			cubes.add(cube);
		}
		//System.out.println(cubes);
		for (int i = -1000; i < 1000; i++) {
			
			if (cubes.contains(i-3) && cubes.contains((int) Math.pow(i,2)+4)) {
				sum += i;
				System.out.println(i);
			}
		}
	}
	
}
