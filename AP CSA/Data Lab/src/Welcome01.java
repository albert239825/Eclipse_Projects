
import java.util.Scanner;

import core.data.*;

public class Welcome01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("what airport would you like to get data from?");
		String airport = sc.nextLine();
		String id = "K" + airport;
		
		DataSource ds = DataSource.connect("http://weather.gov/xml/current_obs/" + id + ".xml"); 
		ds.setCacheTimeout(15 * 60);  
		ds.load();
		//ds.printUsageString();
		float temp = ds.fetchFloat("temp_f");
		String loc = ds.fetchString("location");
		System.out.println("The temperature at " + loc + " is " + temp + "F");
	}
}