package SahilAndAllisonsExcellentAdventure;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;

import cards.CardLoader;
import data.ImagePath;

public class AdventureGame {
	
	private JFrame gameFrame;
	private AdventureOrganismPanel playerPanel;
	private AdventureOrganismPanel computerPanel;
	private AdventureActionPanel actionPanel;
	private AdventureMiddlePanel midPanel;
	protected final int HUMAN_DRAW = 0;
	protected final int HUMAN_PLAY = 1;
	protected final int AI = 2;
	private int gameState;
	
	
	public AdventureGame(){
		
		gameFrame = new JFrame();
		gameFrame.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		playerPanel = new AdventureOrganismPanel(this, "User");
		c.gridx=0;
		c.gridy=0;
		gameFrame.add(playerPanel);
		
		midPanel = new AdventureMiddlePanel(this,playerPanel);
		c.gridx=1;
		c.gridy=0;
		gameFrame.add(midPanel);
		
		computerPanel = new AdventureOrganismPanel(this, "Computer");
		c.gridx=2;
		c.gridy=0;
		gameFrame.add(computerPanel);
		
		actionPanel = new AdventureActionPanel(this,playerPanel);
		c.gridx=0;
		c.gridy=1;
		c.gridwidth=3;
		gameFrame.add(actionPanel);
		
		gameFrame.pack();
		gameFrame.setVisible(true);
		
		startGame();
		
	}
	
	public void turn(int who){ //allison what were you actually thinking here
		
		
		
	}
	
	public void startGame(){
		CardLoader.init();
		ImagePath.init();
		gameState = HUMAN_DRAW;
		
		gameFrame.setDefaultLookAndFeelDecorated(true);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setVisible(true);
		
	}
	
	public void nextPhase(){
		
		if(gameState==HUMAN_DRAW)
			gameState=HUMAN_PLAY;
		else if(gameState==HUMAN_PLAY)
			gameState=AI;
		else if(gameState==AI)
			gameState=HUMAN_DRAW;
	}
	
	public int getGameState(){
		
		return gameState;
		
	}
	
	public static void main(String [] args)
	{
		
		new AdventureGame();

	}
	
	
}
