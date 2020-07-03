import java.util.*;
public class Grades_Arrays {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] grades = new int[20];
		int lowest = Integer.MAX_VALUE;
		int total = 0;
		
		for (int i = 0; i < 20; i++) {
			int random = (int)(Math.random() * 40)+ 60;
			grades[i] = random;
			if (random < lowest) {
				lowest = random;
			}
		}
		
		boolean response = true;
		while (response) {
			System.out.println("Please input the number for the function");
			System.out.println("1) Print Grade Book \n2) Remove a index \n3) Add Grade");
			int input = sc.nextInt();
			
			//prints all the grades in the grade book
			if (input == 1) {
				for (int i = 0; i < grades.length; i++) {
					System.out.println(i + 1 + ") " + grades[i]);
				}
			}
			
			//Removes the element at that index
			else if (input == 2) {
				System.out.println("which index do you want to remove");
				int index = sc.nextInt();
				grades = removeNum(grades, index);
			}
			
			//Adds an element at a given index
			//Added feature where user could input last and it would add to end
			else if (input == 3) {
				System.out.println("What number do you want to add");
				int num = sc.nextInt();
				System.out.println("What index do you want to add it at or input last for last index");
				String index = sc.next();
				System.out.println("check");
				if (index.equals("last")) {
					grades = addNum(grades, grades.length,num);
				}
				else {
					grades = addNum(grades, Integer.parseInt(index), num);
				}
			}
			else {
				System.out.println("input invalid");
			}


			//finding the sum of the values in the array
			total = 0;
			for (int i = 0; i < grades.length; i++) {
				if (grades[i] < lowest) {
					lowest = grades[i];
				}
				total += grades[i];
			}
			
			//debugging
			//System.out.println(lowest);
			//System.out.println(total);
			//System.out.println(total- lowest);
			
			//findthing the average
			double avg = total/(double) grades.length;
			double avgUpper = (total - lowest) / (double) (grades.length - 1);
			avgUpper = Math.round(avgUpper * 100.0) / 100.0; //rounding to two decimal places
			avg = Math.round(avg * 100.0) / 100.0;

			System.out.println(avg);
			System.out.println(avgUpper);
			
			//repeat input
			System.out.println("Would you like to repeat (y/n)");
			sc.nextLine();
			String res = sc.nextLine();
			if (res == "n") {
				response = false;
			}
		}
		//These were class notes for what the menu should look like
		//menu
		//1 print grade book
		//2 add
		//3 remove

	}

	//Removes a num to an array
	public static int[] removeNum(int[] input, int index) {
		int[] output = new int[input.length - 1];
		for (int i = 0, k = 0; i < input.length; i++) {
			//System.out.println(i);
			if (k < input.length - 1 && i != index - 1) {
				output[k] = input[i];
				k++;
			}
		}
		return output;
	}

	//Adds a num to an array 
	//i is index of old array while k is the index of the new one
	public static int[] addNum(int[] input, int index, int num) {
		int[] output = new int[input.length + 1];
		for (int i = 0, k = 0; i < input.length; i++) {
			if (i == index - 1) { //make java indices
				output[k] = num;
				k++;
			}
			output[k] = input[i];
			k++;
		}
		
		if (index == input.length) { //Special case because either you miss out on the first index or you miss out on the last index
			output[input.length] = num;
		}
		return output;
	}
}
