package consoleEw;

import cards.BirdFluCard;
import cards.Card;
import cards.CytosolCard;
import cards.KillerTCellCard;
import cards.SmallSquareOrganismCard;
import data.Game;

public class ConsoleGameEw extends Game{
	
	private boolean gameOver = false;
	
	private ConsolePlayerEw p;
	private ConsoleAIEw c;
	public ConsoleGameEw(){
		
		setUpGame();
		startGame();
		
		
	}
	
	
	public void setUpGame(){
		
		p = new ConsolePlayerEw();
		c = new ConsoleAIEw();
		
		
	}
	
	
	public void startGame(){
		
		while(!gameOver){
			
			p.takeTurn();
			c.takeTurn();
			
			if(p.getNumOrganisms()<=0){
				
				gameOver = true;
				System.out.println("Computer Wins! " + p.getNumOrganisms());
				
			}else if(c.getNumOrganisms()<=0){
				
				gameOver = true;
				System.out.println(p.getPlayerName() +" Wins!");
				
			}
			
			
			
		}
		
		
		
		
	}


	public static void main(String[] args){
	/*
		Card c = new BirdFluCard();
		String s = ""+c.getClass();
		s = s.substring(12, s.length()-4);
		

		for(int x=0; x<s.length(); x++){
			
			if((x!=0) && (Character.isUpperCase(s.charAt(x)))){
				System.out.println("a");
				
				s = s.substring(0,x) + " " + s.substring(x);
				x++;
				
			}else{
				
				System.out.println("b");
			}
			
		}
		System.out.print(s+", ");
		*/
		
		
		new ConsoleGameEw();
	
	}

}
