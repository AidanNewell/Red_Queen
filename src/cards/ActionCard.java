package cards;

import data.Alert;
import data.Organism;
import data.Player;

abstract class ActionCard extends Card{
	
	public abstract Alert performAction(Organism o, Player p);

}
