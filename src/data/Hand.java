package data;

import java.util.ArrayList;

public class Hand {

	private ArrayList<Card> hand;
	
	public Hand(){
		
		hand = new ArrayList<Card>();
		
	}
	
	public ArrayList<Card> getHand(){
		
		return hand;
		
	}
	
}
