package cards;

import data.Alert;
import data.Organism;
import data.Player;

public class TileDestroyerCard extends ActionCard{


	public Alert performAction(Organism o, Player p) {
		
		return null;
	}


	public int getCardType() {

		return Card.PETRI_DISH;
	}

}
