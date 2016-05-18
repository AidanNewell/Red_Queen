package SahilAndAllisonsExcellentAdventure;
import java.awt.Dimension;

import javax.swing.*;
public class AdventureInfoPanel extends JPanel{
	private JLabel playerHealth;
	private JLabel playerATP;
	private JLabel gamePhase;
	private JLabel compHealth;
	private JLabel compATP;
	private AdventureGame game;
	private AdventurePlayer player;
	private AdventurePlayer comp;
	public AdventureInfoPanel(AdventureGame game, AdventurePlayer player, AdventurePlayerC comp){
		this.game = game;
		this.player = player;
		this.comp = comp;
		playerHealth = new JLabel("Health: " + 20);
		playerATP = new JLabel("ATP: " + 20);
		gamePhase = new JLabel("Draw a Card");
		compHealth = new JLabel("Health: " + 20);
		compATP = new JLabel("ATP: " + 20);
		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		this.add(Box.createRigidArea(new Dimension(40,0)));
		this.add(playerHealth);
		this.add(Box.createRigidArea(new Dimension(40,0)));
		this.add(playerATP);
		this.add(Box.createRigidArea(new Dimension(380,0)));
		this.add(gamePhase);
		this.add(Box.createRigidArea(new Dimension(380,0)));
		this.add(compHealth);
		this.add(Box.createRigidArea(new Dimension(40,0)));
		this.add(compATP);
	}
	public void updateLabels(){
		
	}
}
