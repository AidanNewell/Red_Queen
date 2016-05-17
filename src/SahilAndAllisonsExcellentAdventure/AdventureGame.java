package SahilAndAllisonsExcellentAdventure;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class AdventureGame {
	
	private JFrame gameFrame;
	private AdventureOrganismPanel playerPanel;
	private AdventureOrganismPanel computerPanel;
	private AdventureActionPanel actionPanel;
	private AdventureMiddlePanel midPanel;
	private static final int HUMAN = 0;
	private static final int AI = 1;
	private int turn;
	
	
	public AdventureGame(){
		
		gameFrame = new JFrame();
		gameFrame.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		playerPanel = new AdventureOrganismPanel(this);
		c.gridx=0;
		c.gridy=0;
		gameFrame.add(playerPanel);
		
		midPanel = new AdventureMiddlePanel(this);
		c.gridx=1;
		c.gridy=0;
		gameFrame.add(midPanel);
		
		computerPanel = new AdventureOrganismPanel(this);
		c.gridx=2;
		c.gridy=0;
		gameFrame.add(computerPanel);
		
		actionPanel = new AdventureActionPanel(this);
		c.gridx=0;
		c.gridy=1;
		c.gridwidth=3;
		gameFrame.add(actionPanel);
		
		
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
