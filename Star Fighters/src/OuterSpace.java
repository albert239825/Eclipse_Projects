//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OuterSpace extends Canvas implements KeyListener, Runnable
{
	private Ship ship;
	private Alien alienOne;
	private Alien alienTwo;
	private Ammo ammo1;
	private Bullets bullets;
	private AlienHorde horde;
	private int round;
	private int health;
	private int score;
	int money;
	private boolean roundStart;
	private int coolDown;
	private long shoot;
	boolean piercing;


	private boolean[] keys;
	private BufferedImage back;

	public OuterSpace()
	{
		setBackground(Color.black);

		keys = new boolean[6];

		// Task 3: Instantiate Ship
		ship = new Ship(400,500);
		ship.setSpeed(5);

		// Task 5: Instantiate Aliens
		alienOne = new Alien(0,0);
		alienTwo = new Alien(50,0);

		// Task 6: Make an Ammo and Instantiate it
		bullets = new Bullets();
		horde = new AlienHorde(3);
		
		//start health
		health = 10;
		//start rounds
		round = 1;
		//start score
		score = 0;
		//start money
		money = 0;
		//Start shoot
		shoot = 0;
		//Start cooldown
		coolDown = 500;


		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
	}

	public void update(Graphics window)
	{
		paint(window);
	}

	public void paint( Graphics window )
	{
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
			back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		graphToBack.setColor(Color.BLUE);
		graphToBack.drawString("StarFighter ", 25, 50 );
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0,0,800,600);

		if (health> 0) {
			if(keys[0] == true)
			{
				ship.move("LEFT");
			}
			if(keys[1] == true)
			{
				ship.move("RIGHT");
			}
			if(keys[2] == true)
			{
				//ship.move("UP");
			}
			if(keys[3] == true)
			{
				//ship.move("DOWN");
			}
			if(keys[4] == true && System.currentTimeMillis() - shoot > coolDown) {
					Ammo x = new Ammo(ship.getX() + 20, ship.getY());
					bullets.add(x);
					//System.out.println("added");
					shoot = System.currentTimeMillis();
			}
		}
		else {
			graphToBack.setColor(Color.WHITE);
			graphToBack.drawString("Game Over", 300, 300);
		}
		

		// TASK 3: add code to draw Ship


		ship.draw(graphToBack);  // Anything can be drawn like with this same technique

		// Task 5: Instantiate Two Aliens
		//		alienOne.draw(graphToBack);
		//		alienTwo.draw(graphToBack);
		//		alienOne.move("DOWN");
		//		alienTwo.move("DOWN");

		//System.out.println("yes");
		
		bullets.drawEmAll(graphToBack);
		bullets.moveEmAll();
		bullets.cleanEmUp();
		horde.drawEmAll(graphToBack);
		horde.moveEmAll();
		horde.removeDeadOnes(bullets.getList(), this);
		horde.detectPast(this);
		roundStart = keys[5];
		//System.out.println(roundStart + " " + horde.getList().size() );
		if (horde.getList().size() == 0 && roundStart) {
			//System.out.println("yes" + horde.getList().size());
			horde.add(round);
			round++;
			//get good
		}
		
		//UI
		graphToBack.setColor(Color.WHITE);
		graphToBack.drawString("Round: " + round, 0, 25);
		graphToBack.drawString("Health: " + health, 0, 50);
		graphToBack.drawString("Score: " + score, 0, 75);
		graphToBack.drawString("Money: " + money, 0, 100);
		

		//TO-DO:
		//implement rounds and health
		//implement shop
		//implement peircing bullets
		//implement alien health
		// Task 6: Instantiate your Ammo
		// The Ammo should originate in the middle of the ship,
		// so try to make one with a speed of 0 till you get a good location 
		// This will make the game always start by firing a bullet, we will fix that later.
		// call alien.move()

		//add in collision detection to see if Bullets hit the Aliens and if Bullets hit the Ship



		twoDGraph.drawImage(back, null, 0, 0);
	}


	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_F)
		{
			keys[5] = true;
		}
		repaint();
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_F)
		{
			keys[5] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_I && money > 30) {
			money -= 30;
			coolDown -= 100;
		}
		if (e.getKeyCode() == KeyEvent.VK_P && money > 150) {
			money -= 150;
			coolDown += 500;
			piercing = true;
		}
		repaint();
	}

	public void keyTyped(KeyEvent e)
	{
		//no code needed here
	}

	public void run()
	{
		try
		{
			while(true)
			{
				Thread.currentThread().sleep(5);
				repaint();
			}
		}catch(Exception e)
		{
		}
	}
	//Sets the score
	public void setScore (int i) {
		score = i;
	}
	//Adds the score
	public void addScore (int i ) {
		score += i;
	}
	//get the score
	public int getScore() {
		return score;
	}
	
	//Sets the health
	public void SetHealth (int i) {
		health = i;
	}
	//subtracts the health
	public void subtractHealth (int i ) {
		health -= i;
	}
	public void addHealth (int i) {
		health += i;
	}
	//get the health
	public int getHealth() {
		return health;
	}
}

