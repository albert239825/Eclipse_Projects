import java.util.*;
public class Driver {

	public static void main(String[] args) {
		// Original Code
		//		Animal John = new Panda("John", 5, true);
		//		Animal Bob = new Fly("Bob", 2, true);
		//		Animal Trevor = new GenZKid("Trevor", 6, false, 5);
		//		Animal Pain = new Panda("Pain", 6, true);
		//		Animal edgy = new GenZKid("edgy", 2, true, 0);
		//		
		ArrayList<Animal> Animals = new ArrayList<>();
		//		Animals.add(John);
		//		Animals.add(Bob);
		//		Animals.add(Trevor);
		//		Animals.add(Pain);
		//		Animals.add(edgy);

		Scanner sc = new Scanner(System.in);
		System.out.println("Please input the dimesions");
		System.out.println("Rows: ");
		int r = sc.nextInt();
		System.out.println("Columns: ");
		int c = sc.nextInt();
		System.out.println("Please input the number of Animals you would like");
		int n = sc.nextInt();
		while (r*c <= n) {
			System.out.println("Those dimensions are too small for the number of Animals you want. \nPlease Try Again");
			System.out.println("Row: ");
			r = sc.nextInt();
			System.out.println("Cols: ");
			c = sc.nextInt();
		}

		Animals = generate(n);
		DavisGrounds zoo = new DavisGrounds(r,c);
		//We are going to generate n animal 10 times before giving up
		int tries = 0;
		while (tries < 10 && !zoo.Fill(Animals)) {
			//debug
//			for (Animal cur : Animals) { 
//				System.out.print(cur + ", "); 		
//			}
			Animals = generate(n);
			tries++;
		}
		if (tries != 10) {
			System.out.println("Would you like to call entertainment. (y/n)");
			sc.nextLine();
			String res = sc.nextLine();
			if (res.equals("y")) {
				//Call entertain
				zoo.entertainAll();
			}
		}
		else {
			System.out.println("Couldn't find a match. Pen area probably too small for random animals");
		}
	}
	//generates n animals
	public static ArrayList<Animal> generate(int n) {
		//Arraylist of animals that we are going to return
		ArrayList<Animal> out = new ArrayList<>();
		//this is for the choosing of the animals and the animal variable generation as well
		Random rd = new Random();
		//These are for naming
		int fly = 1;
		int pan = 1;
		int kid = 1;
		//Which animal are we going to make
		int cur = 0;
		//name that will be given to the animals
		String name = "";
		for (int i = 0; i < n; i++) {
			cur = rd.nextInt(3);
			//generate fly
			if (cur == 0) {
				name = "fly" + fly;
				fly++;
				out.add(new Fly(rd,name));
			}
			//generate panda
			if (cur == 1) {
				name = "panda" + pan;
				pan++;
				out.add(new Panda(rd,name));
			}
			//generate kid
			else {
				name = "GenZkid" + kid;
				kid++;
				out.add(new GenZKid(rd,name));
			}
		}
		return out;
	}

}
