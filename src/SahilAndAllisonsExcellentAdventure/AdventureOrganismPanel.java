package SahilAndAllisonsExcellentAdventure;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.*;
import cards.Card;
public class AdventureOrganismPanel extends JPanel{
	private ArrayList<JButton> cardButtons;
	private ArrayList<Card> cards;
	private AdventureGame g;
	AdventureOrganismPanel(AdventureGame G){
		cardButtons = new ArrayList<JButton>();
		cards = new ArrayList<Card>();
		g=G;
		this.setLayout(new GridLayout(4,3));
		for(int col=0;col<3;col++){
			for(int row=0;row<4;row++){
				JButton button = new JButton();
				cardButtons.add(button);
				this.add(button);
			}
		}
	}
	public void addCard(Card c){
		if(cards.size()<12){
			cards.add(c);
			System.out.println("Added Card");
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
			System.out.println(cards.get(i));
			ImageIcon cardArt = new ImageIcon(cards.get(i).getCardArt());
			cardButtons.get(i).setIcon(cardArt);
		}
	}
}