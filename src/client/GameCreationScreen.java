package client;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GameCreationScreen extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public GameCreationScreen()
	{
		JButton singlePlayerGame = new JButton("New Single-player game");
		singlePlayerGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Client.setCard("GAME_SCREEN");
			}
		});
		add(singlePlayerGame);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.fillRect(0, 0, 500, 500);
	}

}
