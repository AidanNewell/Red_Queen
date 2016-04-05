package menus;

import java.awt.Component;

import javax.swing.*;

public class MainMenu extends MainGUI{

	
	public MainMenu()
	{
		setLayout(new BoxLayout( this, BoxLayout.Y_AXIS));
		add(new JLabel(new ImageIcon("assets/BasicTitle.png")));
		add(new JButton("New Game"));
		add(new JButton("Options"));
		add(new JButton("Quit"));
	}
}
