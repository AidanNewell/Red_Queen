package cards;

import data.Alert;
import data.Organism;
import data.Player;

public class SmallSquareOrganismCard extends OrganismStarter{

	
	public SmallSquareOrganismCard()
	{
		this.height=3;
		this.width=3;
	}
	
	public Alert performAction(Organism o, Player p)
	{
		return super.performAction(o,p,height,width);
	}

}
