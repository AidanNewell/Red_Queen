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
	
	public void addCard(Card c){
		
		hand.add(c);
	}
	
	public Alert playCardAt(PlayerDataComplex c)
	{
		hand.remove(c.getCardIndex());
		return null;
	}
	
}
