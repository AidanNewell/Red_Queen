package data;


import client.GameScreen;
import cards.*;


public class Organism {

	BuilderCard[][] organismBody;
	private int totalToxin;
	private int totalATP;
	private int totalRes;
	private int bufferDrawCards;
	
	
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
		//clear buffers
		for(int x=0; x<getHeight();x++)
		{
			for(int y=0; y<getWidth();y++)
			{
				BuilderCard b = organismBody[x][y];
				if(b != null)
				{
					b.resetBuffers();
				}
			}
		}
		for(int x=0; x<getHeight();x++)
		{
			for(int y=0; y<getWidth();y++)
			{
				BuilderCard b = organismBody[x][y];
				if(b!=null)
				{
					b.modifyOrganism(this, x, y);
				}
			}
		}
		totalRes=0;
		for(int x=0; x<organismBody.length;x++)
		{
			for(int y=0; y<organismBody[0].length;y++)
			{
				if(organismBody[x][y]!=null)
				{
					if(organismBody[x][y].active())
					{
						totalRes+=1;
					}
					else
					{
						totalRes+=organismBody[x][y].getRes()+organismBody[x][y].getBufferRes();
					}
				}
			}
		}
	}
	
	public void modifyOrgRes(int x)
	{
		totalRes+=x;
	}
	
	public void modifyOrgTox(int x)
	{
		totalToxin +=x;
	}
	
	public void modifyOrgATP(int x)
	{
		totalATP +=x;
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
	
	public void resetATPToxin()
	{
		totalATP =0;
		totalToxin=0;
	}
	
	public boolean isFull()
	{
		for(int x=0; x<getHeight();x++)
		{
			for(int y=0; y<getWidth();y++)
			{
				if(organismBody[x][y] == null)
					return false;
			}
		}
		return true;
	}
	
}
