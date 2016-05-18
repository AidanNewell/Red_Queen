package SahilAndAllisonsExcellentAdventure;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import cards.BuilderCard;
import cards.Card;
import cards.CardLoader;

public class AdventureOrganismPanelC extends JPanel{

	private ArrayList<adventureCardButton> cardButtons;
	private ArrayList<Card> cards;
	private AdventurePlayer player;
	private AdventureGame g;
	private int selectedIndex;
	private String name;
	private int health;
	private int ATP;
	
	
	AdventureOrganismPanelC(AdventureGame G, String s) {
		
		name=s;
		cardButtons = new ArrayList<adventureCardButton>();
		cards = new ArrayList<Card>();
		g=G;
		int count = 0;
		this.setLayout(new GridLayout(4,3));
		health =5;
		ATP =5;
		
		for(int col=0;col<3;col++){
			for(int row=0;row<4;row++){
				final adventureCardButton button = new adventureCardButton(count);
				count++;
				cardButtons.add(button);
				
				button.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						
						
					
					}
				});	
				this.add(button);
			}
		}
	}
	
	
	public void takeTurn(){
		
		int x = (int) (Math.random()*3);
		
		Card card1, card2;
		
		String cardsDrawn = "";
		
		if(x==0){
		
			card1 = CardLoader.getCytoplasmCard();
			card2 = CardLoader.getCytoplasmCard();
			
			addCard(card1);
			addCard(card2);
			
			cardsDrawn = "Computer drew " + g.getActionPanel().makeThisCardAString(card1) +" and " + g.getActionPanel().makeThisCardAString(card2);
			
		}else if(x==1){
			
			card1 = CardLoader.getPetriCard();
			card2 = CardLoader.getPetriCard();
			
			addCard(card1);
			addCard(card2);
			
			cardsDrawn = "Computer drew " + g.getActionPanel().makeThisCardAString(card1) +" and " + g.getActionPanel().makeThisCardAString(card2);
			
			
		}else if (x==2){
			
			card1 = CardLoader.getCytoplasmCard();
			card2 = CardLoader.getPetriCard();
			
			addCard(card1);
			addCard(card2);
			
			cardsDrawn = "Computer drew " + g.getActionPanel().makeThisCardAString(card1) +" and " + g.getActionPanel().makeThisCardAString(card2);
			
		}
		
		repaintGrid();
		
		
		
		selectedIndex = (int) Math.random()*(cards.size());
		
		BuilderCard card = (BuilderCard) getSelectedCard();
		g.getComputerPanel().changeHealth(card.getRes()+1);
		g.getComputerPanel().changeATP(card.getATP());
		g.getComputerPanel().changeATP(-1*card.getCost());
		g.getPlayerPanel().changeHealth(-1*card.getToxin());
		g.getActionPanel().setComputerAction(cardsDrawn +" and played " + g.getActionPanel().makeThisCardAString(getSelectedCard()) +" - Take your turn now");
		removeCard(getSelectedCard());
		g.nextPhase();
		g.getInfoPanel().updateLabels();
		
		
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

}
