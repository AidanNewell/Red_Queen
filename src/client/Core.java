package client;


import menus.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class Core extends JPanel implements KeyListener, MouseListener, Runnable{

	private Thread thread;
	private MainGUI display;
	public static final int MAIN_MENU = 0, NEW_GAME_MENU=1;
	private static int gameState;
	private static boolean gameStateUpdate = false;
	
	public Core()
	{
		gameState = MAIN_MENU;
		display = new MainMenu();
		this.add(display);
		start();
	}
	
	public void runGame()
	{
		while(true)
		{
			if(gameStateUpdate)
			{
				gameStateUpdate=false;
				updateContent();
			}
			else
			{
				
			}
		}
	}
	
	private void updateContent()
	{
		System.out.println("AA");
		switch(gameState)
		{
		case 0:
			display = new MainMenu();
		case 1:
			display = new GameCreationMenu();
		}
	}
	
	private void start()
	{
		thread = new Thread(this);
		thread.start();
	}
	
	public void run()
	{
		while(true)
		{
			display.repaint();
		}
	}

	public void mouseClicked(MouseEvent arg0)
	{
		
	}

	public void mouseEntered(MouseEvent arg0)
	{
		
	}

	public void mouseExited(MouseEvent arg0)
	{
		
	}

	public void mousePressed(MouseEvent arg0)
	{
		
	}

	public void mouseReleased(MouseEvent arg0)
	{
		
	}

	public void keyPressed(KeyEvent arg0)
	{
		
	}

	public void keyReleased(KeyEvent arg0)
	{
		
	}

	public void keyTyped(KeyEvent arg0)
	{
		
	}

	public static void updateGameState(int i)
	{
		gameState = i;
		gameStateUpdate = true;
	}
}
