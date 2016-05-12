package cards;

import java.awt.Image;

import data.Alert;
import data.Organism;
import data.Player;

public class SmallpoxCard extends VirusCard{
	
	
	public SmallpoxCard(){
		
		cost=6;
		immunity=7;
		
	}
	


	public Alert performAction(Organism o, Player p) {
		
		//delete one card on organism per turn 
		return null;
	}


	public Image getCardArt() {
		return null;
	}

}
