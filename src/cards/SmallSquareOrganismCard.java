package cards;

import data.Alert;
import data.Organism;
import data.Player;

public class SmallSquareOrganismCard extends OrganismStarter{

	
	public SmallSquareOrganismCard(int height, int width)
	{
		this.height=height;
		this.width=width;
	}
	
	public Alert performAction(Organism o, Player p)
	{
		return super.performAction(o,p,height,width);
	}

}
