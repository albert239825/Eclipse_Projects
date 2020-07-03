import java.util.*;

public class Guessing_Game {

	public static void main(String[] args) {
		int rep = 1;
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		boolean repeat = true;
		
		while(rep == 1) {
			int guess = 1;
			int rand = (int) ((Math.random() * 10) + 1);
			System.out.println(rand);
			System.out.println("choose a number between 1-10");
			int number = sc.nextInt();
			
			while(guess < 3 && number != rand) {
				guess++;
				System.out.println("wrong! try again");
				number = sc.nextInt();
			}
			
			if (number != rand) {
				System.out.println("the right number is " + rand);
			}
			else {
				System.out.println("nice job you got it right");
			}
			System.out.println("do you want the play again? 1 for yes and 2 for no");
			rep = sc.nextInt();
			
			if (rep == 2) {
				System.out.println("Thank you for playing");
			}
			else {
				System.out.println("here we go again");
			}
		}
	}
}
