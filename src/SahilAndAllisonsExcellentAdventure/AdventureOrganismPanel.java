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
	private AdventurePlayer player;
	private AdventureGame g;
	private int selectedIndex;
	private String name;
	private int health;
	private int ATP;
	private int drawnCount;
	private boolean selectCard;
	
	
	AdventureOrganismPanel(AdventureGame G, String s){
		
		name=s;
		cardButtons = new ArrayList<adventureCardButton>();
		cards = new ArrayList<Card>();
		g=G;
		int count = 0;
		this.setLayout(new GridLayout(4,3));
		health = 5;
		ATP = 5;
		
		for(int col=0;col<3;col++){
			for(int row=0;row<4;row++){
				final adventureCardButton button = new adventureCardButton(count);
				count++;
				cardButtons.add(button);
				
				button.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						if(g.getGameState() == g.HUMAN_PLAY&& button.getIcon()!=null){
							selectedIndex = button.getIndex();
							selectCard = true;
							g.getActionPanel().setSelectedCard();
						}
					}
				});	
				this.add(button);
			}
		}
	}
	
	public String getName(){
		
		return name;
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
		if(cards.get(selectedIndex)!=null)
			return cards.get(selectedIndex);
		return null;
	}
	public int getHealth(){
		return health;
	}
	public void changeHealth(int change){
		health+=change;
	}
	public int getATP(){
		return ATP;
	}
	public void changeATP(int change){
		ATP+=change;
	}
	public ArrayList<Card> getCards(){
		return cards;
	}
	public void addDrawn(){
		drawnCount++;
	}
	public void resetDrawn(){
		drawnCount = 0;
	}
	public int getDrawn(){
		return drawnCount;
	}
	public boolean isSelected(){
		return selectCard;
	}
	public void unSelect(){
		selectCard = false;
	}
}