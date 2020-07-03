
public class For_Loops_and_Short_Circuiting {

	public static void main(String[] args) {
		int num = 0;

		//		for (int i = 0; i < 10; i++) {
		//			System.out.println(i);
		//		}
		// Short Circuiting
		// Exclusive to And statements
		// Ands happen before Or's in order of operations

		int a = 18;
		int b = 10;
		
		if (a > b) {
			System.out.println("hello");
		}
		else {
			System.out.println("good bye");
			System.out.println("potato");
		}
//		if (a>b && (a + b*b / (a*2) != -5)) {
//			System.out.println("Potato");
//		}
//		else {
//			System.out.println("Tater");
//		}
	}

}
