import java.util.*;
public class Craps {

	public static void main(String[] args) {
		boolean rep = true;
		Scanner sc = new Scanner(System.in);
		while (rep) {
			int openRole1 = (int) (Math.random()*6) + 1;
			int openRole2 = (int) (Math.random()*6) + 1;
			int total = openRole1 + openRole2;
			System.out.println("Your opening roles were " + openRole1 + " and " + openRole2 + " with total " + total);
			if (openRole1 + openRole2 == 7 || openRole1 + openRole2 == 11) {
				System.out.println("you won");
			}
			else if (openRole1 + openRole2 == 3 || openRole1 + openRole2 == 2 || openRole1 + openRole2 == 12) {
				System.out.println("you lost");
			}
			else {
				System.out.println("starting point roles");
				pointRole(total);

			}
			System.out.println("do you want to play again? (yes or no)");
			String response = sc.nextLine();
			if (response.equals("no")) {
				rep = false;
				System.out.println("Thanks for Playing");
			}

		}
	}
	public static void pointRole(int total) {
		while (1==1) {
			int Role1 = (int) (Math.random()*6) + 1;
			int Role2 = (int) (Math.random()*6) + 1;
			int newtot = Role1 + Role2;
			System.out.println("you rolled a " + Role1 + " and a " + Role2 + " and the total is " + newtot);
			if (newtot == total) {
				System.out.println("you win");
				return;
			}
			if (newtot == 7) {
				System.out.println("you lose");
				return;
			}
		}
	}

}
