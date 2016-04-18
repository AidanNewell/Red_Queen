package consoleEw;

import data.Game;

public class ConsoleGameEw extends Game{
	
	
	public ConsoleGameEw(){
		
		setUpGame();
		
		
	}
	
	
	public void setUpGame(){
		
		new ConsolePlayerEw();
		
		
	}
	
	
	public void startGame(){
		
		
	}


	public static void main(String[] args){
	
		new ConsoleGameEw();
	
	}

}
