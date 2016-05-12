package cards;

import java.awt.Image;

import data.ImagePath;
import data.Organism;

public class KillerTCellCard extends BuilderCard{

	public KillerTCellCard() {
		super(4, 0, 0, 5, 3);
	}

	public void modifyOrganism(Organism o,int x,int y) {
		super.modifyOrganism(o, x, y);
	}

	public void killCard(Organism o, int x, int y) {
		
	}

	public Image getCardArt()
	{
		return ImagePath.KILLERT_CARD;
	}
}
