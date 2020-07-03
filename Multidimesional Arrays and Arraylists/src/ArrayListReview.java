import java.util.*;
public class ArrayListReview {

	public static void main(String[] args) {
		ArrayList<Double> grades = new ArrayList<>();
		//Wrapper class: Object version of a primative. ex) Double is wrapper for double
		List<Integer> nums = new ArrayList<>();
		
		//ArrayList<Integer> numTacos2 = new List<Integer>() //NEVER PUT LIST ON RIGHT SIDE
		//Can put more specific thing on the left
		
		//List can be ArrayList, Linked list, 
		
		//add
		nums.add(0);
		System.out.println(nums);
		nums.add(3);
		
		//add at specific index: .add(INDEX, VALUE);
		//nums.add(5,3) NO NO NO Cannot add to index that doesn't exist less it is the last index of the arraylist
		nums.add(1,4);
		nums.add(0,5);
		nums.add(0,8);
		
		System.out.println(nums);
		//get
		int a = nums.get(1);
		System.out.println(a);
		
		//remove
		System.out.println(nums);
		nums.remove(1); //Removes the element at index 3
		System.out.println(nums);
		
		int ousted = nums.remove(2); // Removes the element a 2 and and int is that element
		
		nums.add(1, nums.remove(2)); //removes element at index 2 and adds to index 1
		
		//set
		//Returns what was there first
		System.out.println("THING HERE: " + nums.set(0, 5)); 
		System.out.println(nums);

	}
	//Remove and Set returns the value of the element changed

}
