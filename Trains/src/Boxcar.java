/*
 * AP CS MOOC
 * Term 2 - Assignment 2, Part 1: Boxcar
 * A class which represents a single car on a freight train.
 */

public class Boxcar
{
    // Variables that will be initialized in the Boxcar constructors.
    private String cargo = "";
    private int numUnits;
    private boolean repair;

    // Default constructor that sets the boxcar to "gizmos", 5, and false.
    public Boxcar()
    {
        cargo = "gizmos";
        numUnits = 5;
        repair = false;
    }


    // This constructor sets the cargo variable to the parameter c, but only if
    // c is "gizmos", "gadgets", "widgets", or "wadgets". The constructor ignores
    // the case of of the value in c. If c holds any value other than
    // "gizmos", "gadgets", "widgets", or "wadgets", the constructor sets cargo
    // to "gizmos". The numUnits variable is set to the parameter u. If u is less than
    // 0 or higher than the maximum capacity of 10 units, numUnits is set to 0. The repair
    // variable is set to the parameter r. If repair is true, numUnits is set to 0
    // no matter what value is stored in the u parameter.
    public Boxcar(String c, int u, boolean r)
    {
    	//Sets c to lowercase to ignore case
    	c = c.toLowerCase();
    	//Checks that c is equal to one of the allowed cargo types
    	if (c.equals("gizmos") || c.equals("gadgets") || c.equals("widgets") || c.equals("wadgets")) {
    		cargo = c;
    	}
    	//if c is not an allowed type, set to gizmos
    	else {
    		cargo = "gizmos";
    	}
        numUnits = u;
        repair = r;
        //checks if repair is true or the num units is out of range
        if (repair || numUnits < 0 || numUnits > 10) {
        	numUnits = 0;
        }
    }

    // The toString method returns a String with the Boxcar in the format:
    // 5 gizmos    in service
    // 10 widgets    in service
    // 0 gadgets    in repair
    //
    // Notice there is one space in between the number of units and the cargo
    // and a tab between the value for cargo and "in repair"/"in service"
    public String toString()
    {
    	String result = numUnits + " " + cargo + "	";
    	if (repair) {
    		result += "in repair";
    	}
    	
    	else {
    		result += "in service";
    	}
        return result;
    }

    // This method adds 1 to the number of units in the BoxCar. The maximum
    // capacity of a boxcar is 10 units. If increasing the number of units
    // would go beyond the maximum, keep numUnits at the max capacity.
    // If the repair variable is true, then numUnits may only be set to 0.
    public void loadCargo() {
    	if (repair) {
    		numUnits = 0;
    	}
    	else if (numUnits < 10){
    		numUnits++;
    	}
    }

    // The getCargo method returns the cargo of the boxcar.
    public String getCargo()
    {
        return cargo;
    }

    // The setCargo method sets the cargo type of the boxcar. The cargo variable is
    // set to c only if c is "gizmos", "gadgets", "widgets", or "wadgets".
    // The method ignores the case of of the value in c. If c holds any value other than
    // "gizmos", "gadgets", "widgets", or "wadgets" (ignoring case), the method sets cargo
    // to "gizmos".
    public void setCargo(String c)
    {
    	//Sets c to lower case to ignore the case
    	c = c.toLowerCase();
    	//Checks that c is equal to one of the allowed cargo types
    	if (c.equals("gizmos") || c.equals("gadgets") || c.equals("widgets") || c.equals("wadgets")) {
    		cargo = c;
    	}
    	//if c is not an allowed type, set to gizmos
    	else {
    		cargo = "gizmos";
    	}
    }

    // The isFull method returns true if numUnits is equal to 10, false otherwise.
    public boolean isFull()
    {
    	//if the numUnits has reached the max amount (10), return true
        if (numUnits == 10) {
        	return true;
        }
        return false;
    }

    // The callForRepair method sets the variable repair to true, and numUnits to 0.
    public void callForRepair()
    {
    	//Sets repair to true and sets numUnits to 0
        repair = true;
        numUnits = 0;
    }
    
    //Returns whether the box car is in repair
    public boolean getRepair() {
    	return repair;
    }
}
