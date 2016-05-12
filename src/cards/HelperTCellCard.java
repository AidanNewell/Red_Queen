package cards;

import java.awt.Image;

import data.ImagePath;
import data.Organism;

public class HelperTCellCard extends BuilderCard{

	public HelperTCellCard() {
		super(0, 0, 0, 5, 0);
	}


	public void modifyOrganism(Organism o, int x, int y) {
		
		super.modifyOrganism(o, x, y);
		
		o.addCard(x, y, this);
		for(int i=-1;i<1;i++)
		{
			for(int j=-1;j<1;j++)
			{
				try{
					if(i != 0 && j != 0 && o.isOccupied(x, y) && o.getCardAt(x, y).getToxin()>1)
					{
						o.getCardAt(x, y).modifyBufferToxin(1);
					}
				}catch(Exception e){}
			}
		}
	}


	public void killCard(Organism o, int x, int y)
	{

		for(int i=-1;i<1;i++)
		{
			for(int j=-1;j<1;j++)
			{
				if(i != 0 && j != 0 && o.isOccupied(x, y) && o.getCardAt(x, y).getToxin()>1)
				{
					o.getCardAt(x+i, y+j).modifyBufferToxin(-1);
				}
			}
		}
	}
	
	public Image getCardArt()
	{
		return ImagePath.HELPERT_CARD;
	}

}
