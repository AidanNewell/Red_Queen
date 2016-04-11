package cards;

import data.Organism;

public class MitochondriaCard extends BuilderCard{

	public MitochondriaCard() {
		super(0, 4, 0, 4, 2);
	}

	
	void modifyOrganism(Organism o) {
		
		
	}

	
	int getCardType() {

		return Card.PETRI_DISH;
	}

}
