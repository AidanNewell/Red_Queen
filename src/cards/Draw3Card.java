package cards;

import java.awt.Image;

import data.Alert;
import data.ImagePath;
import data.Organism;
import data.Player;

public class Draw3Card extends ActionCard{

	
	public Alert performAction(Organism o, Player p) {
		
		p.drawCards(Card.PETRI_DISH_CARD);
		p.drawCards(Card.PETRI_DISH_CARD);
		p.drawCards(Card.PETRI_DISH_CARD);
		
		
		return null;
	}
	
	public Image getCardArt()
	{
		return ImagePath.DRAW_3;
	}


}
