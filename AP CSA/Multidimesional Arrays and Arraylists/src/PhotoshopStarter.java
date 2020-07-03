import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import java.awt.Font;
import java.awt.FontMetrics;

public class PhotoshopStarter {
	private JFrame frame;

	public PhotoshopStarter() {
		frame = new JFrame("Photoshop Filter");
		frame.setSize(620, 400);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setPreferredSize(frame.getSize());
		frame.add(new PhotoDraw(frame.getSize()));
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String... argv) {
		new PhotoshopStarter();
	}

	public static class PhotoDraw extends JPanel  implements MouseListener {

		//int[][] alpha ;
		int[][] red;
		int[][] green ;
		int[][] blue ;
		BufferedImage img;
		BufferedImage img2;
		int width = 620;
		int height = 400;
		int effect = 0;


		public PhotoDraw(Dimension dimension) {//constructor

			setSize(dimension);
			setPreferredSize(dimension);
			addMouseListener(this);


			// Sets the image to be the original pictures
			try {
				img = ImageIO.read(this.getClass().getResource("img.jpg"));
				img2 = ImageIO.read(this.getClass().getResource("img.jpg"));
			} catch (IOException e) {
				System.out.println("Image could not be read");
				System.exit(1);
			}

			int width  = img.getWidth();
			int height  = img.getHeight();
			setArrays(width, height);

		}

		@Override
		public void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D)g;
			Dimension d = getSize();
			g2.drawImage(img,0,0,300,150 ,null);
			g2.drawImage(img2,310,0,300,150 ,null);

			// TO Change Font Size
			// g2.setFont (new Font("TimesRoman", Font.PLAIN, 20));

			int startX = 0;
			int side = width/3;

			g2.drawRect(0,200,side, side);            
			g2.drawString("Example1" , 10, 250);
			g2.drawString("Example2" , 10 + side, 250);
			g2.drawString("Example3" , 10 + side*2, 250);
			g2.drawRect(side,200,side, side);     
			g2.drawRect(side*2,200,side, side);     

			// CREATE 1: Draw Boxes

		}



		public void mousePressed(MouseEvent a) {

			int x = a.getX();
			int y = a.getY();
			int side = width/3;

			// CREATE 2:
			// If the x and y are within a certain box, set effect to 1,2,3
			if ((int) (x/side) == 0 && y > 200) {
				effect = 1;
				System.out.println("1");
				imageChange();
			}
			else if ((int) (x/side) == 1 && y > 200) {
				effect = 2;
				System.out.println("2");
				imageChange();
			}
			else if ((int) (x/side) == 2 && y > 200) {
				effect = 3;
				System.out.println("3");
				imageChange();
			}
			
			else {
				System.out.println("4");
				try {
					img = ImageIO.read(this.getClass().getResource("img.jpg"));
					img2 = ImageIO.read(this.getClass().getResource("img.jpg"));
				} catch (IOException e) {
					System.out.println("Image could not be read");
					System.exit(1);
				}
				int width  = img.getWidth();
				int height  = img.getHeight();
				setArrays(width, height);
			}


			// If they didn't click on a button, call reset

			repaint();
		}


		//this creates a new image

		public void imageChange()
		{

			//make some changes to the pixels

			for(int x=0; x< red.length-1; x++){
				for (int y=0;y < red[0].length-1;y++){
					//luminance of the pixel   (0.2126*r) + (0.7152*g) + (0.0722*b);
					double lum =(0.2126*red[x][y]) + (0.7152*green[x][y]) + (0.0722 * blue[x][y]);

					// CREATE 3: Apply effects to red green and blue arrays
					// red[x][y] = 0 would mean there is no more red color in the pixel

					// If effect pick one
					// Invert the image so 255->0, 254-> 1
					if (effect == 1) {
						red[x][y] = Math.abs(red[x][y]-255);
						blue[x][y] = Math.abs(blue[x][y]-255);
						green[x][y] = Math.abs(green[x][y]-255);
						
					}
					
					if (effect == 2) {
						if (lum >= 127.5) {
							red[x][y] = 255;
							green[x][y] = 255;
							blue[x][y] = 255;
						}
						else {
							red[x][y] = 0;
							green[x][y] = 0;
							blue[x][y] = 0;
						}
					}

					// If they pick two
					// Apply Threshold
					// If the Lumiance is at least half way, set the pixel to white
					// Otherwise it's black
					
					if (effect == 3) {
						red[x][y] = red[x][y] + x;
						green[x][y] = green[x][y] + x;
						blue[x][y] = blue[x][y] + x;
					}

					// If they pick three
					// Make your own cool feature

				}}


			//create new image using new values
			BufferedImage img3 = new BufferedImage(red.length, red[0].length, BufferedImage.TYPE_INT_RGB);
			for (int x = 0; x< red.length; x++){
				for (int y = 0; y< red[0].length; y++){

					int r = red[x][y];
					int g = green[x][y];
					int b = blue[x][y];
					int col = (r << 16) | (g << 8) | b;
					img3.setRGB(x, y, col);

				}
			}
			String fullName = "inverted";

			File f = new File(fullName + ".jpg");

			try{
				ImageIO.write(img3, "JPEG", f);
				img2 = img3;
				repaint();
			} catch(Exception e){

			}

		}

		public void setArrays(int width, int height){

			red = new int[width][height];
			green = new int[width][height];
			blue = new int[width][height];

			for(int x=0; x< width; x++){
				for (int y=0;y< height;y++){

					Color mycolor = new Color(img.getRGB(x, y));

					int r = mycolor.getRed();
					int g = mycolor.getGreen();
					int b = mycolor.getBlue();

					red[x][y] = r;
					green[x][y] = g;
					blue[x][y] = b;

				}
			} 
		}


		// IGNORE ME TILL NEXT TIME WE USE THIS PROJECT
		public boolean  checkForWinner(int x,int y, Color c){

			return false;
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mouseClicked(MouseEvent e) {
		}

	}

}