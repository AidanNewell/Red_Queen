package cards;

import data.Organism;

public class EctoplasmCard extends BuilderCard{

	public EctoplasmCard() {
		super(2,2,1,0,1);
	}

	int getCardType() {
		return Card.CYTOPLASM;
	}
	
	public void modifyOrganism(Organism o)
	{
		
	}

}