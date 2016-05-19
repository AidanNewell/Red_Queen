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
	public AdventureInfoPanel(AdventureGame game){
		this.game = game;
		playerHealth = new JLabel("Health: " + 5);
		playerATP = new JLabel("ATP: " + 5);
		gamePhase = new JLabel("Draw a Card");
		compHealth = new JLabel("Health: " + 5);
		compATP = new JLabel("ATP: " + 5);
		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		this.add(Box.createRigidArea(new Dimension(40,0)));
		this.add(playerHealth);
		this.add(Box.createRigidArea(new Dimension(40,0)));
		this.add(playerATP);
		this.add(Box.createRigidArea(new Dimension(380,0)));//this was also 380
		this.add(gamePhase);
		this.add(Box.createRigidArea(new Dimension(380,0)));//this was 380
		this.add(compHealth);
		this.add(Box.createRigidArea(new Dimension(40,0)));
		this.add(compATP);
	}
	public void updateLabels(){
		playerHealth.setText("Health: "  + game.getPlayerPanel().getHealth());
		playerATP.setText("ATP: "+ game.getPlayerPanel().getATP());
		gamePhase.setText(game.getStateString());
		compHealth.setText("Health: " + game.getComputerPanel().getHealth());
		compATP.setText("ATP: " + game.getComputerPanel().getATP());
	}
	public void displayError(String s){
		gamePhase.setText(s);
	}
}
