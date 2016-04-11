package cards;

import data.Organism;

public class PrimaryMembraneCard extends BuilderCard{
	
	public PrimaryMembraneCard()//int toxin, int ATP, int res, int cost, int cooldown
	{
		super(0,0,3,4,0);
	}
	
	public int getCardType()
	{
		return Card.PETRI_DISH;
	}
	
	public void modifyOrganism(Organism o){
		
	}

}
