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
	
	public Core()
	{
		display = new MainMenu();
		this.add(display);
		start();
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

}
