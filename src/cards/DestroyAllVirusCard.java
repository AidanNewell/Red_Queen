package cards;

import java.awt.Image;

import data.Alert;
import data.ImagePath;
import data.Organism;
import data.Player;

public class DestroyAllVirusCard extends ActionCard{


	public Alert performAction(Organism o, Player p) {
		
		
		
		return null;
	}
	
	public Image getCardArt()
	{
		return ImagePath.DESTROY_VIRUS_ALL;
	}

}
