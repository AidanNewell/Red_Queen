package cards;

import data.Organism;

public abstract class BuilderCard extends Card{

	protected int toxin;
	protected int ATP;
	protected int res;
	protected int cost;
	protected int cooldown;
	
	
	public int getRes(){return res;}
	
	public int getATP(){return ATP;}
	
	public int getToxin(){return toxin;}
	
	public int getCost(){return cost;}
	
	public int getCooldown(){return cooldown;}
	
	public BuilderCard(int toxin, int ATP, int res, int cost, int cooldown)
	{
		this.toxin = toxin;
		this.ATP=ATP;
		this.res=res;
		this.cost = cost;
		this.cooldown=cooldown;
	}
	
	abstract void modifyOrganism(Organism o, int x, int y);

}
