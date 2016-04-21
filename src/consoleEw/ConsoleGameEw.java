package consoleEw;

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
			
			if(p.getNumOrganisms()==0){
				
				gameOver = true;
				System.out.println("Computer Wins!");
				
			}else if(c.getNumOrganisms()==0){
				
				gameOver = true;
				System.out.println(p.getPlayerName() +" Wins!");
				
			}
			
			
			
		}
		
		
		
		
	}


	public static void main(String[] args){
	
		new ConsoleGameEw();
	
	}

}
