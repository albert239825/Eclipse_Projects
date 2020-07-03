
public abstract class Animal {
	private int hungerLevel;
	private int intimidation;
	private String name;
	private boolean likesPeople;
	
	public abstract void entertainment(DavisGrounds Davis, int r, int c);


	public Animal(int hungerLevel, int intimidation, String name, boolean likesPeople) {
		super();
		this.hungerLevel = hungerLevel;
		this.intimidation = intimidation;
		this.name = name;
		this.likesPeople = likesPeople;
	}
	
	//override the compare function
	public boolean equals(Animal a) {
		return this.name.equals(a.name);
	}
	
	public String toString() {
		return name;
	}

	public int getHungerLevel() {
		return hungerLevel;
	}

	public void setHungerLevel(int hungerLevel) {
		this.hungerLevel = hungerLevel;
	}

	public int getIntimidation() {
		return intimidation;
	}

	public void setIntimidation(int intimidation) {
		this.intimidation = intimidation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isLikesPeople() {
		return likesPeople;
	}

	public void setLikesPeople(boolean likesPeople) {
		this.likesPeople = likesPeople;
	}
	
	
}
