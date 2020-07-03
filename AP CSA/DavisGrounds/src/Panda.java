import java.util.Random;
public class Panda extends Animal{
	//Pandas, although hefty animals, are very sensitive about their weight
	int weight;
	
	
	public Panda(String name, int hungerLevel, boolean likesPeople) {
		super(hungerLevel, (int) (Math.random() * 4) + 3, name, likesPeople);
		this.weight = (int) (Math.random()*200) + 150;
	}
	
	//This is the constructor that generates fields randomly
	public Panda(Random rd, String name) {
		super(rd.nextInt(11), rd.nextInt(4) + 3, name, rd.nextBoolean());
		this.weight = (int) (Math.random()*200) + 150;
	}


	//For entertainment, a panda rolls around and eat bamboo. 
	//Decreases Hunger level, increases weight, and Decreases Intimidation
	//The Animal to the right seeing the panda eating realizes that he is hungrier
	public void entertainment(DavisGrounds Davis, int r, int c) {
		if (this.getHungerLevel() > 0) {
			this.setHungerLevel(this.getHungerLevel() - 1);
		}
		this.weight += 50;
		if (this.getIntimidation() > 0) {
			this.setIntimidation(this.getIntimidation() -1);
		}
		
		Animal[][] grid = Davis.getGrid();
		if (c < grid[0].length - 1 && grid[r][c] != null) {
			Animal cur = grid[r][c+1];
			if (cur != null) {
				cur.setHungerLevel(cur.getHungerLevel() + 1);
			}
		}
		System.out.println(this.getName() + ", the Panda, is rolling and eatting Bamboo");
		System.out.println("He now weighs " + weight);
	}
}
