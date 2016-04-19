package client;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainMenu extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MainMenu()
	{
		JButton game = new JButton("New Game");
		game.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Client.setCard("GAME_CREATION");
			}
		});
		add(game);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.fillRect(0, 0, 500, 500);
	}
}
