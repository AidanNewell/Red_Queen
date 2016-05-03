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
