package cards;

import data.Organism;

public class EctoplasmCard extends BuilderCard{

	public EctoplasmCard() {
		super(2,2,2);
	}

	int getCardType() {
		return Card.CYTOPLASM;
	}
	
	public void modifyOrganism(Organism o)
	{
		
	}

}