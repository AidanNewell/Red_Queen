package cards;

import data.Organism;

public class MitochondriaCard extends BuilderCard{

	public MitochondriaCard() {
		super(0, 4, 0, 4, 2);
	}

	
	public void modifyOrganism(Organism o, int x, int y) {
		
		
	}

	
	public int getCardType() {

		return Card.PETRI_DISH;
	}


	public void killCard(Organism o, int x, int y)
	{
		
	}

}