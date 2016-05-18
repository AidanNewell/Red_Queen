package SahilAndAllisonsExcellentAdventure;

import java.awt.event.*;

import javax.swing.BoxLayout;
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
		this.setLayout(new BoxLayout(this,BoxLayout.LINE_AXIS));
		selectedCard = new JLabel("No card selected");
		playCard = new JButton("Play Card");
		playCard.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//oh crap what goes here??? player stuff changes. what r cards fam? 
				p.removeCard(p.getSelectedCard());
			}
		});
		endTurn = new JButton("End Turn");
		endTurn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				g.nextPhase();
			}
		});
		computerAction = new JLabel("Help");
		this.add(selectedCard);
		this.add(playCard);
		this.add(endTurn);
		this.add(computerAction);
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
	
	public void setSelectedCard(){
		
		String w = makeThisCardAString(g.getPlayerPanel().getSelectedCard());
		selectedCard.setText(g.getPlayerPanel().getName()+" selected "+w);
		
	}
}
