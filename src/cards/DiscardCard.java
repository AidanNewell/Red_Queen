package cards;

import java.awt.Image;

import data.Alert;
import data.ImagePath;
import data.Organism;
import data.Player;

public class DiscardCard extends ActionCard{


	public Alert performAction(Organism o, Player p) {
		
		p.clearHand();
		return null;
	}
	
	public Image getCardArt()
	{
		return ImagePath.DISCARD_ALL;
	}

}
