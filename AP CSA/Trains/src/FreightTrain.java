/*
 * AP CS MOOC
 * Term 2 - Assignment 2, Part 2: FreightTrain
 * A class which represents a freight train with multiple boxcars.
 */

import java.util.ArrayList;

public class FreightTrain
{
	// An ArrayList that stores a train with multiple boxcars
	private ArrayList<Boxcar> train = new ArrayList<Boxcar>();

	// Default constructor that sets train to an ArrayList holding one
	// boxcar containing 5 gizmos, that is not in repair.
	public FreightTrain()
	{
		Boxcar cur = new Boxcar();
		train.add(cur);

	}

	// A constructor that sets train to an ArrayList of size n, holding
	// n boxcars, that are all hold 5 gizmos and are not in repair. If n <= 0,
	// then the train should be set to size one, with a single boxcar containing
	// 5 gizmos and not in repair.
	public FreightTrain(int n)
	{
		Boxcar cur = new Boxcar();
		if (n <= 0) {
			train.add(cur);
		}
		else {
			for (int i = 0; i < n; i++) {
				cur = new Boxcar();
				train.add(cur);
			}
		}
	}

	// This method returns a String representation of the
	// Boxcar objects in the ArrayList, one per line. For example,
	// here is the String returned when toString is called on a
	// FreightTrain with 5 boxcars:
	//
	// 3 gadgets    in service
	// 2 wadgets    in service
	// 0 gizmos    in repair
	// 7 gadgets    in service
	// 0 gadgets    in repair
	//
	// Note: there is one space between the number of units and
	// the cargo type, and a tab between the cargo type and
	// "in repair"/"in service".
	public String toString()
	{
		String result = "";
		//prints out entire train by printing out each boxcar
		for (int i = 0; i < train.size(); i++) {
			result += train.get(i).toString();
			result += "\n";
		}
		return result;
	}

	// This method sets the cargo type of all the boxcars in the entire train.
	public void setCargo(String c)
	{
		for (int i = 0; i < train.size(); i++) {
			//Sets each boxcar's cargo to c
			Boxcar cur = train.get(i);
			cur.setCargo(c);
			train.set(i, cur);
		}
	}

	// This method sets the boxcars to the pattern "gizmos", "gadgets", "widgets",
	// "wadgets", "gizmos", "gadgets", "widgets", "wadgets", ...
	// until the end of the train.
	public void setMultiCargo()
	{
		for (int i = 0; i < train.size(); i++) {
			Boxcar cur = train.get(i);
			//if index has remainder 0 when divided by four, it is the beginning of the pattern, therefore gizmos
			//Same idea applies for the other cases just with different remainders
			if (i % 4 == 0) {
				cur.setCargo("gizmos");
			}
			else if (i % 4 == 1) {
				cur.setCargo("gadgets");
			}
			else if (i % 4 == 2) {
				cur.setCargo("widgets");
			}
			else if (i % 4 == 3) {
				cur.setCargo("wadgets");
			}
			train.set(i, cur);
		}
	}

	// This method fills every boxcar in the train to max capacity of 10.
	// Each individual boxcar can only hold cargo if its
	// repair variable is false.
	public void fillTrain()
	{
		for (int i = 0; i < train.size(); i++) {
			Boxcar cur = train.get(i);
			if (!cur.getRepair()) {
				while(!cur.isFull()) {
					cur.loadCargo();
				}
			}
			train.set(i, cur);
		}
	}

	// This method sets the Boxcar at location i’s repair variable to true.
	public void callForRepair(int i)
	{
		Boxcar cur = train.get(i);
		cur.callForRepair();
		train.set(i, cur);
	}
}
