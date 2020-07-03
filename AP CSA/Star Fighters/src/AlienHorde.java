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

public class AlienHorde
{
	private List<Alien> aliens;

	public AlienHorde(int size)
	{
		
		// Initialize aliens
		aliens = new ArrayList<Alien>();
			// Don't use size here, you want aliens to have a size of 0 and then add the right number of aliens beneath this comment
		int x = 25;
		int y = 50;
		for (int i = 0; i < size; i++) {
			if (x >= StarFighter.WIDTH) {
				x = 25;
				y+= 50;
			}
			Alien cur = new Alien(x,y);
			aliens.add(cur);
			x += 50;
		}

		// After you initialize aliens, you need to make rows of Aliens until you have the appropriate number

		// I started at 25,50 - Had a Gap of 75 between each Alien, 
		// To Move to the next row you can compare X to StarFighter.WIDTH
	}
	public void add(int round) {
		int x = 25;
		int y = 50;
		int size = round * 5;
		int health = round / 5 + 1;
		while (size > 50) {
			System.out.println("done");
			size = size/ 2;
		}

		for (int i = 0; i < size; i++) {
			System.out.println("Loop happens");

			if (x >= StarFighter.WIDTH) {
				x = 25;
				y+= 50;
			}
			Alien cur = new Alien(x,y, 2, health);
			System.out.println(health);
			System.out.println(cur);
			aliens.add(cur);
			x += 75;
		}
	}

	public void add(Alien al)
	{
	}

	public void drawEmAll( Graphics window )
	{
		for (Alien x: aliens) {
			x.draw(window);
		}
	}

	// Move them each DOWN
	public void moveEmAll()
	{
		for (Alien x : aliens) {
			x.move("DOWN");
		}
	}

	// Task 10
	public void removeDeadOnes(List<Ammo> shots, OuterSpace outer)
	{
		for (int i = 0; i < aliens.size(); i++) {
			for (int j = 0; j < shots.size(); j++) {
				if (aliens.get(i).beenShot(shots.get(j))) {
					aliens.get(i).health--;
					if (aliens.get(i).health <= 0) {
						aliens.remove(i);
						i--;
					}
					if (!outer.piercing) {
						shots.remove(j);
						j--;
					}
					outer.addScore(1);
					outer.money++;
					//System.out.println(outer.getScore());
					break;
				}
			}
		}
	}
	
	public void detectPast(OuterSpace outer) {
		for (int i = 0; i < aliens.size(); i++) {
			Alien cur = aliens.get(i);
			if (cur.getY() > 500) {
				//System.out.println("yes");
				aliens.remove(i);
				outer.subtractHealth(1);
			}
		}
	}
	public List<Alien> getList() {
		return aliens;
	}

	public String toString()
	{
		return "";
	}
}
