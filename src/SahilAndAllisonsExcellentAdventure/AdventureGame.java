package SahilAndAllisonsExcellentAdventure;


import java.awt.GridLayout;

import javax.swing.JFrame;

public class AdventureGame {
	
	private JFrame gameFrame;
	private AdventureOrganismPanel playerPanel;
	private AdventureOrganismPanel computerPanel;
	private AdventureActionPanel actionPanel;
	private static final int HUMAN = 0;
	private static final int AI = 1;
	private int turn;
	
	
	public AdventureGame(){
		
		gameFrame = new JFrame();
		gameFrame.setLayout(new GridLayout(0,3));
		
		playerPanel = new AdventureOrganismPanel(this);
		
	}
	
	public void turn(int who){
		
		
		
	}
	
	public void startGame(){
		
		
	}
	
	public static void main(String [] args)
	{
		
		new AdventureGame();

	}
	
	
}
