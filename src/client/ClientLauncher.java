package client;

import javax.swing.JFrame;

public class ClientLauncher {

	private static JFrame ClientWindow;
	private static boolean fullscreen = false;
	private static Core core;
	
	public static void main(String [] args)
	{
		ClientWindow = new JFrame("Red Queen");
		core = new Core();
		ClientWindow.add(core);
		ClientWindow.addMouseListener(core);
		ClientWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ClientWindow.setResizable(false);
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
		ClientWindow.setVisible(true);
	}
}
