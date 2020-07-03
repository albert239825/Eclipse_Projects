public class TwoDArrayNotes {

	public static void main(String[] args) {

		// Arrays in Java store multiple items of the same type
			// Ints, Strings, anything, even arrays

		// A 2D Array is Array of Arrays 

		
		
		// 	3	5	7	9
		//	5	1	8	6
		//	4	2	2	0

		// This is a 3x4 array
			// 3 rows
			// 4 collums

		// Uses of 2D Arrays:
			// 

		// Fill in the blanks based on PPT
		// [2][3] = 0
		// [0][2] = 7
		// [3][0] = Index Outta Bounds

		// Declare and Instantiate Arrays: ticketInfo and seatingChart
		
		//int[][] ticketInfo = new int[2][3];
		//String[][] seatingChart = new String[3][2];
		
		//Find # of rows and columns
		//ticketInfo.length = rows
		//ticketInfo[0].length = columns
		
		//Initailizing 2d arrays
		//int[][] ticketInfo2 = { {25,20,25} , {25,20,25}};
		//String[][] seatingInfo = { {"Jamal" , "Maria"}, {"jake", "suzy"}, {"Emma", "Luke"}};
		//							
//		for (int r = 0; r < seatingInfo.length; r++) {
//			for (int c = 0; c < seatingInfo[r].length; c++) {
//				System.out.print(seatingInfo[r][c] + " ");
//			}
//			System.out.println();
//		}
		
		int[][] numTacos = { {33,12,5,7}, {23,13,0,5},{46,55,9,17}};
		int max = numTacos[0][0];
		int row = 0;
		int col = 0;
		for (int r = 0; r < numTacos.length; r++) {
			for (int c = 0; c < numTacos[r].length; c++) {
				if (numTacos[r][c] > max) {
					max = numTacos[r][c];
					row = r;
					col = c;
					
				}
			}
		}
		System.out.println(max + " " + row + " " + col);


		// How do you figure out how many elements
		// could be stored in these arrays?
		int rows;
		int cols;

		// Giving an Array Values

		int[][] ticketInfo2 = { {25,20,25}, {25,20,25} };
			//Add seatingInfo

		// Lets print our array

		// Now what?
			// Lets print out the seatingInfo so each row gets it's own line
		
		int[][] doom = { { 11, 3, 5},
						 { 9,  7, 6, 23, 99},
						 {0},
						 {} };
		
		
		// Find Highest Array and Code
		
							
		
	}

}