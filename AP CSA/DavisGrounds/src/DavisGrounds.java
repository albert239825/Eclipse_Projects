import java.util.*;
public class DavisGrounds {
	Animal[][] davisGrounds;

	public DavisGrounds() {
		davisGrounds = new Animal[5][8];
	}

	public DavisGrounds(int r, int c) {
		davisGrounds = new Animal[r][c];
	}
	
//I made this a boolean so that it would return whether it worked or not
	public boolean Fill(ArrayList<Animal> animals) {
		//It is going to try the grid area times 2 times max
		//if not, it is going to give up and try with a new first animal location
		
		//Number of times switching the first animal
		int totalTries = 0;
		//Number of times trying each animal
		int localTries = 0;
		
		//Test bed Grid
		Animal[][] test = new Animal[davisGrounds.length][davisGrounds[0].length];
		//Location trying to place
		int r = (int) (Math.random() * davisGrounds.length);
		int c = (int) (Math.random() * davisGrounds.length);
		
		//boolean to check whether the process was successful
		boolean success = false;
		
		while (!success && totalTries <= 10) {
			//reset after a new try
			test = new Animal[davisGrounds.length][davisGrounds[0].length];
			//System.out.println("trying");
			for (int i = 0; i < animals.size(); i++) {
				localTries = 0;
				Animal cur = animals.get(i);
				//System.out.println(cur);
				while (!validSpace(r,c,cur, test) && localTries < 2*davisGrounds.length*davisGrounds[0].length) {
					r = (int) (Math.random() * davisGrounds.length);
					c = (int) (Math.random() * davisGrounds.length);
					localTries++;
				}
				
				if (localTries >= 2*davisGrounds.length*davisGrounds[0].length) {
					//System.out.println("failed");
					break;
				}
				//System.out.println("added " + r + " " + c);
				test[r][c] = cur;
				if (i == animals.size() - 1) {
					success = true;
					//System.out.println("success");
				}
			}
			totalTries++;
		}
		if (success) {
			davisGrounds = test;
			System.out.println(this);
			return true;
		}
		else {
			System.out.println("code could not find viable solutions. Could be impossible or very unlikely");
			return false;
		}
	}
	
	//Call entertain on all animal in the zoo
	public void entertainAll() {
		for (int row = 0; row < davisGrounds.length; row++) {
			for (int col = 0; col < davisGrounds[0].length; col++) {
				if (davisGrounds[row][col] != null) {
					System.out.println("entertained");
					davisGrounds[row][col].entertainment(this, row, col);
					//After entertainment we must check whether it is still a valid space for the animal. Null check is due to the fact the flies can die
					if (davisGrounds[row][col] != null && !validSpace(row, col, davisGrounds[row][col], davisGrounds)) {
						System.out.println("This is no longer a valid space for " + davisGrounds[row][col]);
					}
				}
			}
		}
		System.out.println(this);
	}
	
	//print out the zoo
	public String toString() {	
		String result = "";
		for(int i = 0; i<davisGrounds.length; i++){
			result += "[";
		    for(int j = 0; j<davisGrounds[0].length; j++){
		    	if (davisGrounds[i][j] != null) {
		    		result += davisGrounds[i][j].toString();
		    	}
		    	else {
		    		result += "null";
		    	}
		    	if (j != davisGrounds[0].length - 1) {
		    		result += ", ";
		    	}
		    }
		    result += "]\n";
		}
		return result;
	}
	
	//returns whether the stop is a valid space
	boolean validSpace(int r, int c, Animal cur, Animal[][] grid) {
		int curIntim = cur.getIntimidation();
		//System.out.println("testing");
		//Second argument is because later we will be checking whether it is a valid space after entertainment. Will always return false because will think space is occupied
		if (grid[r][c] != null && !grid[r][c].equals(cur)) {
			//System.out.println("error");
			return false;
		}
		//if on the edge
		if ((r == 0 || c == 0 || r == grid.length - 1 || c == grid[0].length - 1)) {
			if (!cur.isLikesPeople()) {
				return false;
			}
		}
		//checking the intimdation of all around
		if (intimcheck(r + 1, c, curIntim, grid) && intimcheck(r + 1, c + 1, curIntim, grid) && 
				intimcheck(r + 1, c - 1, curIntim, grid) && intimcheck(r, c + 1, curIntim, grid) 
				&& intimcheck(r, c - 1, curIntim, grid) && intimcheck(r - 1, c, curIntim, grid) 
				&& intimcheck(r - 1, c - 1, curIntim, grid) && intimcheck(r - 1, c + 1, curIntim, grid)) {
			return true;
		}
		return false;
			
	}
	
	//check that the animal will not be intimidated
	boolean intimcheck (int r, int c, int curIntim, Animal[][] grid) {
		//if it goes out of bounds, that means the original animal was on the edge. 
		if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) {
			return true;
		}
		if (grid[r][c] == null || Math.abs(curIntim - grid[r][c].getIntimidation()) <= 2) {
			return true;
		}
		return false;
	}
	
	public Animal[][] getGrid() {
		return davisGrounds;
	}
	public void setGrid(Animal[][] grid) {
		davisGrounds = grid;
	}
	
}
