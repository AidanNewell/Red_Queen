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
