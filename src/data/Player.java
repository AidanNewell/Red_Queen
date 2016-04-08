package data;

import java.util.ArrayList;

public class Player {
	private Hand hand;
	private ArrayList<Organism> organisms; 
	private int numCards;
	
	public Player(){
		
	}
	
	
	public void takeTurn(){
		
		
	}
	
	public int getNumCards(){
		
		return numCards;
		
	}
	
	public void modifyNumCards(int n){
		
		numCards+=n;
		
	}
}
