package cards;

import data.Alert;
import data.Organism;
import data.Player;

public class Draw3Card extends ActionCard{

	
	Alert performAction(Organism o, Player p) {
		
		p.drawCards(0,0,3);
		
		
		return null;
	}


	int getCardType() {
		return Card.PETRI_DISH;
	}

}
