package cards;

import java.awt.Image;

import data.Alert;
import data.ImagePath;
import data.Organism;
import data.Player;

public class Draw3Card extends ActionCard{

	
	public Alert performAction(Organism o, Player p) {
		
		p.drawCards(0,0,3);
		
		
		return null;
	}
	
	public Image getCardArt()
	{
		return ImagePath.DRAW_3;
	}


}
