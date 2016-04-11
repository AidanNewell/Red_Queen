package cards;

import data.Organism;

public class VacuoleCard extends BuilderCard{

	public VacuoleCard() {
		super(0,0,0,1,0);
	}
	public void modifyOrganism(Organism o, int x, int y) {
		
	}
	public int getCardType() {
		return Card.PETRI_DISH;
	}
}
