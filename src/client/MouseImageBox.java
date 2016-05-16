package client;

import java.awt.Cursor;
import java.awt.Image;

import cards.Card;

public class MouseImageBox {

	private Card c;
	private Image i;
	
	public void setCard(Card c)
	{
		this.c = c;
		i = c.getCardArt();
	}
	
	public Card getCard()
	{
		Card returned = c;
		c= null;
		i = null;
		return returned;
	}
	
	public Image getImage()
	{
		return i;
	}
}
