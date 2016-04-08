package cards;

public abstract class BuilderCard extends Card{

	protected int toxin;
	protected int ATP;
	protected int res;
	
	public int getRes(){return res;}
	
	public int getATP(){return ATP;}
	
	public int getToxin(){return toxin;}
	
	public BuilderCard(int toxin, int ATP, int res)
	{
		this.toxin = toxin;
		this.ATP=ATP;
		this.res=res;
	}

}
