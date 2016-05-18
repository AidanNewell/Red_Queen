package SahilAndAllisonsExcellentAdventure;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdventureActionPanel extends JPanel{

	
	private AdventureGame g;
	private AdventureOrganismPanel p;
	private JLabel selectedCard;
	private JButton playCard;
	private JButton endTurn;
	private JLabel computerAction;

	
	
	public AdventureActionPanel(AdventureGame G, AdventureOrganismPanel P){
		
		g=G;
		p=P;
		
		
		
	}
}
