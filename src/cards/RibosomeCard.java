package cards;

import java.awt.Image;

import data.ImagePath;
import data.Organism;

public class RibosomeCard extends BuilderCard{

	public RibosomeCard() {
		super(0, 0, 2, 4, 0);
	
	}
	
	public void modifyOrganism(Organism o,int x,int y) {
		super.modifyOrganism(o, x, y);
		o.modifyBufferDraw(1);
	}

	public void killCard(Organism o, int x, int y) {
		
	}

	public Image getCardArt()
	{
		return null;
	}

}
