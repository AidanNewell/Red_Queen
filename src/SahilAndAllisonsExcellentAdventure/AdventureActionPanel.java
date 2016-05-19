package SahilAndAllisonsExcellentAdventure;

import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import cards.*;
public class AdventureActionPanel extends JPanel{


	private AdventureGame g;
	private AdventureOrganismPanel p;
	private JLabel selectedCard;
	private JButton playCard;
	private JButton endTurn;
	private JButton discardCard;
	private JLabel computerAction;



	public AdventureActionPanel(AdventureGame G, AdventureOrganismPanel P){

		g=G;
		p=P;
		this.setLayout(new BoxLayout(this,BoxLayout.LINE_AXIS));
		selectedCard = new JLabel("No card selected");
		playCard = new JButton("Play Card");
		playCard.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				selectedCard.setText("No card Selected");
				if(g.getGameState()==g.HUMAN_PLAY){
					int playerATP = g.getPlayerPanel().getATP();
					if(g.getPlayerPanel().isSelected()){
						BuilderCard card = (BuilderCard) p.getSelectedCard();
						if(playerATP>=card.getCost()){
							String cardString = makeThisCardAString(card);
							int handSize = g.getPlayerPanel().numCards();
							if(cardString.equals("Helper T Cell")){
								g.getComputerPanel().changeHealth(-1*handSize);
								g.getPlayerPanel().changeHealth(card.getRes()+1);
							}
							else if(cardString.equals("Lymphoctye")){
								g.getPlayerPanel().changeHealth(handSize);
								g.getComputerPanel().changeHealth(-1*card.getToxin());
							}
							else{
								g.getComputerPanel().changeHealth(-1*card.getToxin());
								g.getPlayerPanel().changeHealth(card.getRes()+1);
							}
							g.getPlayerPanel().changeATP(card.getATP());
							g.getPlayerPanel().changeATP(-1*card.getCost());
							g.getInfoPanel().updateLabels();
							p.removeCard(p.getSelectedCard());
							g.getPlayerPanel().unSelect();
						}
						else{
							g.getInfoPanel().displayError("Not enough ATP: choose another card or end turn");
						}
					}
				}
			}});
		discardCard = new JButton("Discard");
		discardCard.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(g.getGameState()==g.HUMAN_PLAY){
					Card selected = g.getPlayerPanel().getSelectedCard();
					g.getPlayerPanel().removeCard(selected);
				}
			}
		});
		endTurn = new JButton("End Turn");
		endTurn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(g.getGameState()==g.HUMAN_PLAY){
					if(g.getComputerPanel().getHealth()<=0){

						g.gameOver();
						g.getInfoPanel().updateLabels();
					}else{

						g.nextPhase();
						g.getInfoPanel().updateLabels();
						g.computerTurn();

					}
				}
			}
		});
		computerAction = new JLabel("");
		//this.add(Box.createRigidArea(new Dimension(0,0)));//40
		this.add(selectedCard);
		//this.add(Box.createHorizontalGlue());
		//this.add(Box.createRigidArea(new Dimension(70,0)));//70
		this.add(playCard);
		//this.add(Box.createHorizontalGlue());
		//this.add(Box.createRigidArea(new Dimension(10,0)));//90
		this.add(discardCard);
		//this.add(Box.createHorizontalGlue());
		this.add(endTurn);
		this.add(Box.createHorizontalGlue());
		//this.add(Box.createRigidArea(new Dimension(40,0)));//220
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
	public void setComputerAction(String s){


		computerAction.setText(s);
	}
}
