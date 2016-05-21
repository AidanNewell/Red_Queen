package cards;

import java.awt.Image;

import data.ImagePath;
import data.Organism;

public class LysosomeCard extends BuilderCard{
	
	public LysosomeCard()
	{
		super(2,0,0,8,0);
	}

	public void killCard(Organism o, int x, int y)
	{
		
	}
	
	public void modifyOrganism(Organism o, int x, int y)
	{
		for(int i=-1;i<2;i++)
		{
			for(int j=-1;j<2;j++)
			{
				try{
					if(!(i == 0 && j == 0) && o.isOccupied(x+i, y+j))
					{
						if(o.getCardAt(x+i,y+j).getATP()>0)
						{
							o.getCardAt(x+i, y+j).modifyBufferATP(-2);
							o.getCardAt(x+i, y+j).modifyBufferToxin(4);
						}
					}
				}catch(Exception e){}
			}
		}
	}

	public int getSpecialType()
	{
		return Card.PETRI_DISH_CARD;
	}

	public Image getCardArt()
	{
		return ImagePath.LYSO;
	}

}
