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
