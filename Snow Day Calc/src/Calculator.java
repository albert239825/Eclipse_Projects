//import java.awt.event.MouseListener;
//import java.awt.event.MouseEvent;
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.Font;
//import java.awt.FontMetrics;
//import java.awt.Graphics;
//import java.awt.Toolkit;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//import javax.swing.Timer;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.Random;
//import java.util.Scanner;


import java.util.*;



import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import org.json.JSONArray;


public class Calculator {
	String url;
	String api;
	String city;
	int zip;
	String country;
	String desc = "";
	double kTemp = 0;
	double snowfall = 0;
	//ArrayList
	
	public Calculator () {
	
		//String url = "";
		String api = "c68efca39e0f3c144cd1760e9f7c60cc";
		String city = "";
		int zip = 0;
		String country = "";
		
		Scanner in  = new Scanner (System.in);
		System.out.println("Please put in City or Zip");
		String input = in.nextLine();
		try {
			zip = Integer.parseInt(input);
		}
		catch (Exception e) {
			city = input;
			System.out.println("Please Input Country Code");
			country = in.nextLine();
		}
		
		System.out.println(zip);
		System.out.println(city);
		System.out.println(country);
		if (zip != 0) {
			url = "http://api.openweathermap.org/data/2.5/forecast?zip="+zip+","+country+"&appid="+api;
		}
		else {
			url = "http://api.openweathermap.org/data/2.5/forecast?q="+city+","+country+"&appid="+api;
		}
		
		
		try {
			System.out.println(url);
			getWeatherInfo();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void getWeatherInfo() throws Exception {
		System.out.println(url);
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		// optional default is GET
		con.setRequestMethod("GET");
		//add request header
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		//print in String
		System.out.println(response.toString());
		//Read JSON response and print
		JSONObject myResponse = new JSONObject(response.toString());

		System.out.println("-----------");
		city = myResponse.getString("name");
		System.out.println("City - "+myResponse.getString("name"));
		JSONArray arr = myResponse.getJSONArray("weather");

		JSONObject myobj = arr.optJSONObject(0);

		desc = myobj.getString("main");//main description

		JSONObject myobj2 = myResponse.getJSONObject("main");
		JSONObject myobj3 = myResponse.getJSONObject("snow");
		
		System.out.println("Temp- "+myobj2.getString("temp"));
		kTemp = Double.parseDouble(myobj2.getString("temp"));
		snowfall = Double.parseDouble(myobj3.getString("3h"));

		System.out.println("Farenheit- D: " + (int)kTemp  );
	}
	

}

