package cards;

import java.awt.Image;

import data.ImagePath;
import data.Organism;

public class CentrioleCard extends BuilderCard{

	public CentrioleCard()
	{
		super(0, 0, 1, 8, 0);
	}
	
	public void modifyOrganism(Organism o, int x, int y)
	{
		for(int i=-1;i<2;i++)
		{
			for(int j=-1;j<2;j++)
			{
				try{
					if(!(i == 0 && j == 0) && o.isOccupied(x+i, y+j) && o.getCardAt(x+i, y+j).getSpecialType() == Card.CYTOPLASM_CARD)
					{
						o.getCardAt(x+i, y+j).modifyBufferRes(2);
					}
				}catch(Exception e){}
			}
		}
	}
	

	public void killCard(Organism o, int x, int y)
	{
		
	}

	public int getSpecialType()
	{
		return Card.PETRI_DISH_CARD;
	}

	public Image getCardArt()
	{
		return ImagePath.CENTRIOLE;
	}

}
