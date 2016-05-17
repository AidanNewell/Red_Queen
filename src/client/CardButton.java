package client;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import cards.Card;

public class CardButton extends JButton{
	
	private int organismX, organismY;
	
	private Card  c;
	
	public CardButton(Card c,ImageIcon i, int x, int y)
	{
		super(i);
		this.c = c;
		organismX = x;
		organismY = y;
	}
	
	public int getX()
	{
		return organismX;
	}
	
	public int getY()
	{
		return organismY;
	}
	
	public Card getCard()
	{
		return c;
	}
	
}