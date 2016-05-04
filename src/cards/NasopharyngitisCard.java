package cards;

import java.awt.Image;

import data.Alert;
import data.Organism;
import data.Player;

public class NasopharyngitisCard extends VirusCard{

	
	public NasopharyngitisCard(){
		
		cost=2;
		immunity=2;
		
	}
	
	@Override
	public Alert performAction(Organism o, Player p) {
		
		//reduce number of cards player can draw by one
		
		return null;
	}

	@Override
	public Image getCardArt() {
		// TODO Auto-generated method stub
		return null;
	}

}
