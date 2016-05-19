package data;

import java.util.ArrayList;
import cards.*;

public class Player {
	
	private Hand hand;
	private ArrayList<Organism> organisms; 
	private int numCardsToDraw;
	private int numOrganisms;
	private int numCytoplasm;
	
	public Player(){
		
		hand = new Hand();
		organisms = new ArrayList<Organism>();
		numOrganisms=4;
		numCardsToDraw = 3;
		numCytoplasm=1;
	}
	
	
	public void drawCards(int index){
		if(index == Card.CYTOPLASM_CARD)
		{
			hand.addCard(CardLoader.getCytoplasmCard());
		}
		if(index == Card.ORGANISM_CARD)
		{
			hand.addCard(CardLoader.getOrganismCard());
		}
		if(index == Card.PETRI_DISH_CARD)
		{
			hand.addCard(CardLoader.getPetriCard());
		}
	}
	
	public void updatePlayer()
	{
		numCardsToDraw=2;
		for(Organism o : organisms)
		{
			int x = o.getCardsToDraw();
			if(x > 0)
				numCardsToDraw+=x;
		}
	}
	
	public int getNumOrganisms()
	{
		return organisms.size();
	}
	
	public void newOrganism(Organism o)
	{
		organisms.add(o);
	}
	
	public boolean isNewOrgValid()
	{
		return numOrganisms>=organisms.size();
	}
	
	public void clearHand()
	{
		hand.getHand().clear();
	}
	
	public Alert playCard(PlayerDataComplex c)
	{
		return hand.playCardAt(c);
	}
	
	public Hand getHand()
	{
		return hand;
	}
	
	public int getCardsToDraw()
	{
		return numCardsToDraw;
	}
	
	public void updateAllOrganisms()
	{
		for(Organism o: organisms)
		{
			o.updateOrganism();
		}
		
	}
	
	public ArrayList<Organism> getOrganisms()
	{
		return organisms;
	}
	
	public int getCytoToPlay()
	{
		return numCytoplasm;
	}
}
