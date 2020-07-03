import java.util.Random;

public class GenZKid extends Animal{
	//this variable keeps track of the number of Victory Royales this genZKid has achieved
	int victoryRoyales;
	
	public GenZKid(String name, int hungerLevel, boolean likesPeople, int victoryRoyales) {
		super(hungerLevel, (int) (Math.random() * 5), name, likesPeople);
		this.victoryRoyales = victoryRoyales;
	}
	
	public GenZKid(Random rd, String name) {
		super(rd.nextInt(11), rd.nextInt(5), name, rd.nextBoolean());
		this.victoryRoyales = rd.nextInt(200);
	}

	//Due to a GenZKid's low intelligence level, it dabs on its haters.
	//Increases victoryRoyales on, increases hunger level, decreases intimidation level
	//intimidates all animals around it
	public void entertainment(DavisGrounds Davis, int r, int c) {
		victoryRoyales++;
		this.setHungerLevel(this.getHungerLevel() + 1);
		if (this.getIntimidation() > 0) {
			this.setIntimidation(this.getIntimidation()-1);
		}
		Animal[][] grid = Davis.getGrid();
		//Intimidates all animals around it
		intimidate(r+1, c, grid);
		intimidate(r+1, c+1, grid);
		intimidate(r+1, c-1, grid);
		intimidate(r, c+1, grid);
		intimidate(r, c-1, grid);
		intimidate(r-1, c, grid);
		intimidate(r-1, c+1, grid);
		intimidate(r-1, c-1, grid);
		System.out.println(this.getName() + ", the GenZKid, has dabbed on all surrounding animals");
		System.out.println("He is now up to " + victoryRoyales + " wins in forknife");
		
	}
	
	public void intimidate(int r, int c, Animal[][] grid) {
		if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] != null) {
			Animal cur = grid[r][c];
			cur.setIntimidation(cur.getIntimidation() - 1);
		}
	}

}
