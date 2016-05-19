package data;

import java.util.ArrayList;
import cards.*;

public class Player {
	
	private Hand hand;
	private ArrayList<Organism> organisms; 
	private int numCardsToDraw;
	private int numOrganisms;
	private int numCytoplasm;
	private int totalATP;
	private int totalTox;
	private int bufferATP=0;
	private int bufferTox=0;
	
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
	
	public int getTotalATP()
	{
		totalATP =0;
		for(Organism o :organisms)
		{
			totalATP +=o.getATP();
		}
		return totalATP + bufferATP;
	}
	
	public int getTotalToxin()
	{
		totalTox=0;
		for(Organism o : organisms)
		{
			totalTox += o.getToxin();
		}
		return totalTox + bufferTox;
	}
	
	public void resetBuffers()
	{
		bufferATP =0;
		bufferTox=0;
	}
	
	public void spendATP(int x)
	{
		bufferATP-=x;
	}
	
	public void awakenAll()
	{
		for(Organism o : organisms)
		{
			for(int x=0; x<o.getHeight();x++)
			{
				for(int y=0; y<o.getWidth();y++)
				{
					BuilderCard b = o.getCardAt(x, y);
					if(b != null)
					{
						b.activateCard();
					}
				}
			}
			o.resetATPToxin();
		}
	}
	
	public void refreshOrgs()
	{
		for(Organism o: organisms)
		{
			o.updateOrganism();
		}
	}
}
