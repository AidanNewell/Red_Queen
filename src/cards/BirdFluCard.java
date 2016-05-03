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

	@Override
	public Alert performAction(Organism o, Player p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image getCardArt() {
		// TODO Auto-generated method stub
		return null;
	}

}
