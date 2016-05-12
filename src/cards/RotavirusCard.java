package cards;

import java.awt.Image;

import data.Alert;
import data.Organism;
import data.Player;

public class RotavirusCard extends VirusCard{

	
	public RotavirusCard(){
		
		cost=2;
		immunity=3;
		
		
	}
	
	

	public Alert performAction(Organism o, Player p) {
		return null;
	}


	public Image getCardArt() {
		return null;
	}

}
