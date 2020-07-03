
public class Observation {
	private double temp;
	private int windDegress;
	private String weather;
	
	public Observation(String weather, double temp, int windDegress) {
		this.temp = temp;
		this.windDegress = windDegress;
		this.weather = weather;
	}

	
	
	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public int getWindDegress() {
		return windDegress;
	}

	public void setWindDegress(int windDegress) {
		this.windDegress = windDegress;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}



	public String toString() {
		return "Observation [temp=" + temp + ", windDegress=" + windDegress + ", weather=" + weather + "]";
	}
	
	public int compareTo(Observation o) {
		if (temp > o.getTemp()) {
			return 1;
		}
		else if (temp ==  o.getTemp()){
			return 0;
		}
		else {
			return -1;
		}
	}

	
}
