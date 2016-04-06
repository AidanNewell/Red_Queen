package client;

import java.awt.Canvas;

import javax.swing.JFrame;

public class Screen extends Canvas{

	private JFrame window;
	private Thread thread;
	
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
