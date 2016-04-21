package client;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class GameScreen extends JPanel{

	
	public static final int DRAW_CARDS=0, BUILD_ORG=1, PLAY_CARDS=2;
			
	private int gameState=DRAW_CARDS;

	
	private static final long serialVersionUID = 1L;
	public GameScreen()
	{
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		//Paint base game
	}

}
