package SahilAndAllisonsExcellentAdventure;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

import client.*;
import data.*;
import cards.*;
import data.ImagePath;
public class AdventureOrganismPanel extends JPanel{
	private ArrayList<adventureCardButton> cardButtons;
	private ArrayList<Card> cards;
	private AdventureGame g;
	private int selectedIndex;
	AdventureOrganismPanel(AdventureGame G){
		cardButtons = new ArrayList<adventureCardButton>();
		cards = new ArrayList<Card>();
		g=G;
		int count = 0;
		this.setLayout(new GridLayout(4,3));
		for(int col=0;col<3;col++){
			for(int row=0;row<4;row++){
				final adventureCardButton button = new adventureCardButton(count);
				count++;
				button.setPreferredSize(new Dimension(170,170));
				cardButtons.add(button);
				button.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						selectedIndex = button.getIndex();
					}
				});
				
				this.add(button);
			}
		}
	}
	public void addCard(Card c){
		if(cards.size()<12){
			cards.add(c);
		}
		repaintGrid();
	}
	public void removeCard(Card c){
		if(cards.contains(c))
			cards.remove(c);
		repaintGrid();
	}
	public void repaintGrid(){
		for(int i=0;i<cards.size();i++){ 
			ImageIcon cardArt = new ImageIcon(cards.get(i).getCardArt());
			cardButtons.get(i).setIcon(cardArt);
		}
		for(int i=cards.size();i<12;i++){
			cardButtons.get(i).setIcon(null);
		}
	}
	public Card getSelectedCard(){
		return cards.get(selectedIndex);
	}
}