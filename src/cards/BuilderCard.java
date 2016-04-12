package cards;

import data.Organism;

public abstract class BuilderCard extends Card{

	protected int toxin=0;
	protected int ATP=0;
	protected int res=0;
	protected int cost=0;
	protected int cooldown=0;
	protected int bufferRes=0;
	protected int bufferATP=0;
	protected int bufferToxin=0;
	protected int bufferCooldown=0;
	
	
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
	
	abstract public void modifyOrganism(Organism o, int x, int y);
	
	abstract public void killCard(Organism o, int x, int y);
	
	public void modifyBufferRes(int x)
	{
		bufferRes+=x;
	}
	
	public void modifyBufferATP(int x)
	{
		bufferATP+=x;
	}
	
	public void modifyBufferToxin(int x)
	{
		bufferToxin+=x;
	}
	
	public void modifyBufferCooldown(int x)
	{
		bufferCooldown+=x;
	}
	
	public int getBufferRes()
	{
		return bufferRes;
	}
	
	public int getBufferATP()
	{
		return bufferATP;
	}
	
	public int getBufferToxin()
	{
		return bufferToxin;
	}
	
	public int getBufferCooldown()
	{
		return bufferCooldown;
	}

}
