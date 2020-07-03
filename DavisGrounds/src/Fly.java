import java.util.Random;

public class Fly extends Animal{
	public Fly(String name, int hungerLevel, boolean likesPeople) {
		super(hungerLevel, (int) (Math.random() * 3), name, likesPeople);
	}
	
	public Fly(Random rd, String name) {
		super(rd.nextInt(11), rd.nextInt(3), name, rd.nextBoolean());
	}
	
	
	//Due to a Flies short life span, it dies before it can entertain itself
	//if there are any animals around, they see free food. All animals around get -1 to hunger level
	public void entertainment(DavisGrounds Davis, int row, int col) {
		Animal[][] grid = Davis.getGrid();
		grid[row][col] = null;
		for(int r = row-1; r <= row+1; r++) {
			for (int c = col - 1; c <= col+1; c++) {
				//if not original and occupied and not out of bounds    
				if (!(r==row && c == col) && (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length) && grid[r][c] != null ) {
					Animal cur = grid[r][c];
					if (cur.getHungerLevel()>0) {
						cur.setHungerLevel(cur.getHungerLevel() - 1);
					}
				}
			}
		}
		System.out.println(this.getName() + ", the fly, has died");
	}
}
