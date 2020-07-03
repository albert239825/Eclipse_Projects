
public class Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String animal = "Elephant";
		
		int len = animal.length(); 
		
		//System.out.println(len);
		
		//SubString(FirstIndex, LastIndex) Gives you substring of chars 
		//from the first index to the last index (non-inclusive on the upper end
		for (int i = 0; i < len; i++) {
			String str = animal.substring(i);
			
			//System.out.println(str);
			
		}
		
		animal = animal.toLowerCase();
		
		//If it does not exist you get -1
		int loc = 0 ;
		animal += "e";
		loc = 0;
		while (loc < animal.length() && loc >= 0) {
			loc++;
			loc = animal.indexOf('e', loc);
			System.out.println(loc);
		}
	}

}
