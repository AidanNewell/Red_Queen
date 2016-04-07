package client;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Client extends Canvas implements Runnable{

	private static Client client;
	private Screen coreScreen;
	private static final int WIDTH = 1024, HEIGHT = 768;
	private Thread thread;
	private boolean renderTick = false;
	
	public Client()
	{
		coreScreen = new Screen(HEIGHT,WIDTH,false,"Red Queen", this);

	}
	
	public static void main(String [] args)
	{
		client = new Client();
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
		BufferStrategy buffer = this.getBufferStrategy();
		if(buffer == null)
		{
			this.createBufferStrategy(2);
			return;
		}
		Graphics graphics = buffer.getDrawGraphics();
		graphics.dispose();
		buffer.show();
		renderTick=false;
	}
}
