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
	private AdventureOrganismPanelC computerPanel;
	private AdventureActionPanel actionPanel;
	private AdventureMiddlePanel midPanel;
	protected final int HUMAN_DRAW = 0;
	protected final int HUMAN_PLAY = 1;
	protected final int AI = 2;
	private final String[] states = {"Draw a card", "Play a card", "Computer's turn"};
	private int gameState;
	
	
	public AdventureGame(){
		
		gameFrame = new JFrame();
		gameFrame.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		infoPanel = new AdventureInfoPanel(this);
		c.gridx=0;
		c.gridy=0;
		c.gridwidth = 3;
		gameFrame.add(infoPanel,c);
		
		
		playerPanel = new AdventureOrganismPanel(this,"player");
		c.gridx=0;
		c.gridy=1;
		c.gridwidth=1;
		gameFrame.add(playerPanel,c);
		
		midPanel = new AdventureMiddlePanel(this);
		c.gridx=1;
		c.gridy=1;
		gameFrame.add(midPanel,c);
		
		computerPanel = new AdventureOrganismPanelC(this, "Computer");
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
	public AdventureOrganismPanelC getComputerPanel(){
		
		return computerPanel;
		
	}
	
	public AdventureActionPanel getActionPanel(){
		
		return actionPanel;
		
	}
	
	public AdventureInfoPanel getInfoPanel(){
		
		return infoPanel;
		
	}
	
	public String getStateString(){
		
		return states[gameState];
		
	}
	
	public void computerTurn(){
		
		computerPanel.takeTurn();
		
	}
	
	public static void main(String [] args)
	{
		
		new AdventureGame();

	}
	
	
}
