package cards;

import data.Organism;

public class LymphocyteCard extends BuilderCard{

	public LymphocyteCard() {
		super(0, 0, 0, 5, 0);
	}
	
	public void modifyOrganism(Organism o, int x, int y) {
		o.addCard(x, y, this);
		for(int xIndex=-1; xIndex<1;xIndex++)
		{
			for(int yIndex=-1;yIndex<1;yIndex++)
			{
				try{
					if(x != 0 && y != 0 && o.isOccupied(xIndex, y))
					{
						o.getCardAt(x,y).modifyBufferRes(1);
					}
				}catch(Exception e){}
			}
		}
		o.updateOrganism();
	}


	public int getCardType() {
		return Card.PETRI_DISH;
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

}
