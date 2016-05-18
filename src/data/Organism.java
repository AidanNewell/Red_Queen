package data;

import java.awt.Image;

import client.GameScreen;
import cards.*;


public class Organism {

	BuilderCard[][] organismBody;
	private int totalToxin;
	private int totalATP;
	private int totalRes;
	private int bufferDrawCards;
	private Image organismDisplay;
	
	
	public Organism(int[] HW)
	{
		organismBody = new BuilderCard[HW[0]][HW[1]];
		bufferDrawCards=1;
	}
	
	public int getToxin()
	{
		return totalToxin;
	}
	
	public int getATP()
	{
		return totalATP;
	}
	
	public int getRes()
	{
		return totalRes;
	}
	
	public void updateOrganism()
	{
		totalToxin=0;
		totalATP=0;
		totalRes=0;
		for(int x=0; x<organismBody.length;x++)
		{
			for(int y=0; y<organismBody[0].length;y++)
			{
				if(organismBody[x][y]!=null)
				{
					BuilderCard current = organismBody[x][y];
					int modifier = current.getToxin() - current.getBufferToxin();
					if(modifier > 0)
						totalToxin+=modifier;
					modifier = current.getATP() - current.getBufferATP();
					if(modifier > 0)
						totalATP+=modifier;
					modifier=current.getRes()-current.getBufferRes();
					if(modifier > 0)
						totalRes+=modifier;
					current.turnTaken();
				}
				
			}
		}
	}
	
	public void addCard(int x, int y, BuilderCard c)
	{
		organismBody[x][y] = c;
	}
	
	public boolean isOccupied(int x, int y) throws IndexOutOfBoundsException
	{
		return organismBody[x][y]!=null;
	}
	
	public BuilderCard getCardAt(int a, int b){
		
		return organismBody[a][b];
	}
	
	public void killOrganelle(int x, int y)
	{
		organismBody[x][y].killCard(this, x, y);
	}
	
	public void modifyBufferDraw(int a)
	{
		bufferDrawCards += a;
	}
	
	public int getCardsToDraw()
	{
		return bufferDrawCards;
	}
	
	public int getHeight()
	{
		return organismBody.length;
	}
	
	public int getWidth()
	{
		return organismBody[0].length;
	}
	
	public void attemptAddCard(int x, int y)
	{
		Card c = GameScreen.MOUSE.getCard();
		if( c == null)
		{
			
		}
		else if(c.getCardType() == Card.BUILDER)
		{
			organismBody[x][y] = (BuilderCard)GameScreen.MOUSE.getCard();
		}
	}
	
}
