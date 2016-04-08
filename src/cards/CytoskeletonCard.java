package cards;

import data.Organism;

public class CytoskeletonCard extends BuilderCard{
	
	public CytoskeletonCard()
	{
		super(0,0,3);
	}
	
	public int getCardType()
	{
		return Card.CYTOPLASM;
	}
	
	public void modifyOrganism(Organism o){
		
	}

}
