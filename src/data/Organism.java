package data;

import cards.*;


public class Organism {

	BuilderCard[][] organismBody;
	private int totalToxin;
	private int totalATP;
	private int totalRes;
	
	
	public Organism(int height, int width)
	{
		organismBody = new BuilderCard[height][width];
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
	
	private void updateOrganism()
	{
		totalToxin=0;
		totalATP=0;
		totalRes=0;
		for(int x=0; x<organismBody.length;x++)
		{
			for(int y=0; y<organismBody[0].length;y++)
			{
				if(organismBody!=null)
				{
					totalToxin+=organismBody[x][y].getToxin();
					totalATP+=organismBody[x][y].getATP();
					totalRes+=organismBody[x][y].getRes();
				}
			}
		}
	}
	
	public void addCard(int x, int y, BuilderCard c)
	{
		organismBody[x][y] = c;
	}
	
	public boolean isOccupied(int x, int y)
	{
		return organismBody[x][y]!=null;
	}
	
	public BuilderCard getCardAt(int a, int b){
		
		if(a<organismBody.length && b<organismBody[0].length){
			return organismBody[a][b];
		}else{
			return null;
		}
		
	}
	
}
