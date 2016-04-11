package cards;

import data.Organism;

public class KillerTCellCard extends BuilderCard{

	public KillerTCellCard() {
		super(4, 0, 0, 5, 3);
	}

	void modifyOrganism(Organism o) {

	}

	int getCardType() {
		return Card.PETRI_DISH;
	}

}
