
public class Decrypter {
	static String test;

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int letters = 1;
		String password = "asdfghjkl";
		test = "";
		while (test.equals("")) {
			System.out.println("test");
			Decrypt(password, test, letters);
			letters++;
			System.out.println("raised");
		}
		
		long endTime = System.nanoTime();
		long eclipsedTime = endTime - startTime;
		float timeMili = ((float) eclipsedTime)/ 1000000;
		System.out.println("time taken: " + timeMili + " milis");
		System.out.println(test);

	}
	
	public static void Decrypt (String password, String built, int numLetters) {
		System.out.println(built);
		if (built.equals(password)) {
			test = built;
			System.out.println("works");
			return;
		}
		if (numLetters > 0) {
			for (int i = '!'; i < '~'; i++) {
				System.out.println();
				Decrypt(password, built + ((char) i), numLetters - 1);
			}
		
		}
		else {
			return;
		}
	}
	

}
