package cards;

import data.Organism;

public class VacuoleCard extends BuilderCard{

	public VacuoleCard() {
		super(0,0,0,1,0);
	}
	void modifyOrganism(Organism o) {
		
	}
	int getCardType() {
		return Card.PETRI_DISH;
	}
}
