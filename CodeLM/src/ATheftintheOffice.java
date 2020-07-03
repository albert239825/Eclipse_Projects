/*
Mr. Swope’s precious blue felt-tip pens keep getting stolen from his desk, making it hard for him to focus on developing the latest time 
travelling technology. He wants you to figure out who’s stealing his pens by deducing who passes by his desk during their lunch break. 
He also knows that since everyone at New Wave is super efficient, they’ve all mapped out the fastest route from the break room to their desk. 
Given a layout of the office, figure out which employee is passing by Mr. Swope’s desk and swiping his pens.

Sample data to copy into the input stream:

1. 
    # - $ L|* - * *|- R * N|- G - -
    Jon Long, Terry Nedson, Harry Ronaldo, George Gunn
    
    output: Jon Long

2.
    Z * Q - -|- - - * -|# * - * R|- - T * *|D * $ - *|* * - - M
    Joe Reed, Max Thompson, Karl Marx, Jim Davis, Hans Zieber, Flynn Quilvisk
    
    output: Karl Marx

3.
    A * D * - G|- - - * $ -|* * - # - *|* T - - - S
    Farid Stephan, Armando Daibhi, Fiorenza Tertius, Gligor Albin, Larry Goodman

    output: Larry Goodman

*/


import java.util.*;

class ATheftintheOffice {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		String[] intermediate = s.nextLine().split("[|]");
		
		//office is the two dimensional array of strings representing the office.
		String[][] office = new String[intermediate.length][];
		
		for(int i = 0; i< intermediate.length; i++) {
			office[i] = intermediate[i].split(" ");
		}
		
		//names is a one dimensional array of strings containing the names of employees in the office.
		String[] employees = s.nextLine().split(", ");
		
		//System.out.println(print2d(office));
		//System.out.println(Arrays.toString(employees));
		
		HashMap<String, Integer[]> locations = new HashMap<>();
		HashMap<String, String> initialsRef = new HashMap<>();
		ArrayList<String> initals = new ArrayList<>();
		int[] swopeLoc = new int[2];
		
		for (String emp : employees) {
			String ini = emp.substring(emp.indexOf(" ") + 1, emp.indexOf(" ") + 2);
			initialsRef.put(ini, emp);
			initals.add(ini);
		}
		
		for (int r = 0; r < office.length; r++) {
			for (int c = 0; c < office[r].length; c++) {
				if (office[r][c].equals("$")) {
					swopeLoc[0] = r;
					swopeLoc[1] = c;
				}
				else if (initals.contains(office[r][c])) {
					locations.put(office[r][c], new Integer[] {r, c});
					//System.out.println(r + " " + c + " " + office[r][c]);
				}
			}
		}
		//System.out.println(locations.keySet());
		
		for (String key : locations.keySet()) {
			ArrayList<Integer[]> path = new ArrayList<>();
//			if (isThief(locations.get(key), office, path, swopeLoc)) {
//				System.out.println(initialsRef.get(key));
//			}
		}
		
		
	}
	
//	static boolean isThief(Integer[] loc, String[][] office, ArrayList<Integer[]> path, int[] swopeLoc) {
//		fastestPath(loc[0], loc[1], office, path, swopeLoc);
//	}
//	
//	static String[] fastestPath(int r, int c, String[][] office, ArrayList<Integer[]> path, int[] swopeLoc) {
//		
//	}
	
	
	
	public static String print2d(String[][] input) {
		return Arrays.deepToString(input).replace("], ", "]\n").replace("[[", "[").replace("]]", "]");
	}
}