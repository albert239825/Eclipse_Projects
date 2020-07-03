import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import WeatherBoard.TAdapter;

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
//
//import javax.swing.ImageIcon;
//import javax.swing.JPanel;
//import javax.imageio.*;
//import java.awt.image.*;
//import java.io.*;
//import java.util.*;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import org.json.simple.JSONObject;
//import org.json.simple.JSONArray;


public class WeatherBoard  extends JPanel implements Runnable, MouseListener
{
	String API = "17e97a13bdf4a6b3671c5600bdac2522";


	String url = "";
	String message = "";
	double kTemp = 0.0;//temperature in Kelvin
	String desc = "";
	String city = "";
	//<--------- key variables above

	boolean ingame = true;
	private Dimension d;
	int BOARD_WIDTH=500;
	int BOARD_HEIGHT=500;
	int x = 0;
	BufferedImage img;

	private Thread animator;



	public WeatherBoard()
	{
		addKeyListener(new TAdapter());
		addMouseListener(this);
		setFocusable(true);
		d = new Dimension(BOARD_WIDTH, BOARD_HEIGHT);
		setBackground(Color.black);

		System.out.println("Enter your zip code: ");

		Scanner in = new Scanner (System.in);
		String zip = in.next();
		url = "http://a...content-available-to-author-only...p.org/data/2.5/weather?q="+zip+"&appid="+API;
		url = "http://api.openweathermap.org/data/2.5/weather?zip="+zip+",us&appid="+API;  

		try {
			getWeatherInfo(zip);
			//TASK 2
			//F = 1.8 x (K - 273) + 32.
			double Fahr = 1.8 * (kTemp - 273) + 32;
			//C = K - 273.
			double Celsius = kTemp - 273;
			//Convert kTemp to Farenheit and Celsius
			message = city + ": " + desc + " Fahr: " + (int) Fahr +  " Celsius: " + (int) Celsius;
		} catch (Exception e) {
			e.printStackTrace();
		}



		try {
			//Task 3
			//download weather icons and save them to same folder where this project resides
			//associate the appropriate image with the appropriate description
			//desc variables holds the one word descriptions
			//just get the app to work with these words. If it returns anything else make that the default return.
			//Rain, Snow, Clear, Sunny, Clouds
			String w = "";
			String r = "";
			String c = "";
			String s = "";
			String cl = "";
			String d = "";
			if(desc.equals("Sunny")){
				w = "wicons/sunny.png";
				img = ImageIO.read(this.getClass().getResource(w));
			}
			else if(desc.equals("Rain")){
				r= "wicons/rainy.png";
				img = ImageIO.read(this.getClass().getResource(r));
			}

			else if(desc.equals("Clear")){
				c= "wicons/clear.png";
				img = ImageIO.read(this.getClass().getResource(c));
			}
			else if(desc.equals("Snow")){
				r= "wicons/snow.png";
				img = ImageIO.read(this.getClass().getResource(s));
			}
			else if(desc.equals("Clouds")){
				r= "wicons/cloudy.png";
				img = ImageIO.read(this.getClass().getResource(cl));
			}
			else{
				d = "wicons/partly_cloudy.png";
				img = ImageIO.read(this.getClass().getResource(d));
			}



			//That's it... no need to go below this line unless you'd like to customize
		} catch (IOException e) {
			System.out.println("Image could not be read");
			// System.exit(1);
		}

		if (animator == null || !ingame) {
			animator = new Thread(this);
			animator.start();
		}


		setDoubleBuffered(true);
	}

	public void paint(Graphics g)
	{
		super.paint(g);

		g.setColor(Color.white);
		g.fillRect(0, 0, d.width, d.height);

		Font small = new Font("Helvetica", Font.BOLD, 24);
		FontMetrics metr = this.getFontMetrics(small);
		g.setColor(Color.black);
		g.setFont(small);
		g.drawString(message, 10, d.height/2);



		g.drawImage(img,0,0,200,200 ,null);




		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}
	private class TAdapter extends KeyAdapter {

		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();

		}

		public void keyPressed(KeyEvent e) {
			//System.out.println( e.getKeyCode());
			// message = "Key Pressed: " + e.getKeyCode();
			int key = e.getKeyCode();
			if(key==39){

			}



		}

	}




	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();

	}

	public void mouseReleased(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mouseClicked(MouseEvent e) {

	}

	public void run() {

		long beforeTime, timeDiff, sleep;

		beforeTime = System.currentTimeMillis();
		int animationDelay = 50;
		long time =
				System.currentTimeMillis();
		while (true) {//infinite loop
			// spriteManager.update();
			repaint();
			try {
				time += animationDelay;
				Thread.sleep(Math.max(0,time -
						System.currentTimeMillis()));
			}catch (InterruptedException e) {
				System.out.println(e);
			}//end catch
		}//end while loop




	}//end of run

	public void getWeatherInfo(String zip) throws Exception {

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
		System.out.println("Temp- "+myobj2.getString("temp"));
		kTemp = Double.parseDouble(myobj2.getString("temp"));

		System.out.println("Farenheit- D: " + (int)kTemp  );
	}

}