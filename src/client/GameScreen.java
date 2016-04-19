package client;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class GameScreen extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public GameScreen()
	{
		JButton toMain = new JButton("MainTest");
		toMain.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				Client.setCard("MAIN_MENU");
			}
		});
		add(toMain);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.MAGENTA);
		g.fillRect(0, 0, 500, 500);
	}

}
