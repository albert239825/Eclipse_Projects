import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Project created by: Mr Ruth .. Niles North High School .. Skokie, IL ..
 * www.MrRuth.com modified for 2013
 * 
 * ~~~~~~~~~~~~~~~~~~~~~ TronGame ~~~~~~~~~~~~~~~~~~~~~<br>
 * <xmp><code><pre>
 * Task 0 .. 
 * Create a TronGame project in Eclipse.
 * Create a source file Cycle.java and put
 * Cycle.java and TronGame.java in the src directory.
 * Compile and run TronGame as a Java Application.
 * 
 * Task 1 .. 
 * !!!!!! in class Cycle !!!!!!
 * Cycle will have several fields (instance variables)
 * xPos, yPos, which hold the integer pixel position in the window
 * sideLength, which is the integer length of a side 
 * (of the square shaped body of our Cycle)
 * direction which will be either 0,90,180,270 (right, up, left, down)
 * private Color color;
 * speed, which is an integer number of pixels the Cycle moves each frame
 * 
 * Task 2  ..
 * !!!!!! in class Cycle !!!!!! 
 * Write a default constructor.... (no parameters)
 * initialize all int instance variables to 0 and color to null; 
 * 
 * Task 2a .. 
 * !!!!!! in class Cycle !!!!!!
 * Write another constructor for the class Cycle.
 * it should have three int parameters and a Color parameter
 *   public Cycle(int xVal, int yVal, int dirVal, Color colVal)
 * initialize all instance variables to their corresponding parameter
 * and set sideLength=8 and speed=4 (4 pixels every 20 milliseconds)
 * 
 * Task 3 .. 
 * !!!!!! in class TronGame !!!!!!
 * Create an instance variable (i.e. field) of type Cycle called flynn.
 * private Cycle flynn = new Cycle();
 * Make sure your project still compiles and executes without error.
 * 
 * Initialize flynn to a new Cycle in method initRound()
 * at coordinates (1080,100), direction 270 (which is down), 
 * color Color.BLUE
 * 
 * Make sure your project still compiles and executes without error.
 * 
 * Task 4 .. 
 * !!!!!! in class Cycle !!!!!!
 * write the following method method draw().
 * public void draw(Graphics2D g) {
 *   g.setColor(color);
 *   g.fillRect(xPos,yPos,sideLength,sideLength);
 * }
 * 
 * Task 4a
 * !!!!!! in class TronGame !!!!!!
 * Write a line of code to invoke method draw on flynn
 * Run TronGame... see the flynn Cycle.. i.e. Blue Player
 * 
 * Task 5
 * !!!!!! in class Cycle !!!!!!
 * Write a method called updatePos()
 * that modifies xPos or yPos based on direction
 * EXAMPLE: if (direction == 0) 
 *            xPos += speed;
 * (phun physics note: 4 pixels per frame is actually the velocity of the Cycle
 *  .. and there is a 20 millisecond delay between frames)
 * 
 * Task 5a .. 
 * !!!!!! in class TronGame !!!!!!
 * in method actionPerformed:
 * Write a line of code to invoke method updatePos() on flynn.
 * Run TronGame... see flynn move down
 * 
 * Task 6 .. 
 * !!!!!! in class Cycle !!!!!!
 * Write methods getDirection .. returns the direction variable
 * and public void setDirection(int d) that assigns d to direction
 * 
 * Task 6a ..
 * !!!!!! in class TronGame !!!!!!
 * Complete the else-if ladder in method keyPressed()
 * Run TronGame... you should be able to control the flynn Cycle
 * 
 * Task 7 .. 
 * !!!!!! in class Cycle !!!!!!
 * Write the method willDie that returns a boolean and takes no parameters
 * Have your program explore the pixel directly in front of the Cycle
 * if it is not white.. return true, since the Cycle will die, false otherwise
 * EXAMPLE: based on direction.. when the Cycle is moving left..
 *  if (direction == 0 && !TronGame.isWhite(xPos + sideLength + 1, yPos)) {
 *    return true;
 * 
 * Task 7a .. 
 * !!!!!! in class TronGame !!!!!!
 * Write an if statement in method actionPerformed().
 * if flynn will die, then stop the Timer
 * 
 * Task 8 .. 
 * !!!!!! in class TronGame !!!!!!
 * Create another field called sark.
 * Initialize sark to be Color.RED and at the opposite side of the window
 * Write similar method calls
 * on sark that are called on flynn
 * (use keys R D F G for up,left,down,right)
 * NOTE: FOR THIS TASK...
 * NO OTHER MODIFICATIONS NEED TO BE MADE IN class Cycle
 * 
 * Task 9..
 * Export your Project as a Runnable Jar.
 * (in eclipse
 *  right-click on your project in the package explorer
 *  select Export -> Java -> Runnable JAR File
 *  click Next
 *  select the 'TronGame' Launch Configuration
 *  and type a name for your file that has the .jar extension
 *  .. it should save the file to your workspace )
 *  MAKE SURE TO INCLUDE YOUR OWN NAMES IN THE FILENAME
 *  ... no spaces please ...
 *  
 *  Then upload your game to the arcade cabinet
 *  using the cabinetUploader program (on MrRuth.com)
 * 
 */

public class TronGame extends JPanel implements KeyListener, ActionListener {

	private Cycle flynn = new Cycle();
	private Cycle sark = new Cycle();
	//who's winning
	int win;
	//Boast Variables
	boolean boastF;
	boolean boastS;
	int fuelF;
	int fuelS;

	private int frameCount;// used for the score
	private static String title = "~~ Tron Light Cycles ~~  "
			+ "CONTROLS: Flynn(BLUE): Arrow keys and \']\' .. Sark(RED): WASD keys and- \'Q\' .. \'SPACE\' to start";
	private Timer timer;// handles animation
	private static Image offScreenBuffer;// needed for double buffering graphics
	private Graphics offScreenGraphics;// needed for double buffering graphics

	/**
	 * main() is needed to initialize the window.<br>
	 * THIS METHOD SHOULD NOT BE MODIFIED! .. <br>
	 * you should write all necessary initialization code in initRound()
	 */
	public static void main(String[] args) {
		JFrame window = new JFrame(title);
		window.setBounds(0, 0, 1280, 972);// almost 1280x1024 window
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);

		TronGame game = new TronGame();
		window.getContentPane().add(game);
		window.setBackground(Color.WHITE);
		window.setVisible(true);
		game.init();
		window.addKeyListener(game);
	}

	/**
	 * init method needed to initialize non-static fields<br>
	 * THIS METHOD SHOULD NOT BE MODIFIED! ..
	 */
	public void init() {
		offScreenBuffer = createImage(getWidth(), getHeight());// should be 1016x736
		offScreenGraphics = offScreenBuffer.getGraphics();
		timer = new Timer(20, this);
		// timer fires every 20 milliseconds.. invokes method actionPerformed()
		initRound();
	}

	/**
	 * initializes all fields needed for each round of play (i.e. restart)
	 */
	public void initRound() {
		flynn = new Cycle(1080, 100, 270, Color.BLUE);
		sark = new Cycle(300, 100, 270, Color.RED);
		//no winner yet
		win = 0;
		frameCount = 0;
		boastF = false;
		boastS = false;
		fuelF = 200;
		fuelS = 200;
		offScreenGraphics.clearRect(0, 0, 1280, 972);
		repaint();

		// YOUR CODE GOES HERE..
		// initialize instance variables here for each round of play
	}

	/**
	 * Called automatically after a repaint request<br>
	 * THIS METHOD SHOULD NOT BE MODIFIED! ..
	 */
	public void paint(Graphics g) {
		System.out.println(g);
		draw((Graphics2D) offScreenGraphics);
		g.drawImage(offScreenBuffer, 0, 0, this);
	}

	/**
	 * renders all objects to Graphics g
	 */
	public void draw(Graphics2D g) {
		System.out.println(g);
		g.setColor(Color.BLACK);
		flynn.draw(g);
		sark.draw(g); 
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		g.setColor(Color.WHITE);
		g.fillRect(170, 80, 50, 25);
		g.fillRect(770, 80, 50, 25);
		g.setColor(Color.RED);
		g.drawString("Boast 1: " + fuelS, 100, 100);
		g.setColor(Color.BLUE);
		g.drawString("Boast 2: " + fuelF, 700, 100);
		if (win == 1) {
			g.setColor(Color.RED);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 42)); 
			g.drawString("RED WINS", 500, 500);
		}
		else if (win == 2) {
			g.setColor(Color.RED);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 42)); 
			g.drawString("BLUE WINS", 500, 500);
		}
		if (boastF == true && fuelF > 0) {
			flynn.setSpeed(8);
			fuelF--;
		}
		else {
			flynn.setSpeed(4);
		}
		if (boastS == true && fuelS > 0) {
			sark.setSpeed(8);
			fuelS--;
		}
		else {
			sark.setSpeed(4);
		}
		// YOUR CODE GOES HERE..
		// render all game objects here
	}

	/**
	 * Called automatically when the timer fires<br>
	 * this is where all the game fields will be updated
	 */
	public void actionPerformed(ActionEvent e) {

		// YOUR CODE GOES HERE..
		// update all game Objects here
		//Update Flynn's location
		flynn.updatePos();
		sark.updatePos();
		//Check fill Flynn will die
		if (flynn.willDie()) {
			win = 1;
			timer.stop();
		}
		if (sark.willDie()) {
			win = 2;
			timer.stop();
		}
		frameCount++;// update the frameCount
		repaint();// needed to refresh the animation
	}
	/*
	 * CREATE A BOOST BUTTON FOR PLAYERS...
	 * create a boolean variable called boost
	 * write method public void setBoost(boolean b)
	 * .. modify the move method to set the value of speed
	 * to 8 if boost is true
	 * 
	 * --figure out how to invoke the boost method on
	 * flynn and sark in keyPressed and keyReleased methods
	 * (use VK_CLOSE_BRACKET for flynn and VK_Q for sark)
	*/
	
	/**
	 * handles any key pressed events and updates the Cycle's direction by setting
	 * their direction to either 0,90,180 or 270 based on which key is pressed.
	 */
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_LEFT && flynn.getDirection() != 0) {
			flynn.setDirection(180);
		} 
		else if (keyCode == KeyEvent.VK_RIGHT && flynn.getDirection() != 180) {
			flynn.setDirection(0);
		}
		else if (keyCode == KeyEvent.VK_UP && flynn.getDirection() != 270) {
			flynn.setDirection(90);
		}
		else if (keyCode == KeyEvent.VK_DOWN && flynn.getDirection() != 90) {
			flynn.setDirection(270);
		}
		else if (keyCode == KeyEvent.VK_W && sark.getDirection() != 270) {
			sark.setDirection(90);
		} 
		else if (keyCode == KeyEvent.VK_A && sark.getDirection() != 0) {
			sark.setDirection(180);
		}
		else if (keyCode == KeyEvent.VK_S && sark.getDirection() != 90) {
			sark.setDirection(270);
		}
		else if (keyCode == KeyEvent.VK_D && sark.getDirection() != 180) {
			sark.setDirection(0);
		}
		else if (keyCode == KeyEvent.VK_Q) {
			boastS = true;
		}
		else if (keyCode == KeyEvent.VK_SLASH) {
			boastF = true;
		}
	}

	/**
	 * handles any key released events ... <br>
	 * starts game by the '6 Key'<br>
	 * kills the game window by the 'Escape Key'
	 */
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_SPACE) {
			// start the game .. if the game has not currently running
			if (!timer.isRunning()) {
				timer.start();
				initRound();
			}
		} else if (keyCode == KeyEvent.VK_ESCAPE) {
			// kill game process... close the window
			System.exit(0);
		}
		else if (keyCode == KeyEvent.VK_Q) {
			boastS = false;
		}
		else if (keyCode == KeyEvent.VK_SLASH) {
			boastF = false;
		}
	}

	/**
	 * this method is needed for implementing interface KeyListener<br>
	 * THIS METHOD SHOULD NOT BE MODIFIED! ..
	 */
	public void keyTyped(KeyEvent e) {
	}

	/**
	 * returns true if the color value of the pixel<br>
	 * with coordinates (x,y) is WHITE, false otherwise<br>
	 * NOTE: THIS METHOD SHOULD NOT BE MODIFIED!!!
	 */
	public static boolean isWhite(int x, int y) {
		BufferedImage bi = (BufferedImage) offScreenBuffer;
		if (bi == null)
			return true;
		try {
			int colorVal = bi.getRGB(x, y);
			return (colorVal == -1);
		} catch (Exception ex) {
			return false;
		}
	}

}// end class TronGame

