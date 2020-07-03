import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.io.*;
import java.util.*;

public class BarGraph {
	private JFrame frame;

	public BarGraph() {
		frame = new JFrame("Bar Graph");
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setPreferredSize(frame.getSize());
		frame.add(new ReadFile(frame.getSize()));
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String... argv) {
		new BarGraph();
	}

	public static class ReadFile extends JPanel   implements MouseListener{
		String name = " NBA";
		String[] nba = null;
		Color color = new Color(0);
		ArrayList<String> stats = new ArrayList<String>();
		ArrayList<String> pnames = new ArrayList<String>();
		ArrayList<Integer> count = new ArrayList<Integer>();
		float width = 0; //this is the width of a bar

		public ReadFile(Dimension dimension) {
			setSize(dimension);
			setPreferredSize(dimension);
			addMouseListener(this);
			try{
				read();
			}catch(Exception e){
				System.out.println("Problem");
			}
		}

		@Override
		public void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D)g;
			Dimension d = getSize();
			
			width =  (float)d.width/count.size(); //gets width of each bar by dividing the screen's width by the number of bars needed. Used floats so that the bars would cover the whole screen
			
			g2.drawString("player: " + name, 10, 30);
			for (int i = 0; i < count.size(); i++) {
				//System.out.println("yes");
				color = Color.BLACK;
				g2.setColor(color); //Black Outline
				g2.drawRect((int)(width *  i), 350 - (count.get(i) * 5), (int) width, count.get(i) * 5); //Each win accounts for 5 pixels, since rect drawing starts at top left, subtract from 350 then make height wins*5
				color = new Color(count.get(i) *4, 0, 255 - count.get(i) *4);
				g2.setColor(color); //Colored Fill
				g2.fillRect((int)(width *  i) + 1, 350 - (count.get(i) * 5), (int) width - 1, count.get(i) * 5); //fill the rectangle subtraction so that outlines are more clear
				//System.out.println(i);
				//System.out.println(count.get(i));
			}


		}

		public void read()throws IOException{
			BufferedReader f = new BufferedReader(new FileReader("nba.csv"));
			String s;
			while ((s=f.readLine())!=null){ 
				// System.out.println(s);
				stats.add(s);
			}


			name = "stats: " + stats.get(0);//this can be commented out - just for testing

			repaint();
			nba = new String[stats.size()];

			for(int i=0; i<stats.size(); i++){
				String[] s1 = stats.get(i).split(",");
				nba[i] = s1[1];
			}//NBA now holds the players names


			for (int i = 0; i < nba.length; i++) { //Adds all names to ArrayList
				int index = pnames.indexOf(nba[i]);
				if (index == -1) { //If name does not exist, add names and set wins to 1
					pnames.add(nba[i]);
					count.add(1);
				}
				else {
					count.set(index, count.get(index) + 1); //Otherwise add one to the count of wins
				}
			}
			//Debug to check that things are all good
//			System.out.println(count.size());
//			System.out.println(pnames.size());
			for (int i = 0; i < count.size(); i++) { //Remove names less than 5
				if (count.get(i) < 5) {
					count.remove(i);
					pnames.remove(i);
					i--;
					//System.out.println("purged");
				}
			}
			//System.out.println(count.size());
		   

		}

		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			
			int index = (int) (x/width); //gets index of the player and number of wins the click is on

			name = pnames.get(index) + ": " + count.get(index);
			repaint();
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
