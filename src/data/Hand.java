package data;

import java.util.ArrayList;

import cards.*;

public class Hand {

	private ArrayList<Card> hand;
	
	public Hand(){
		
		hand = new ArrayList<Card>();
		
	}
	
	public ArrayList<Card> getHand(){
		
		return hand;
		
	}
	
}
