package cards;

import data.Organism;

public class CytoskeletonCard extends BuilderCard{
	
	public CytoskeletonCard()
	{
		super(0,0,2,0,1);
	}
	
	public int getCardType()
	{
		return Card.CYTOPLASM;
	}
	
	public void modifyOrganism(Organism o){
		
	}

}
