import java.io.*;
import java.util.Scanner;
import java.util.*;


public class Files {

	public static void main(String[] args) {

		File f = new File("nums.txt");
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PrintWriter pw = new PrintWriter(fileWriter);
		addNums(pw);
		pw.close();



		Scanner sc = null;
		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ArrayList<Integer> nums = new ArrayList<>();
		while (sc.hasNext()) {
			nums.add(sc.nextInt()); //adds numbers from text file to arraylist
		}

		Scanner in = new Scanner(System.in);
		boolean repeat = true;
		while (repeat) { //allows for repeat
			System.out.println("Choose an option: \n1) Sequencial Search \n2) Binary Search\n3) selection sort");
			int option = in.nextInt();
	
			if (option == 1) { //Seq Search
				System.out.println("Input Target:");
				int tar = in.nextInt();
				System.out.println("The index of " +tar+ " is "+ SequencialSearch(nums, tar));
				in.hasNextLine(); //make sure you don't have to push enter twice
			}
			if (option == 2) {// Binary Search
				SelSort(nums); //Sorting the nums so that binary search can work
				System.out.println(nums);
				System.out.println("Input Target:");
				int tar = in.nextInt();
				int index = BinarySearch(nums, 0, nums.size(), tar);
				System.out.println("The index of " +tar+ " is "+ index);
				in.nextLine(); // make sure you don'thave to push enter twice
	
			}
			if (option == 3) { //Sel Sort + rewrite
				SelSort(nums);
				System.out.println("Would you like to update the text file? (y/n)");
				in.nextLine();
				String response = in.nextLine();
				if (response.equals("y")) { //give the user the option to rewrite file
					//Reinstating the fileWriter so that the text file is cleared
					fileWriter = null;
					try {
						fileWriter = new FileWriter(f);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					pw = new PrintWriter(fileWriter);
					pw.println(0);
					//calling to print nums into the text file
					addNums(nums, pw);
					//closing the printWriter
					pw.close();
				}
			}
			
			System.out.println("Repeat? (y/n)");
			//in.nextLine();
			String response = in.nextLine();
			if (response.equals("n")) {
				repeat = false;
			}
		}
		//		int sum = 
		//		System.out.println(sum);
		//		sc.close();
	}

	public static int totalNums(Scanner s)
	{
		int total = 0;

		while(s.hasNextInt()) {
			int num = s.nextInt();
			total += num;
		}
		return total;

	}

	public static void addNums(PrintWriter p)
	{
		for(int i = 0; i < 100; i++) {
			int num = (int) (Math.random()*100) + 1;
			p.println(num);
			//System.out.println(num);
		}
	}


	public static int SequencialSearch (ArrayList<Integer> nums, int target) { // This codes for sequential search. looks through each index to check if value is present (inefficient)
		for (int i = 0; i < nums.size(); i++) {
			if (nums.get(i) == target) { //Checks if current index is equal to target
				return i;
			}
		}

		System.out.println("Not Found"); //if the target is not found return -1
		return -1;

	}

	//Binary Search
	public static int BinarySearch(ArrayList<Integer> nums, int low, int high, int target) {
		if (low >= high) {
			return -1;
		}
		int midIndex = (high + low) / 2; //gets the middle index
		int mid = nums.get(midIndex); //gets the middle number in the possible range
		//System.out.println(midIndex + " " + low + " " + high);
		if (target < mid) {
			return BinarySearch(nums, low, midIndex - 1, target);
		}
		if (target == mid) {
			return midIndex;
		}
		if (target > mid) {
			return BinarySearch(nums, midIndex + 1, high, target);
		}
		System.out.println("error you should never be here");
		return -1;
	}
	
	//Selection sort

	public static void SelSort(ArrayList<Integer> nums) {
		int min = nums.get(0); // variable for the lowest number
		int index = 0; //index for the lowest number
		for (int i = 0; i < nums.size(); i++) {
			min = nums.get(i);
			index = i;
			for (int j = i + 1; j < nums.size(); j++) {
				//System.out.println(min + nums.get(j));
				if (nums.get(j) < min) {
					min = nums.get(j);
					index = j;
					//System.out.println(min);
				}
			}
			nums.remove(index);
			nums.add(i,min);
		}
	}

	public static void addNums(ArrayList<Integer> nums, PrintWriter p) {
		for (int i = 0; i < nums.size(); i++) {	
			p.println(nums.get(i)); //prints numbers from nums into the text file
			//System.out.println(nums.get(i));
		}
	}

}

//Typing for problems
