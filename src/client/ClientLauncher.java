package client;

import javax.swing.JFrame;

public class ClientLauncher {

	private JFrame ClientWindow;
	private boolean fullscreen = false;
	
	
	ClientLauncher()
	{
		ClientWindow = new JFrame("Red Queen");
		ClientWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if(fullscreen)
		{
			ClientWindow.setUndecorated(true);
			ClientWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
		}
		else
		{
			ClientWindow.setUndecorated(false);
			ClientWindow.setSize(1024, 768);
			ClientWindow.setLocationRelativeTo(null);
		}
		//ClientWindow.pack();
		ClientWindow.setResizable(false);
		ClientWindow.setVisible(true);
	}
	
	public static void main(String [] args)
	{
		ClientLauncher Window = new ClientLauncher();
	}
}
