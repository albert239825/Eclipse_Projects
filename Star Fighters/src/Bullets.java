//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class Bullets
{
	private List<Ammo> ammo;

	public Bullets()
	{
		ammo = new ArrayList<Ammo>();
	}

	public void add(Ammo al)
	{
		ammo.add(al);
	}

	//post - draw each Ammo
	public void drawEmAll( Graphics window )
	{
		for (Ammo x : ammo) {
			x.draw(window);
			//System.out.println("Drawn");
		}
	}

	public void moveEmAll()
	{
		for (Ammo x : ammo) {
			x.move("UP");
			//System.out.println("Moved");
		}
	}

	public void cleanEmUp()
	{
		for (int i = 0; i < ammo.size(); i++) {
			Ammo x = ammo.get(i);
			if (x.getY() > StarFighter.HEIGHT - x.getHeight()  || x.getY() < 0) {
				ammo.remove(x);
				//System.out.println("removed");
			}
		}

	}

	public List<Ammo> getList()
	{
		return ammo;
	}

	public String toString()
	{
		return "";
	}
}
