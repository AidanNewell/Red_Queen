package client;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import cards.CardLoader;
import data.*;

public class Client extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Client client;
	private Screen coreScreen;
	private static final int WIDTH = 1024, HEIGHT = 768;
	private boolean renderTick = false;
	
	public Client()
	{
		setLayout(new CardLayout());
		add(new MainMenu(), "MAIN_MENU");
		add(new GameCreationScreen(),"GAME_CREATION");
		add(new GameScreen(), "GAME_SCREEN");
		coreScreen = new Screen(HEIGHT,WIDTH,true,"Red Queen", this);
	}
	
	public static void main(String [] args)
	{
		ImagePath.init();
		CardLoader.init();
		client = new Client();
		GameScreen.init();
		client.runGame();
	}

	public void runGame()
	{
		renderGame();
	}
	
	private void renderGame()
	{
		int delay = 10;
		ActionListener painter = new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				client.repaint();
				client.revalidate();
			}
		};
		new Timer(delay,painter).start();
	}
	
	public static void setCard(String s)
	{
		((CardLayout)(client.getLayout())).show(client,s);
		client.revalidate();
	}
	
	public static void quitGame()
	{
		System.exit(0);//
	}
}
