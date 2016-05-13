package client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import data.Player;

public class GameScreen extends JPanel
{
	private Player mainPlayer;
	
	public int gameState;
	
	private static final int DRAW_CARDS = 1, BUILD_ORG =2, PLAY_CARDS =3, DISCARD = 4;
	
	private int drawCardsRemaining;
	
	private int screenWidth, screenHeight;
	private JPanel organismPanel;
	
	private ArrayList<OrganismPane> playerOrganisms;
	
	public GameScreen()
	{
		Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
		screenWidth = (int) screenDim.getWidth();
		screenHeight = (int) screenDim.getHeight();
		setLayout(null);
		JButton quitButton = null;
		try{
			Image quitImage = ImageIO.read(new File("assets/X.png"));
			quitButton = new JButton(new ImageIcon(quitImage));
			quitButton.setOpaque(false);
			quitButton.setContentAreaFilled(false);
			quitButton.setBorderPainted(false);
			quitButton.setFocusPainted(false);
		}catch(Exception e){}
		add(quitButton);
		quitButton.setBounds(screenWidth - 50, 0, 50, 50);
		quitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				Client.quitGame();
			}
		});
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		setBackground(new Color(161,244,136));
	}

}