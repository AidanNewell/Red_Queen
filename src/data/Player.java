package data;

import java.util.ArrayList;
import cards.*;

public class Player {
	private Hand hand;
	private ArrayList<Organism> organisms; 
	private int numCardsToDraw;
	private int numOrganisms;
	
	public Player(){
		
		hand = new Hand();
		organisms = new ArrayList<Organism>();
		numOrganisms=4;
		numCardsToDraw = 3;
	}
	
	
	public void drawCards(int a, int  b, int c){
		for(int x=0; x<a; x++){
			
			hand.addCard(CardLoader.getOrganismCard());
			
		}
		for(int x=0; x<b; x++){
			
			hand.addCard(CardLoader.getCytoplasmCard());
			
		}
		for(int x=0; x<c; x++){
			
			hand.addCard(CardLoader.getPetriCard());
			
		}
		
	}
	
	public int updatePlayer()
	{
		for(Organism o : organisms)
		{
			
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
		return numOrganisms>organisms.size();
	}
}
