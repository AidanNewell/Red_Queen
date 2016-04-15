package cards;

import data.Alert;
import data.Organism;
import data.Player;

public class TileDestroyerCard extends ActionCard{


	Alert performAction(Organism o, Player p) {
		
		return null;
	}


	int getCardType() {

		return Card.PETRI_DISH;
	}

}
