package menus;

import client.Core;

import java.awt.Component;
import java.awt.event.*;

import javax.swing.*;

public class MainMenu extends MainGUI{

	
	public MainMenu()
	{
		setLayout(new BoxLayout( this, BoxLayout.Y_AXIS));
		add(new JLabel(new ImageIcon("assets/BasicTitle.png")));
		JButton newGame = new JButton("New Game");
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Core.updateGameState(Core.NEW_GAME_MENU);
			}
		});
		add(newGame);
		add(new JButton("Options"));
		JButton quit = new JButton("Quit");
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		add(quit);
	}
}
