package SahilAndAllisonsExcellentAdventure;

import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cards.Card;
import cards.*;
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
				selectedCard.setText("No card Selected");
				if(g.getGameState()==g.HUMAN_PLAY){
					if(g.getPlayerPanel().isSelected()){
						BuilderCard card = (BuilderCard) p.getSelectedCard();
						g.getPlayerPanel().changeHealth(card.getRes()+1);
						g.getPlayerPanel().changeATP(card.getATP());
						g.getPlayerPanel().changeATP(-1*card.getCost());
						g.getComputerPanel().changeHealth(-1*card.getToxin());
						g.getInfoPanel().updateLabels();
						p.removeCard(p.getSelectedCard());
						g.getPlayerPanel().unSelect();
					}
				}
			}});
		endTurn = new JButton("End Turn");
		endTurn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(g.getGameState()==g.HUMAN_PLAY){
					g.nextPhase();
					g.computerTurn();
				}
			}
		});
		computerAction = new JLabel("");
		this.add(Box.createRigidArea(new Dimension(40,0)));
		this.add(selectedCard);
		this.add(Box.createRigidArea(new Dimension(70,0)));
		this.add(playCard);
		this.add(Box.createRigidArea(new Dimension(90,0)));
		this.add(endTurn);
		this.add(Box.createRigidArea(new Dimension(220,0)));
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
