package cards;

import java.awt.Image;

import data.ImagePath;
import data.Organism;

public class LymphocyteCard extends BuilderCard{

	public LymphocyteCard() {
		super(0, 0, 2, 5, 0);
	}
	
	public void modifyOrganism(Organism o, int x, int y) {
		
		super.modifyOrganism(o, x, y);
		
		o.addCard(x, y, this);
		for(int xIndex=-1; xIndex<1;xIndex++)
		{
			for(int yIndex=-1;yIndex<1;yIndex++)
			{
				try{
					if(x != 0 && y != 0 && o.isOccupied(xIndex, y))
					{
						o.getCardAt(x+xIndex,y+yIndex).modifyBufferRes(1);
					}
				}catch(Exception e){}
			}
		}
		o.updateOrganism();
	}



	public void killCard(Organism o, int x, int y)
	{

		for(int xIndex=-1; xIndex<1;xIndex++)
		{
			for(int yIndex=-1;yIndex<1;yIndex++)
			{
				try{
					if(x != 0 && y != 0 && o.isOccupied(xIndex, y))
					{
						o.getCardAt(x,y).modifyBufferRes(-1);
					}
				}catch(Exception e){}
			}
		}
	}
	
	public Image getCardArt()
	{
		return ImagePath.LYMPH_CARD;
	}

}