/**
 * <xmp><code><pre>
 * some possible extra credit opportunities...
 * 
 * MAKE THE BACKGROUND BLACK...
 * change WHITE to BLACK in method main()
 * change -1 to -16777216 in method isWhite()
 * 
 * 
 * CREATE A BOOST BUTTON FOR PLAYERS...
 * create a boolean variable called boost
 * write method public void setBoost(boolean b)
 * .. modify the move method to set the value of speed
 * to 8 if boost is true
 * 
 * --figure out how to invoke the boost method on
 * flynn and sark in keyPressed and keyReleased methods
 * (use VK_CLOSE_BRACKET for flynn and VK_Q for sark)
 *  
 * 
 * ADD SOUND EFFECTS...
 * find a .wav file and save it in your src folder
 * create a field
 *   private AudioClip sound1;
 * initialize sound1 in method init()
 *   sound1 = Applet.newAudioClip(getClass().getResource("boing.wav"));
 * play the sound when appropriate
 *   sound1.play();
 * 
 * 
 * ADD A SPLASH SCREEN...
 * find a .jpg or .png file and save it in your src folder
 * create a field
 *   private BufferedImage img;
 * initialize it in method init()
 *   try {
 *       img = ImageIO.read(getClass().getResource("splash.jpg"));
 *   } catch (IOException e) {
 *       e.printStackTrace();
 *   }
 *   offScreenGraphics.drawImage(img, 0, 0, this);
 *   repaint();
 * 
 * 
 * KEEP SCORE FOR THE PLAYERS...
 * create a field score in the class Cycle
 * create a getter and a setter method
 * invoke the getter and setter methods to keep score
 * winMessage += "flynn: " + flynn.getScore(); //etc.
 * 
 * 
 */