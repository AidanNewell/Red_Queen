package cards;

import java.awt.Image;

import data.ImagePath;
import data.Organism;

public class PrimaryMembraneCard extends BuilderCard{
	
	public PrimaryMembraneCard()//int toxin, int ATP, int res, int cost, int cooldown
	{
		super(0,0,3,4,0);
	}
	
	
	public void modifyOrganism(Organism o, int x, int y){
	
		super.modifyOrganism(o, x, y);
	}

	public void killCard(Organism o, int x, int y)
	{
		
	}
	
	public Image getCardArt()
	{
		return ImagePath.PRIMARYMEM_CARD;
	}

}
