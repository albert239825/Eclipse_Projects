package MayChallenge2020;

import java.util.*;

class TRPLSRT {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		try {
			int t = in.nextInt();
			int[] k = new int[t];
			int[][] nums = new int[t][];
			for (int i = 0; i < t; i++) {
				int n = in.nextInt();
				nums[i] = new int[n];
				k[i] = in.nextInt();
				
				for (int j = 0; j < n; j++) {
					nums[i][j] = in.nextInt();
				}
			}
			
			in.close();
			//System.out.println(Arrays.toString(k));
			for (int i = 0; i < nums.length; i++) {
				//System.out.println("check");
				ArrayList<Integer[]> moves = sort(nums[i], k[i]);
				//System.out.println("check2");
				if (moves == null) {
					System.out.println("-1");
				}
				//print out each step
				else {
					System.out.println(moves.size());
					for (int j = 0; j < moves.size(); j++) {
						Integer[] cur = moves.get(j);
						System.out.println(cur[0] + " " + cur[1] + " " + cur[2]);
					}
				}
			}
			
		}
		
		catch (Exception e) {
			return;
		}
		
	}
	
	//Returns an arraylist of actions or null if not possible in k;
	//possible error: problems starts at one, while arrays start at index 0
	public static ArrayList<Integer[]> sort (int[] nums, int k) {
		
		int numMoves = 0;
		ArrayList<Integer[]> moves = new ArrayList<>();
		
		
		for (int i = 0; i < nums.length; i++) {
			if (isSorted(nums)) {
				return moves;
			}
			Integer[] move = new Integer[3];
			int indexOfCur = indexOfArray(nums, i + 1);
			//if We have reached or move limit, check if we already have a sorted array
			if (numMoves >= k) {
				return null;
			}
			
			if (nums[i] - 1 == i) {
				continue;
			}
			System.out.println(Arrays.toString(nums) + " move = " + numMoves + " limit= " + k);	
			if (i == nums.length - 3 && nums[i] - 1 == indexOfCur) {
				//System.out.println("getting here");
				return null;
			}
			
			if (i > nums.length - 3) {
				if (isSorted(nums)) {
					return moves;
				}
				return null;
			}
			
			
			
			if (nums[i] - 1 == indexOfCur) {
				//TO-DO
				//only swap indexOfCur, i, i + 1
				//System.out.println("special");
				//Possible efficiency improvements (make sure that this doesn't displace a number in the right place)
				if (indexOfCur == i+1) {
					move[0] = indexOfCur + 1;
					move[1] = i + 1;
					move[2] = i+3;
					moves.add(move);
					
					numMoves++;
					
					
					System.out.println("special++: " + indexOfCur + " " + i + " " + (i+2));
					
					nums = swap(nums, indexOfCur, i, i+2);
				}
				else {
					move[0] = indexOfCur + 1;
					move[1] = i + 1;
					move[2] = i+2;
					moves.add(move);
					
					numMoves++;
					
					System.out.println("special: " + indexOfCur + " " + i + " " + (i+1));
					
					nums = swap(nums, indexOfCur, i, i+1);
				}
			}
			
			
			//swap nums[i] to index nums[i] & i to index i
			else {
				if (indexOfCur < nums[i]) {
					
					move[0] = indexOfCur + 1;
					move[1] = i + 1;
					move[2] = nums[i];
					moves.add(move);
					
					numMoves++;
					
					//perform swap
					
					System.out.println("1: " + indexOfCur + " " + i + " " + (nums[i] - 1));
					nums = swap(nums, indexOfCur, i, nums[i] - 1);

				}
				else {
					move[0] = i + 1;
					move[1] = nums[i];
					move[2] = indexOfCur + 1;
					moves.add(move);
					
					numMoves++;
					
					System.out.println("2: " + i + " " + (nums[i] - 1) + " " + indexOfCur);
					
					nums = swap(nums, i, nums[i] - 1, indexOfCur);
				}
				
			}	
			
		}
		return moves;
	}
	
	//swaps 3 values in a forward direction, If want backwards i3 < i2 < i1
	public static int[] swap (int[] nums, int i1, int i2, int i3) {
		int temp = nums[i3];
		nums[i3] = nums[i2];
		nums[i2] = nums[i1];
		nums[i1] = temp;
		return nums;
	}
	
	static boolean isSorted(int[] array) {
	    for (int i = 0; i < array.length - 1; i++) {
	        if (array[i] > array[i + 1])
	            return false;
	    }
	    return true;
	}
	
	public static int indexOfArray(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				return i;
			}
		}
		return -1;
	}
}


/*
outline:
in one rotation, we are going to sort the min of that index and the number being moved

Special case: if swap puts it in order
	- only sort 1

Suggestions for runTime:
	- Pre-check if a solution is possible at all



*/