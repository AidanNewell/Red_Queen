package cards;

import java.awt.Image;

import data.ImagePath;
import data.Organism;

public class NematocystCard extends BuilderCard{

	public NematocystCard(int toxin, int ATP, int res, int cost, int cooldown)
	{
		super(3, 0, 1, 3, 0);
	}

	public void killCard(Organism o, int x, int y)
	{
		
	}


	public int getSpecialType()
	{
		return Card.PETRI_DISH_CARD;
	}

	
	public Image getCardArt()
	{
		//return ImagePath.NEMA;
		return ImagePath.ERROR;
	}

}
