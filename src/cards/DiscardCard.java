package cards;

import data.Alert;
import data.Organism;
import data.Player;

public class DiscardCard extends ActionCard{


	public Alert performAction(Organism o, Player p) {
		
		p.clearHand();
		return null;
	}

	@Override
	int getCardType() {

		return Card.PETRI_DISH;
	}

}
