package cards;

import java.awt.Image;

import data.ImagePath;
import data.Organism;

public class EctoplasmCard extends BuilderCard{

	public EctoplasmCard() {
		super(2,2,1,0,1);
	}
	
	public void modifyOrganism(Organism o, int x, int y)
	{
		super.modifyOrganism(o, x, y);
	}

	public void killCard(Organism o, int x, int y) {
		
	}

	public Image getCardArt()
	{
		return ImagePath.ECTOPLASM_CARD;
	}
}