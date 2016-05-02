package client;

import java.awt.CardLayout;

import javax.swing.JPanel;

import cards.CardLoader;
import data.*;

public class Client extends JPanel implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Client client;
	private Screen coreScreen;
	private static final int WIDTH = 1024, HEIGHT = 768;
	private Thread thread;
	private boolean renderTick = false;
	public static Player player;
	
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
		client = new Client();
		ImagePath.init();
		CardLoader.init();
		player = new Player();
		client.runGame();
	}

	public void runGame()
	{
		thread = new Thread(this);
		thread.start();
		renderGame();
	}
	
	public void run()
	{
		long time1 = System.nanoTime();
		double tickNum = 60;
		double delay = 100000000/tickNum;
		double timeDiff =0;
		long time2;
		while(true)
		{
			time2 = System.nanoTime();
			timeDiff+=(time2-time1)/delay;
			time1=time2;
			if(timeDiff >= 1)
			{
				renderTick=true;
				gameTick();
				timeDiff--;
			}
		}
	}
	
	private void gameTick()
	{
		
	}
	
	private void renderGame()
	{
		while(true)
		{
			if(renderTick)
				client.renderCycle();
		}
	}
	
	private void renderCycle()
	{
		client.repaint();
		client.revalidate();
	}
	
	public static void setCard(String s)
	{
		((CardLayout)(client.getLayout())).show(client,s);
		client.revalidate();
	}
	
	public static void quitGame()
	{
		System.exit(0);
	}
	
	public static void startGame()
	{
		player = new Player();
		GameScreen.initData();
		setCard("GAME_SCREEN");
	}
}
