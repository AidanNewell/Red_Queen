package cards;

import data.Alert;
import data.Organism;
import data.Player;

public class MediumSquareOrganismCard extends OrganismStarter{

	public MediumSquareOrganismCard()
	{
		this.height=4;
		this.width=4;
	}
	
	public Alert performAction(Organism o, Player p) {
		return super.performAction(o, p, height, width);
	}

}
