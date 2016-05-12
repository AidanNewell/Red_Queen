package cards;

import java.awt.Image;

import data.ImagePath;
import data.Organism;

public class MitochondriaCard extends BuilderCard{

	public MitochondriaCard() {
		super(0, 4, 0, 4, 2);
	}

	
	public void modifyOrganism(Organism o, int x, int y) {
		
		super.modifyOrganism(o, x, y);
	}



	public void killCard(Organism o, int x, int y)
	{
		
	}
	
	public Image getCardArt()
	{
		return ImagePath.MITO_CARD;
	}

}
