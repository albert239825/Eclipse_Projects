import java.util.*;

public class RecalledHardware {

	static Scanner s = new Scanner(System.in);
    
	public static void main(String[] args) {
		String serialNumber = s.next();      // An 11 character serial number.
		
		// code to solve the problem.  You can write and call other methods as well.
		
		String State = serialNumber.substring(0,2);
	    String factory = serialNumber.substring(2,3);
	    int month = Integer.parseInt(serialNumber.substring(3,5));
	    int year = Integer.parseInt(serialNumber.substring(5,7));
	    String iden = serialNumber.substring(7,11);
	    //System.out.println(iden);
	    iden = convert(iden);
	    
	    int identi = Integer.parseInt(iden);
	    
	    int date = year*12 + month;
	    
	    
	    //System.out.println(month + " " + year);
	    
	    if (palen(iden)) {
	    	System.out.println("false");
	    }
	    
	    else if (State.equals("PA") && factory.equals("6")) {
	    	System.out.println("true");
	    }
	    else if (State.equals("NJ") && date > 15*12 + 11 && date < 16*12 + 2 ) {
	    	System.out.println("true");
	    }
	    
	    else if ((State.equals("AK") || State.equals("NY")) && month == 10 && year == 16) {
	    	if (identi % 9 == 0 && identi % 27 != 0) {
	    		System.out.println("false");
	    	}
	    	else {
	    		System.out.println("true");
	    	}
	    }
	    
	    else {
	    	System.out.println("false");
	    }                // print your answer and just your answer.
	}
	
	public static String convert(String iden) {
		String output = "";
		for (int i = 0; i < iden.length(); i++) {
			if (iden.charAt(i) > '9') {
				output += (int) iden.charAt(i);
			}
			else {
				output += iden.charAt(i);
			}
		}
		//System.out.println(output);
		return output;
	}
	public static boolean palen(String in) {
		for (int i = 0; i < in.length() / 2; i++) {
			if (!in.substring(i, i + 1).equals(in.substring(in.length() - i - 1, in.length() - i))) {
				return false;
			}
		}
		return true;
	}
	
	//static boolean between

}
