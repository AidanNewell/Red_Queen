package consoleEw;

import java.util.ArrayList;
import java.util.Scanner;

import cards.CardLoader;
import data.Hand;
import data.Organism;
import data.Player;

public class ConsolePlayerEw extends Player{

	private Hand hand;
	private ArrayList<Organism> organisms; 
	private int numCardsToDraw;
	private int numOrganisms;
	private String playerName;
	Scanner s;
	
	
	public ConsolePlayerEw(){
		
		hand = new Hand();
		organisms = new ArrayList<Organism>();
		numOrganisms=4;
		numCardsToDraw = 3;
		 s = new Scanner(System.in);
		System.out.println("What is your name?");
		String w = s.nextLine();
		playerName = w;
		
	}
	
	
	public void drawCards(int a, int  b, int c){
		for(int x=0; x<a; x++){
			
			hand.addCard(CardLoader.getOrganismCard());
			
		}
		for(int x=0; x<b; x++){
			
			hand.addCard(CardLoader.getCytoplasmCard());
			
		}
		for(int x=0; x<c; x++){
			
			hand.addCard(CardLoader.getPetriCard());
			
		}
		
	}
	
	public void updatePlayer()
	{
		numCardsToDraw=2;
		for(Organism o : organisms)
		{
			int x = o.getCardsToDraw();
			if(x > 0)
				numCardsToDraw+=x;
		}
	}
	
	public int getNumOrganisms()
	{
		return organisms.size();
	}
	
	public void newOrganism(Organism o)
	{
		organisms.add(o);
	}
	
	public boolean isNewOrgValid()
	{
		return numOrganisms>=organisms.size();
	}
	
	public void clearHand()
	{
		hand.getHand().clear();
	}
	
	
	public String getPlayerName(){
		
		return playerName;
	}
	public void takeTurn(){
		int e,f,g;
		System.out.println("Enter the number of Organism Cards to draw: ");
		e = s.nextInt();
		
	}
	
}
