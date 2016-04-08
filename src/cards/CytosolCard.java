package cards;

import data.Organism;

public class CytosolCard extends BuilderCard{

	public CytosolCard() {
		super(1,1,2);
	}

	public int getCardType() {
		return Card.CYTOPLASM;
	}

	public void modifyOrganism(Organism o){
		
	}

}
