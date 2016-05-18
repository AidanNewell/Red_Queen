package SahilAndAllisonsExcellentAdventure;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;

import cards.CardLoader;
import data.ImagePath;

public class AdventureGame {
	
	private JFrame gameFrame;
	private AdventureInfoPanel infoPanel;
	private AdventureOrganismPanel playerPanel;
	private AdventureOrganismPanel computerPanel;
	private AdventureActionPanel actionPanel;
	private AdventureMiddlePanel midPanel;
	private AdventurePlayer player;
	private AdventurePlayerC comp;
	protected final int HUMAN_DRAW = 0;
	protected final int HUMAN_PLAY = 1;
	protected final int AI = 2;
	private int gameState;
	
	
	public AdventureGame(){
		
		gameFrame = new JFrame();
		gameFrame.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		player = new AdventurePlayer("User");
		comp = new AdventurePlayerC("Comp");
		
		infoPanel = new AdventureInfoPanel(this,player,comp);
		c.gridx=0;
		c.gridy=0;
		c.gridwidth = 3;
		gameFrame.add(infoPanel,c);
		
		
		playerPanel = new AdventureOrganismPanel(this, "User", player);
		c.gridx=0;
		c.gridy=1;
		c.gridwidth=1;
		gameFrame.add(playerPanel,c);
		
		midPanel = new AdventureMiddlePanel(this,playerPanel);
		c.gridx=1;
		c.gridy=1;
		gameFrame.add(midPanel,c);
		
		computerPanel = new AdventureOrganismPanel(this, "Computer",comp);
		c.gridx=2;
		c.gridy=1;
		gameFrame.add(computerPanel,c);
		
		actionPanel = new AdventureActionPanel(this,playerPanel);
		c.gridx=0;
		c.gridy=2;
		c.weightx = 0.0;
		c.gridwidth=3;
		gameFrame.add(actionPanel,c);
		
		gameFrame.pack();
		gameFrame.setVisible(true);
		
		startGame();
		
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
	
	
	public AdventureOrganismPanel getPlayerPanel(){
		
		return playerPanel;
		
	}
	public AdventureOrganismPanel getComputerPanel(){
		
		return computerPanel;
		
	}
	
	public AdventureActionPanel getActionPanel(){
		
		return actionPanel;
		
	}
	
	public static void main(String [] args)
	{
		
		new AdventureGame();

	}
	
	
}
