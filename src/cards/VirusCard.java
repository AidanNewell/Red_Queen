package cards;

import java.awt.Image;

import data.Alert;
import data.Organism;
import data.Player;

public abstract class VirusCard extends ActionCard{
	
	protected int cost;
	protected int immunity;
	

	
	public abstract Alert performAction(Organism o, Player p);
	
	public abstract Image getCardArt();
	
	public int getCost(){
		
		return cost;
	}
	
	public int getImmunity(){
		
		return immunity;
	}

}
