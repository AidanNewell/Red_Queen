package SahilAndAllisonsExcellentAdventure;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cards.Card;

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
	
	public String makeThisCardAString(Card c){
		
		//this is essentially the card.toString() you asked for
		
		String s = ""+c.getClass();
		s = s.substring(12, s.length()-4);
		
		for(int x=0; x<s.length(); x++){
			
			if(x!=0 && Character.isUpperCase(s.charAt(x))){
				
				s = s.substring(0,x) + " " + s.substring(x);
				x++;
				
			}
			
		}
		
		return s;
	}
}
