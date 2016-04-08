package data;

import java.util.ArrayList;
import cards.*;

public class Player {
	private Hand hand;
	private ArrayList<Organism> organisms; 
	private int numCards;
	
	public Player(){
		
		hand = new Hand();
		
		organisms = new ArrayList<Organism>();
		
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
	
	public int getNumCards(){
		
		return numCards;
		
	}
	
	public void modifyNumCards(int n){
		
		numCards+=n;
		
	}
}
