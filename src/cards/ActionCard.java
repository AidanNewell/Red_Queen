package cards;

import data.Alert;
import data.Organism;
import data.Player;

abstract class ActionCard extends Card{
	
	abstract Alert performAction(Organism o, Player p);

}
