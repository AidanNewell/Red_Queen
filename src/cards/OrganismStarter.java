package cards;

import data.Alert;
import data.Organism;
import data.Player;

public abstract class OrganismStarter extends ActionCard{

	int height;
	int width;
	
	public int getCardType()
	{
		return Card.ORGANISM;
	}

	public Alert performAction(Organism o, Player p, int h, int w) {
		if(!(p.isNewOrgValid()))
			return new Alert("You cannot support another organism!");
		p.newOrganism(new Organism(h,w));
		return null;
	}
}
