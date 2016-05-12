package cards;

import java.awt.Image;

import data.Alert;
import data.Organism;
import data.Player;

public class InfluenzaCard extends VirusCard{
	
	
	public InfluenzaCard(){
		
		cost=1;
		immunity=1;
		
	}
	

	public Alert performAction(Organism o, Player p) {
		
		return null;
	}


	public Image getCardArt() {

		return null;
	}

}
