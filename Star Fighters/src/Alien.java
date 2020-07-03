//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Alien extends MovingThing
{
	private int speed;
	private Image image;
	int health;

	public Alien()
	{
		this(0,0,30,30,2,1);
	}

	public Alien(int x, int y)
	{
		this(x,y,30,30,2,1);
	}
	

	public Alien(int x, int y, int s, int hel)
	{
		this(x,y,30,30,s, hel);
	}

	public Alien(int x, int y, int w, int h, int s, int hel)
	{
		super(x, y, w,h);
		speed=s;
		health = hel;
		try
		{
			URL url = getClass().getResource("alien.jpg");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			//feel free to do something here
		}
	}

	public void setSpeed(int s)
	{
	   this.speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}

   public void move(String direction)
	{
	   if(direction.equals("DOWN"))
		{
		   //System.out.println("Yes");
		   // If I go off the right OR off the left side of the screen
		   if(getX() > StarFighter.WIDTH  || getX() < 0) // YOU MUST ADD LEFT HERE
		   {
			   setSpeed(-getSpeed());
			   setY(getY() + 50);
			   	// My Speed Reverses (so I go the other direction)
		   		// The Y moves down 25 pixels - use SetY(number)   
		   }
		   //System.out.println(getSpeed());
		   setX(getX()+getSpeed());
		   // Move the X position - use SetX(_____)
			
		}	
	}

	public void draw( Graphics window )
	{
   	window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}

	public String toString()
	{
		return "";
	}
	public boolean beenShot(Ammo am) {


		if ((am.getX() >= this.getX() && am.getX() <= this.getX()+60) ||
				(am.getX()+10 >= this.getX() && am.getX()+10 <= this.getX()+60))
			if ((am.getY() >= this.getY() && am.getY() <= this.getY()+60) ||
					(am.getY()+10 >= this.getY() && am.getY()+10 <= this.getY()+60))
			{
				return true;

			}
		return false;
	}
}
