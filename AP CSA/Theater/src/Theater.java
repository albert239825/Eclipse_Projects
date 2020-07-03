// Class: Theater
// Purpose: Uses a two-dimensional array to represent 
// the seating arrangement of customers in a theater. The seats in the theater 
// are in a rectangular arrangement of rows and columns.
//
// Tim Gallagher
// 2019 APCS A Facebook Summit

import java.util.*;

public class Theater 
{
	private Customer[][] seats;



	/* *  Creates a Theater seating chart with the given number of rows and columns 
	 *  from the Customers in customerList. Empty seats are represented by null.
	 *
	 *  @param rows the number of rows of seats in the theater
	 *  @param cols the number of columns of seats in the theater
	 *  @param customerList The customers to be given seats in the theater
	 *  @param rand indicator if customers should be given random seats

	 *  Precondition: rows > 0; cols > 0;
	 *             rows * cols >= customerList.size()
	 *  Postcondition:
	 *    - Customers appear in the seats in the same order as they appear in
	 *      customerList, starting at seats[0][0], and seats is filled row by row from
	 *      customerList, followed by any empty seats (represented by null).
	 *        OR
	 *      Customers are placed in the seats in random order, with empty seats null
	 *    - customerList is unchanged.
	 */	
	public Theater(int rows, int cols, ArrayList<Customer> customerList, boolean rand, ArrayList<Integer> isles){
		seats = new Customer[rows][cols + isles.size()]; //make room for the isles and can make multiple isles
		if (rand) {
			for (Customer cur : customerList) { // are you impressed, I used a for each loop ;)
				boolean sat = false; //boolean whether if the current customer has been sat
				while (!sat) { //while the customer hasn't been sat, we will keep looking for a set
					int r = (int) (Math.random() * rows);
					int c = (int) (Math.random() * seats[0].length);
					//System.out.println(r + " " + c);
					if (seats[r][c] == null && !isles.contains(c)) { //Selected an random seat and checks if empty and whether that seat is an isle  
						//System.out.println(r + " " + c);
						int price = (rows - r) * 5 + (5 - (int) (Math.abs(((cols + isles.size())/2) - c))); //find the price for the seat the farther you are from the middle and the farther back you are, the cheaper
						//System.out.println(price + " " + r + " " + c);

						cur.givePrice(price);
						seats[r][c] = cur;
						sat = true; //Customer has been sat
					}
				}
			}
		}
		else {
			int index = 0; //Keep track of which customer we are on
			for (int r = 0; r < rows; r++) {
				for (int c = 0; c < seats[r].length && index < customerList.size(); c++) {		
					if (!isles.contains(c)){
						seats[r][c] = customerList.get(index);
						//System.out.println(index);
						index++;
					}
				}
			}
		}

	}

	/* This method should return true if the seat is occupied, false otherwise.
	 */ 
	public boolean isSeatOccupied(int row, int col)
	{
		if (seats[row][col] == null) {
			return false;
		}
		return true;
	}
	
	public void rearrange() {
		while (this.getCustomersToBeMoved().size() > 0) {
			for (int r = 1; r < seats.length; r++) {
				for (int c = 0; c < seats[r].length; c++) {
					Customer cur = seats[r][c]; //set cur as the current customer
					if (cur != null && seats[r-1][c] != null && cur.getHeight() + 3 < seats[r-1][c].getHeight()) { //is cur is more than 3 inches shorter than the person infront
						int price = seats[r-1][c].getPrice();
						seats[r][c] =  seats[r-1][c];
						seats[r][c].givePrice(cur.getPrice());
						seats[r-1][c] = cur;// we gonna swap them
						seats[r-1][c].givePrice(price);
						
					}
				}
			}
		}
	}

	/* This method should return the row number with the greatest number of occupied seats
	 */
	public int findMostOccupiedRow()
	{
		int max = 0;
		int numR = 0;
		for (int r = 0; r < seats.length; r++) {
			int cur = 0;
			numR = 0;
			for (int c = 0; c < seats[r].length; c++) {
				if (!(seats[r][c] == null)) {
					cur++;
				}
			}
			if (cur > max) {
				max = cur;
				numR = r;
			}
		}
		return numR + 1;
	}    


	/* This method should return the tallest customer in the theater
	 */
	public Customer getTallestCustomer()
	{
		Customer tallest = seats[0][0];
		int max = 0;
		for (int r = 0; r < seats.length; r++) {
			for (int c = 0; c < seats[0].length; c++) {
				if (seats[r][c] != null && seats[r][c].getHeight() > max) { //if the current customer is taller than the previous tallest, we are going to set the tallest as the current customer
					tallest = seats[r][c];
					max = seats[r][c].getHeight();
					
				}
			}
		}
		return tallest;
	}    

	/* This method should return a list of Customers who need to have their seats moved
	 * because there is someone more than 3 inches taller than them sitting directly
	 * in front of them (one row closer, but in the same seat).
	 *
	 * This method does not actually change any seats, but constructs and returns a NEW 
	 * arrayList filled with customers who have someone sitting in front of them that 
	 * is more than 3 inches taller than they are.
	 */
	public ArrayList<Customer> getCustomersToBeMoved()
	{
		ArrayList<Customer> shorts = new ArrayList<>();
		for(int r = 1; r < seats.length; r ++) {
			for (int c = 0; c < seats[r].length; c++) {
				Customer cur = seats[r][c];
				if (cur != null && seats[r-1][c] != null && cur.getHeight() + 3 < seats[r-1][c].getHeight()) {
					shorts.add(cur);
				}
			}
		}
		return shorts;
	}
	
	public void bubSwapper(int c) {
		int len = seats.length;
		Customer temp;
		
		for (int r = 0; r < len - 1; r++) {
			for (int i = 0; i < len - r - 1; r++) {
				if (seats[i][c].getHeight() > seats[i+1][c].getHeight()) {
					temp = seats[i][c];
					seats[i][c] = seats[i+1][c];
					seats[i+1][c] = temp;
				}
				System.out.println("Test " + i );
				System.out.println(this);
			}
		}
		
	}
	
	public void selSwapper(int c) {
		Customer temp;
		int minIn;
		Customer min;
		for (int i = 0; i < seats.length - 1; i++) {
			minIn = 0;
			min = seats[i][c];
			for (int r = i; r < seats.length; r++) {
				if (seats[r][c].getHeight() <= min.getHeight()) {
					min = seats[r][c];
					minIn = r;
				}
			}
			temp = seats[i][c]; 
			seats[i][c] = min;
			seats[minIn][c] = temp;
		}
	}

	/* This method returns a String that can be used to print out the contents 
	 * of the seats in the theater
	 */
	public String toString()
	{

		String output="";
		for (int r = 0; r < seats.length; r++) {
			output += "[" + r + "]";
			for (int c = 0; c < seats[0].length; c++) {
				if (seats[r][c] == null)  {
					output += "{empty}           ";
				}
				else {
					output += seats[r][c];
				}
				
			}
			output += "\n";
		}


		return output;
	}    

}