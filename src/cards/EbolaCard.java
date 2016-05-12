package cards;

import java.awt.Image;

import data.Alert;
import data.Organism;
import data.Player;

public class EbolaCard extends VirusCard{

	
	public EbolaCard(){
		
		cost=10;
		immunity=8;
		
		
	}
	
	
	public Alert performAction(Organism o, Player p) {
		//remove three cards from organism immediately 
		return null;
	}


	public Image getCardArt() {
		
		return null;
	}

}
