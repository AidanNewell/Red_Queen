package cards;

import data.Organism;

public class ChloroplastCard extends BuilderCard{

	
	public ChloroplastCard(){
		
		super(0,4,1,5,2);
		
	}

	
	void modifyOrganism(Organism o) {
		
	}


	int getCardType() {
		return Card.PETRI_DISH;
	}
	
	
}
