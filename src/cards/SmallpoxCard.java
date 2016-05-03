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
