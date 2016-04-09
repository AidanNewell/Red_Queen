package cards;

import data.Alert;
import data.Organism;
import data.Player;

public class LargeSquareOrganismCard extends OrganismStarter{

	public LargeSquareOrganismCard()
	{
		this.height=7;
		this.width=7;
	}
	
	public Alert performAction(Organism o, Player p){
		return super.performAction(o, p, height, width);
	}

}
