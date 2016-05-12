package cards;

import java.awt.Image;

import data.ImagePath;
import data.Organism;

public class CytosolCard extends BuilderCard{

	public CytosolCard() {
		super(1,1,1,0,1);
	}

	public void modifyOrganism(Organism o, int x, int y){
		super.modifyOrganism(o, x, y);
	}

	public void killCard(Organism o, int x, int y) {
		
	}
	
	public Image getCardArt()
	{
		return ImagePath.CYTOSOL_CARD;
	}

}
