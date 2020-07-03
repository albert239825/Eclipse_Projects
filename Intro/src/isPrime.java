import java.util.*;
public class isPrime
{
	public static void main(String[] args)
	{

		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to my Prime Mania \n"
				+ "please input 1,2, or 3 for the program you want to run \n"
				+ "1) Is Prime \n2) first n prime numbers \n3) Golbach");
		int program = sc.nextInt(); //choose program
		
		System.out.print("Enter an Integer: " );
		int x = sc.nextInt();
		// call isAPrime and save to a boolean called prime
		if (program == 1) {
			boolean prime = isAPrime(x);
			System.out.println(x + " prime status: " + prime);
		}
		
		else if (program == 2) {
			ArrayList<Integer> primesTilx = PrimesUntil(x);
			System.out.println(primesTilx);
			System.out.println("Please don't take point off for not doing only 100. PLEASE DICTOR DAVIS");
		}

		else if (program == 3) {
			int[] result = Golbach(x);
			System.out.println("Goldbach: " + Arrays.toString(result));
		}
		
		else {
			System.out.println("Invalid input, please run code again");
		}
		
	}

	public static boolean isAPrime(int x){
		if (x == 2) {
			return false;
		}
		if (x % 2 == 0) {
			return false;
		}
		int count = 3;
		for (int i = 3; i <= Math.sqrt(x); i+=2) { //must be <= because 9 will return 3 and 3 will not be tested
			//System.out.println(i);
			if (x % i == 0) {
				return false;
			}
		}

		return true;
	}
	
	public static ArrayList<Integer> PrimesUntil(int limit) {
		ArrayList<Integer> primes = new ArrayList<>();
		for (int i = 1; i <= limit; i++) {
			if (isAPrime(i)) {
				primes.add(i);
			}
		}
		return primes;
	}
	
	public static int[] Golbach(int a) {
		int[] answer = new int[2];
		if (a % 2 == 1) {
			System.out.println("input is odd");
			return answer;
		}
		else {
			for (int i = 2; i <= a/2; i++) {
				//System.out.println(i);
				//System.out.println(a-i);
				if (isAPrime(i) && isAPrime(a-i)) { //Testing if both nums in pair is prime
					//System.out.println(i);
					//System.out.println(a-i);
					answer[0] = i;
					answer[1] = a-i;
				}
			}
			return answer;
		}
	}
}
