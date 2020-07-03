import java.util.*;
import core.data.*;
public class Runner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("what location would you like to get data from?");
		String id1 = sc.nextLine();
		String id2 = sc.nextLine();
		String id3 = sc.nextLine();
		
		
		DataSource ds1 = DataSource.connect("http://weather.gov/xml/current_obs/" + id1 + ".xml"); 
		DataSource ds2 = DataSource.connect("http://weather.gov/xml/current_obs/" + id2 + ".xml"); 
		DataSource ds3 = DataSource.connect("http://weather.gov/xml/current_obs/" + id3 + ".xml"); 
		ds1.setCacheTimeout(15);  
		ds1.load();
		ds2.setCacheTimeout(15);  
		ds2.load();
		ds3.setCacheTimeout(15);  
		ds3.load();
		
		Observation ob1 = ds1.fetch("Observation", "weather", "temp_f", "wind_degrees");    
		Observation ob2 = ds1.fetch("Observation", "weather", "temp_f", "wind_degrees"); 
		Observation ob3 = ds1.fetch("Observation", "weather", "temp_f", "wind_degrees"); 
		
		Observation Coldest = ob1;
		DataSource ColdestData = ds1;
	    if (Coldest.compareTo(ob2) > 0) {
	    	Coldest = ob2;
	    	ColdestData = ds2;
	    }
	    if (Coldest.compareTo(ob3) > 0) {
	    	Coldest = ob3;
	    	ColdestData = ds3;
	    }
	    
	    String loc = ColdestData.fetchString("location");
	    System.out.println(loc + " is the coldest. its information is " + Coldest);
	}
}
