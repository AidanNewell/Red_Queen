package client;

import java.awt.Image;

import cards.Card;

public class MouseImageBox {

	
	private Card c;
	public Image mouseImage;
	
	public int X = 0,Y = 0;
	
	public MouseImageBox()
	{
		
	}
	
	public void setImage(Image i)
	{
		mouseImage = i;
	}
	
	public void setCard(Card c)
	{
		this.c = c;
		mouseImage = c.getCardArt();
	}
	
	public Card getCard()
	{
		Card returned = c;
		c = null;
		return returned;
	}
}
