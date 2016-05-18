package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
	public int getOrganismX()
	{
		return organismX;
	}
	
	public int getOrganismY()
	{
		return organismY;
	}
	
	public Card getCard()
	{
		return c;
	}
	
	public void setupHandListener()
	{
		addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				if(GameScreen.gameState != GameScreen.DRAW_CARDS && GameScreen.MOUSE.getCard() == null)
				{
					GameScreen.getPlayer().getHand().getHand().remove(c);
					GameScreen.MOUSE.setCard(c);
					GameScreen.revalidateHand();
				}
			}
		});
	}
	
}