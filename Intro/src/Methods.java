import java.util.*;
public class Methods {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("plz input");
		int input = sc.nextInt();
		System.out.println(isEven(input));
		
		//Functions completes a tasks but doesn't manipulate objects
		//Methods, generally, manipulate objects
		//int kms = add(8,9);
		//System.out.println(kms);

	}
	
	public static int add(int a, int b) {
		 int sum = a + b;
		 
		 return sum;
	}
	
	public static boolean isEven(int a) {
		return (a % 2 == 0);
	}

}
