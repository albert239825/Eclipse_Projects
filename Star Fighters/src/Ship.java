//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Ship extends MovingThing
{
	private int speed;
	private Image image;

	public Ship()
	{
		this(10,10,50,50,10);
	}

	public Ship(int x, int y)
	{
		this(x,y,50,50,10);
	   //add code here
		// Must call the THIS Constructor, look at the example above
	}

	public Ship(int x, int y, int s)
	{
	   //add code here
		// Must call the THIS Constructor, look at the example above
		this(x,y,50,50,s);

	}

	public Ship(int x, int y, int w, int h, int s)
	{
		super(x, y, w, h);
		speed=s;
		try
		{
			URL url = getClass().getResource("ship.jpg");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			//feel free to do something here
		}
	}


	public void setSpeed(int s)
	{
	   speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void move(String direction)
	{
		if(direction.equals("RIGHT")) {
			setX(getX() + getSpeed());
		}
		if(direction.equals("LEFT"))
			setX(getX()-getSpeed());
		
		if(direction.equals("UP")) {
			setY(getY() - getSpeed());
		}
		if(direction.equals("DOWN")) {
			setY(getY() + getSpeed());
		}
	}

	public void draw( Graphics window )
	{
		window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
