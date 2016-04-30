package cards;

import java.awt.Image;

import data.ImagePath;
import data.Organism;

public class CytoskeletonCard extends BuilderCard{
	
	public CytoskeletonCard()
	{
		super(0,0,2,0,1);
	}
	
	public void modifyOrganism(Organism o, int x, int y){
		
	}

	public void killCard(Organism o, int x, int y) {
		
	}

	public Image getCardArt()
	{
		return ImagePath.CYTOSKELETON_CARD;
	}

}
