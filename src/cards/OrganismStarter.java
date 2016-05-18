package cards;

import data.Alert;
import data.Organism;
import data.Player;

public abstract class OrganismStarter extends ActionCard{

	int height;
	int width;

	public Alert performAction(Organism o, Player p, int h, int w) {
		if(!(p.isNewOrgValid()))
			return new Alert("You cannot support another organism!");
		p.newOrganism(new Organism(h,w));
		return null;
	}
	
	public int getSpecialType()
	{
		return Card.ORGANISM_CARD;
	}
}
