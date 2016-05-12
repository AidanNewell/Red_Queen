package cards;

import java.awt.Image;

import data.Alert;
import data.Organism;
import data.Player;

public class CowpoxCard extends VirusCard{
	
	
	public CowpoxCard(){
		
		cost=3;
		immunity=4;
		
	}

	
	public Alert performAction(Organism o, Player p) {
		
		return null;
	}

	
	public Image getCardArt() {

		return null;
	}

}
