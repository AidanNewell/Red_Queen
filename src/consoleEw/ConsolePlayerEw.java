package consoleEw;

import java.util.ArrayList;
import java.util.Scanner;

import cards.Card;
import cards.CardLoader;
import data.Hand;
import data.Organism;
import data.Player;
import cards.*;

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
		CardLoader.init();
		
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
		int e=0,f=0,g = 5;
		while((e+f+g)!=3){
			System.out.println("Enter the number of Organism Cards to draw: ");
			e = s.nextInt();
			System.out.println("Enter the number of Cytoplasm Cards to draw: ");
			f = s.nextInt();
			System.out.println("Enter the number of Petri Dish Cards to draw: ");
			g = s.nextInt();
		}
		drawCards(e,f,g);
		displayHand();
		System.out.println("Enter the number of the card you want to use: ");
		int v = s.nextInt();
		Card card = hand.getHand().get(v-1);
		switch(card.getCardType()){
		
		case 1 :

			//System.out.println(organisms.size());
			((OrganismStarter) card).performAction(null,this);
			//System.out.println(organisms.size());
			break;
			
		case 2 :
			
			System.out.println("You have to pick an organism to add this card to");
			displayOrganisms();
			System.out.println("Select the organism to add the card to: ");
			organisms.get(s.nextInt()-1).addCard(0, 0, (BuilderCard) card); 
			
			
			break;
			
		case 3 :
			
			
			
			
			break;
			
		}
	}
	
	public void displayHand(){
		
		System.out.println("Your hand: ");
		
		for(Card c : hand.getHand()){
			
			System.out.print(c.getClass() +", ");
			System.out.println("");
		}
		
		
	}
	
	public void displayOrganisms(){
		
	System.out.println("Your organisms: ");
		
		for(Organism o : organisms){
			
			System.out.print(o.getClass() +", ");
			System.out.println("");
		}
		
	}
	
}
