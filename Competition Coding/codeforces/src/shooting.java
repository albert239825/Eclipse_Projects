import java.util.*;

public class shooting {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cans = in.nextInt();
		in.nextLine();
		String dura = in.nextLine();
		String[] duras = dura.split(" ");
		ArrayList<Integer> durab = new ArrayList<>();
		ArrayList<Integer> available = new ArrayList<>();
		int i = 1;
		for (String d : duras) {
			durab.add(Integer.parseInt(d));
			available.add(i);
			i++;
		}
		ArrayList<Integer> order = new ArrayList<>();
		
		int total = 0;
		
		//cans shot
		int shot = 0;
		
		while (durab.size() > 0) {
			int cur = Collections.max(durab);
			order.add(available.get(durab.indexOf(cur)));
			available.remove(durab.indexOf(cur));
			durab.remove(durab.indexOf(cur));
			total += (cur*shot+1);
			shot++;
		}
		System.out.println(total);
		for (int j = 0; j < order.size(); j++) {
			System.out.print(order.get(j) + " ");
		}
	}
}
