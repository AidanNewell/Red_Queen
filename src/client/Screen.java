package client;

import java.awt.Canvas;

import javax.swing.JFrame;

public class Screen{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JFrame window;
	
	public Screen(int height, int width, boolean fullScreen, String gameName, Client client)
	{
		window = new JFrame(gameName);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if(fullScreen)
		{
			window.setUndecorated(true);
			window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		}
		else
		{
			window.setUndecorated(false);
			window.setResizable(false);
			window.setSize(width,height);
			window.setLocationRelativeTo(null);
		}
		window.add(client);
		window.setVisible(true);

	}
}
