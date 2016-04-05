package menus;

import javax.swing.*;

public class GameCreationMenu extends MainGUI{

	
	public GameCreationMenu()
	{
		System.out.println("BB");
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		add(new JButton("A test"));
	}
}
