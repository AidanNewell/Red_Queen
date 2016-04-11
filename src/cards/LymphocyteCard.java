package cards;

import data.Organism;

public class LymphocyteCard extends BuilderCard{

	public LymphocyteCard() {
		super(0, 0, 0, 5, 0);
	}
	
	public LymphocyteCard(int toxin, int ATP, int resistance, int cost, int cooldown) {
		super(toxin, ATP, resistance, cost, cooldown);
	}


	void modifyOrganism(Organism o, int x, int y) {
		
		int resCounter=0;
		
		for(int a=0; a<x; a++){
			for(int b=0; b<y; b++){
				
				if(o.getCardAt(a, b).getCooldown()==0){
					resCounter++;
				}
				
			}
			
		}
		
		modifyResistance(resCounter);
		
	}


	int getCardType() {
		return Card.PETRI_DISH;
	}
	
	void modifyResistance(int n){
		
		res+=n;
	}

}
