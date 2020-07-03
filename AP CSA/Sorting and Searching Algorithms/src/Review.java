import java.util.ArrayList;
public class Review {
	public static void main(String[] args) {
		
		int num = 0;
		System.out.println(num++);
		num = 0;
		System.out.println(++num);
		
//		while(num < 8) {
//			System.out.println(num);
//			//num++;
//			++num;
//		}
		
		ArrayList<Integer> nums = new ArrayList<>();
		System.out.println("ArrayList: " + nums);
		
		f1(nums);
		
		System.out.println("ArrayList: " + nums);
	}
	
	public static void f1(ArrayList<Integer> n) {
		n.add(8);
	}
}
