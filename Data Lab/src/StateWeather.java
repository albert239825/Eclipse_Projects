import java.util.*;
import core.data.*;

public class StateWeather {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Type in State of Interest");
		String stateOfInterest = sc.nextLine();
		stateOfInterest = stateOfInterest.toUpperCase();
		DataSource stns = DataSource.connect("http://weather.gov/xml/current_obs/index.xml");
		stns.load();
		String[] urls = stns.fetchStringArray("station/xml_url");
		String[] states = stns.fetchStringArray("station/state");
		//System.out.println(states.length);
		for (int i = 0; i < states.length; i++) {
			//System.out.println(states[i] + " " + stateOfInterest);
			if (states[i].equals(stateOfInterest)) {
				printWeatherInfo(urls[i]);
			}
		}


	}

	public static void printWeatherInfo(String dataURL) {
		DataSource ds = DataSource.connect(dataURL);
		ds.setCacheTimeout(15);  
		ds.load();
		if (ds.hasFields("temp_f", "weather", "location", "wind_degrees")) {
			String loc = ds.fetchString("location");
			Observation ob1 = ds.fetch("Observation", "weather", "temp_f", "wind_degrees");  
			System.out.println(loc + ":");
			System.out.println(ob1);
		}
	}
}

