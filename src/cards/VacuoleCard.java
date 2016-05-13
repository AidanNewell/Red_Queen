package cards;

import java.awt.Image;

import data.ImagePath;
import data.Organism;

public class VacuoleCard extends BuilderCard{

	public VacuoleCard() {
		super(0,0,2,1,0);
	}
	public void modifyOrganism(Organism o, int x, int y) {
		
		super.modifyOrganism(o, x, y);
	}
	
	public void killCard(Organism o, int x, int y)
	{
		
	}
	
	public Image getCardArt()
	{
		return ImagePath.VAC_CARD;
	}
}
