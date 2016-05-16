package client;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CardButton extends JButton{
	
	private int organismX, organismY;
	
	public CardButton(ImageIcon i, int x, int y)
	{
		super(i);
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
	
}