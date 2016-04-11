package cards;

import data.Organism;

public class HelperTCellCard extends BuilderCard{

	public HelperTCellCard() {
		super(0, 0, 0, 5, 0);
	}


	void modifyOrganism(Organism o, int x, int y) {
		
		
		int toxCounter=0;
		
		for(int a=0; a<x; a++){
			for(int b=0; b<y; b++){
				
				if(o.getCardAt(a, b).getToxin()>1){
					toxCounter++;
				}
				
			}
			
		}
		
		modifyToxin(toxCounter);
		
	}

	int getCardType() {
		return Card.PETRI_DISH;
	}
	
	void modifyToxin(int n){
		
		toxin+=(n-toxin);
	}

}
