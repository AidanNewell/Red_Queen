package cards;

import java.awt.Image;

import data.Alert;
import data.Organism;
import data.Player;

public class BirdFluCard extends VirusCard{
	
	
	public BirdFluCard(){
		
		cost=4;
		immunity=5;
		
	}

	
	public Alert performAction(Organism o, Player p) {

		return null;
	}


	public Image getCardArt() {

		return null;
	}

}
