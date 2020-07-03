
import java.util.*;
import java.awt.*;
public class Cycle {
	private int xPos;
	private int yPos;
	private int sideLength;
	private int direction;
	private Color color;
	private int speed;

	public Cycle() {
		xPos = 0;
		yPos = 0;
		sideLength = 0;
		direction = 0;
		speed = 0;
		color = null;
	}

	public Cycle(int xPos, int yPos, int direction, Color color) {
		super();
		this.xPos = xPos;
		this.yPos = yPos;
		this.sideLength = 8;
		this.direction = direction;
		this.color = color;
		this.speed = 4;
	}

	public void updatePos() {
		if (direction == 0) {
			xPos += speed;
		}
		if (direction == 90) {
			yPos -= speed;
		}
		if (direction == 180) {
			xPos -= speed;
		}
		if (direction == 270) {
			yPos += speed;
		}
	}

	public boolean willDie() {
		if (direction == 0 && !TronGame.isWhite(xPos + sideLength + 1, yPos)) {
			return true;
		}
		if (direction == 90 && !TronGame.isWhite(xPos, yPos - 1)) {
			return true;
		}
		if (direction == 180 && !TronGame.isWhite(xPos - 1, yPos)) {
			return true;
		}
		if (direction == 270 && !TronGame.isWhite(xPos, yPos + sideLength + 1)) {
			return true;
		}
		return false;
	}

	public void draw(Graphics2D g) {
		g.setColor(color);
		g.fillRect(xPos,yPos,sideLength,sideLength);
	}


	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}



}
