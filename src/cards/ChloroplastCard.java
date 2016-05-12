package cards;

import java.awt.Image;

import data.ImagePath;
import data.Organism;

public class ChloroplastCard extends BuilderCard{

	
	public ChloroplastCard(){
		
		super(0,4,1,5,2);
		
	}

	
	public void modifyOrganism(Organism o, int x, int y) {
		super.modifyOrganism(o, x, y);
	}


	public void killCard(Organism o, int x, int y) {
		
	}

	public Image getCardArt()
	{
		return ImagePath.CHLOROPLAST_CARD;
	}
	
	
	
}
