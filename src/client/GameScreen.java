package client;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import data.Player;

public class GameScreen extends JPanel
{
	private Player mainPlayer;
	
	private int gameState;
	
	private static final int DRAW_CARDS = 1, BUILD_ORG =2, PLAY_CARDS =3, DISCARD = 4;
	
	private int drawCardsRemaining;
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		setBackground(new Color(161,244,136));
	}

}