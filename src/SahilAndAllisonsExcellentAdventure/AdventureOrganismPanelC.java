package SahilAndAllisonsExcellentAdventure;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import cards.Card;
import cards.CardLoader;

public class AdventureOrganismPanelC extends AdventureOrganismPanel{

	private ArrayList<adventureCardButton> cardButtons;
	private ArrayList<Card> cards;
	private AdventurePlayer player;
	private AdventureGame g;
	private int selectedIndex;
	private String name;
	private int health;
	private int ATP;
	
	
	AdventureOrganismPanelC(AdventureGame G, String s) {
		super(G, s);
		
		name=s;
		cardButtons = new ArrayList<adventureCardButton>();
		cards = new ArrayList<Card>();
		g=G;
		int count = 0;
		this.setLayout(new GridLayout(4,3));
		
		for(int col=0;col<3;col++){
			for(int row=0;row<4;row++){
				final adventureCardButton button = new adventureCardButton(count);
				count++;
				cardButtons.add(button);
				
				button.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						
						if(g.getGameState() == g.HUMAN_PLAY){
							
						selectedIndex = button.getIndex();
						g.getActionPanel().setSelectedCard();
						
						}
					}
				});	
				this.add(button);
			}
		}
	}
	
	
	public void takeTurn(){
		
		int x = (int) Math.random()*2;
		
		if(x==0){
			
			Card cytoCard = CardLoader.getCytoplasmCard();
			addCard(cytoCard);
			
		}else if(x==1){
			
			Card petriCard = CardLoader.getPetriCard();
			addCard(petriCard);
			
		}
		
		repaintGrid();
		
		x = (int) Math.random()*(cards.size());
		
		
	}

}
