package cards;

import data.Organism;

public class KillerTCellCard extends BuilderCard{

	public KillerTCellCard() {
		super(4, 0, 0, 5, 3);
	}

	public void modifyOrganism(Organism o,int x,int y) {

	}

	public int getCardType() {
		return Card.PETRI_DISH;
	}

	public void killCard(Organism o, int x, int y) {
		
	}

}