import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Student
{
    String dob;
    String fullName;
    int gYear;
    final static int YEAR_FOUNDED = 1785;
    
    public Student(){
        
    }
   
    public Student(int g, String name,String dob)
    {
       gYear = g;
       fullName = name;
       this.dob = dob;
       
    }
    
    
    
    public String createUsername(){
    	int grad = gYear % 100;
		int loc = 1;
		int last = 0;
		ArrayList<String> list_Names = new ArrayList<>();
		while (loc < fullName.length() && loc > 0) {
			loc = fullName.indexOf(' ', loc) + 1;
			//System.out.println(loc);
			if (loc > 0) { //Seperate names into arraylist
				String curName = fullName.substring(last, loc - 1);
				list_Names.add(curName); 
			}
			else {
				list_Names.add(fullName.substring(last, fullName.length()));
				
			}
			last = loc;
		}
		String first = list_Names.get(0);                                    //						I	I	U	--------|
		String lastN = list_Names.get(list_Names.size()-1);//										N	Z	F			|
		String Middle = "";//																		I	I	F			|
		String last4;//																				T	N				|
		String firstMid = "";//																		I	G				|														
		String Username;//																			A					|
		char firstMidChar = 0;//																	L	S				|
		char firstInitalChar = 0;//																	-	T		--------|
		
		if (list_Names.size() >=3) {
			Middle = list_Names.get(1); //Middle name if there is
		}
		
		
		if (lastN.length() >= 5) {
			last4 = lastN.substring(0,4); //if the last name is more than 4 letters make 4 letters
		}
		else {
			last4 = lastN;
		}
		System.out.println(list_Names);
		String firstInital = first.substring(0,1);
		firstInitalChar = first.charAt(0);
		if (firstInitalChar >= 96) {
			firstInitalChar -= 32; //make uppercase
		}
		
		if (!Middle.equals("")) {
			firstMid = Middle.substring(0,1);//Get first initial of middle
			firstMidChar = Middle.charAt(0);
		}
		
		if (firstMidChar >= 96) {
			firstMidChar -= 32; //make uppercase
		}
		
		if (grad < 10) {
			Username = last4 + firstInitalChar + firstMidChar + "0" + grad; //for 02 and stuff
		}
		else {
			Username = last4 + firstInitalChar + firstMidChar + grad; //formatting
		}
        
        return Username;
    }
    
    public int getAge(){
    	int month = Integer.parseInt(dob.substring(0,2));
    	int day = Integer.parseInt(dob.substring(3,5));
    	int year = Integer.parseInt(dob.substring(6,dob.length()));
    	
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        String dd = dateFormat.format(date);
        System.out.println(dd);
        
    	int curMonth = Integer.parseInt(dd.substring(0,2));
    	int curDay = Integer.parseInt(dd.substring(3,5));
    	int curYear = Integer.parseInt(dd.substring(6,dd.length()));
    	
    	int age = curYear - year -1;
    	if (curMonth > month) {
    		age++;
    	}
    	else if (curMonth == month && curDay > day) {
    		age++;
    	}
    	
    	
    	return age;
    }
}